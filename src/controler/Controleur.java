//EDIT
package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import model.ObjetIdentifie;
import model.aventuriers.*;
import model.cartes.*;
import model.cases.*;
import model.cases.Grille;
import static util.Parameters.IMAGES;
import util.Utils;
import view.*;

public class Controleur implements Observer {

    // ON PASSE A 9H ET DEMI
    private ArrayList<Aventurier> joueurs;
    private ArrayList<CarteInondation> piocheInondation;
    private ArrayList<CarteInondation> defausseInondation;
    private ArrayList<CarteTirage> piocheTresor;
    private ArrayList<CarteTirage> defausseTresor;
    private Grille grille;
    private Aventurier jCourant;
    private Aventurier J1;
    private Aventurier J2;
    private Aventurier J3;
    private Aventurier J4;
    private Utils.Commandes action;

    private VueInscription VueI;
    private VuePlateau VueP;
    private VueNiveau VueN;
    private VueAventurier VueJoueur1;
    private VueAventurier VueJoueur2;
    private VueAventurier VueJoueur3;
    private VueAventurier VueJoueur4;

    public Controleur() {

        this.joueurs = new ArrayList<>();

        VueI = new VueInscription();
        VueI.addObserver(this);

        grille = new Grille();
        initialiserPiocheInondation();
        initialiserPiocheTresor();

        VueP = new VuePlateau(grille);
        VueP.addObserver(this);

//        VueN = new VueNiveau(4);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg == Utils.Commandes.VALIDER_JOUEURS) {
            if (VueI.getPseudo1().getText().equals("")
                    || VueI.getPseudo2().getText().equals("")) {
                VueI.write("Pas assez de joueurs");
            } else {
                VueI.terminerInscription();
//                VueP.show();

                J1 = new Explorateur(VueI.getPseudo1().getText(), Utils.Pion.VERT, grille.getTuiles()[3][3]);
                J2 = new Ingénieur(VueI.getPseudo2().getText(), Utils.Pion.ROUGE, grille.getTuiles()[3][3]);
                J1.getCartesEnMain().add(new CarteTresor(Utils.Tresor.CRISTAL));
                J1.getCartesEnMain().add(new CarteTresor(Utils.Tresor.ZEPHYR));
                J1.getCartesEnMain().add(new CarteTresor(Utils.Tresor.CALICE));
                J1.getCartesEnMain().add(new CarteTresor(Utils.Tresor.PIERRE));
                J1.getCartesEnMain().add(new CarteSacsDeSable());
                J1.getCartesEnMain().add(new CarteHelicoptere());
                J1.getCartesEnMain().add(new CarteHelicoptere());
                J1.getCartesEnMain().add(new CarteHelicoptere());
                J1.getCartesEnMain().add(new CarteHelicoptere());

                this.joueurs.add(J1);
                VueJoueur1 = new VueAventurier(J1);
                VueJoueur1.addObserver(this);

                this.joueurs.add(J2);
                VueJoueur2 = new VueAventurier(J2);
                VueJoueur2.addObserver(this);

                if (!VueI.getPseudo3().getText().equals("")) {
                    J3 = new Messager(VueI.getPseudo3().getText(), Utils.Pion.JAUNE, grille.getTuiles()[3][4]);
                    this.joueurs.add(J3);
                    VueJoueur3 = new VueAventurier(J3);
                    VueJoueur3.addObserver(this);
                } else {
                    VueJoueur3 = null;
                }

                if (!VueI.getPseudo4().getText().equals("")) {
                    J4 = new Pilote(VueI.getPseudo4().getText(), Utils.Pion.VIOLET, grille.getTuiles()[3][4]);
                    this.joueurs.add(J4);
                    VueJoueur4 = new VueAventurier(J4);
                    VueJoueur4.addObserver(this);
                } else {
                    VueJoueur4 = null;
                }

                jCourant = this.joueurs.get(0);
                this.vueCourante().show();
            }

        } else if (arg == Utils.Commandes.BOUGER) {
            VueI.write("Vous êtes actuellement sur la tuile : " + jCourant.getPosition().getNomTuile());
            if (jCourant.getPtsAction() > 0) {

                if (getTuilesDispoBouger(jCourant).size() > 0) {
                    action = Utils.Commandes.BOUGER;
                    
                } else {
                    VueI.write("Le joueur ne peut pas se déplacer");
                }
            }
        } else if (arg == Utils.Commandes.ASSECHER) {
            if (jCourant.getPtsAction() > 0) {
                if (getTuilesDispoAssecher(jCourant).size() > 0) {
                    //demander quelle tuile il veut assecher (IHM)
                    Tuile tuile = getTuileChoisie();//méthode IHM
                    //lui afficher les case et lui faire chosir une case (IHM)
                    for (int i = 0; i < getTuilesDispoAssecher(jCourant).size(); i++) {
                        //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                        if (getTuilesDispoAssecher(jCourant).get(i).getId() == tuile.getId()) {
                            jCourant.assecherTuile(getTuilesDispoAssecher(jCourant).get(i));
                            jCourant.actionEffectuee();
                        }
                    }
                } else {
                    //Le joueur ne peut pas assécher de tuiles
                }

                if (jCourant instanceof Ingénieur) {
                    if (getTuilesDispoAssecher(jCourant).size() > 0) {
                        //On lui demande si il veut assecher une deuxième tuile
                        // if oui
                        //demander quelle tuile il veut assecher (IHM)
                        Tuile tuile = getTuileChoisie();//méthode IHM
                        //lui afficher les case et lui faire chosir une case (IHM)
                        for (int i = 0; i < getTuilesDispoAssecher(jCourant).size(); i++) {
                            //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                            if (getTuilesDispoAssecher(jCourant).get(i).getId() == getTuileChoisie().getId()) {
                                jCourant.assecherTuile(getTuilesDispoAssecher(jCourant).get(i));
                            }
                        }
                    }
                }
            }

        } else if (arg == Utils.Commandes.DONNER) {
            this.action = Utils.Commandes.DONNER;
            this.vueCourante().highlightCartes(cartesDonnables());

        } else if (arg instanceof CarteTirage) {
            if (action == Utils.Commandes.DONNER) {
                if (jCourant.getPtsAction() > 0) {
                    ArrayList<Aventurier> joueursDispo = getJoueursDispo();
                    if (joueursDispo.size() > 0) {
                        if (jCourant.getCartesEnMain().size() > 0) { //VERIFIER LES CARTES ACTIONS SPECIALES
                            //demander quelle joueur il veut echanger (IHM)
                            Aventurier receveur = getJoueurChoisi();//méthode IHM
                            //lui afficher les joueur et lui faire chosir un joueur (IHM)
                            for (int i = 0; i < joueursDispo.size(); i++) {
                                //on parcourt la liste des joueurs dispo pour comparer avec celle que le joueur a choisit
                                if (joueursDispo.get(i).getId() == getJoueurChoisi().getId()) {
                                    jCourant.donnerCarte(joueursDispo.get(i), (CarteTirage) arg);
                                    jCourant.actionEffectuee();
                                }
                            }
                        } else {
                            //Le joueur n'a pas de carte à donner
                        }
                    } else {
                        //Le joueur ne peut donner de cartes à aucun joueur
                    }
                }
            } else if (action == Utils.Commandes.JOUER_HELICO || action == Utils.Commandes.JOUER_SDS) {
                VueI.write("jouerCarteActionSpeciale");
                this.jouerCarteActionSpeciale((CarteTirage) arg);
            }
            
        } else if (arg instanceof VueTuile) {
            Tuile tuile = ((VueTuile) arg).getT();
            VueI.write("Tuile choisie : "  + tuile.getNomTuile());
            if (action == Utils.Commandes.BOUGER) {
                    //lui afficher les case et lui faire chosir une case (IHM)
                    for (int i = 0; i < getTuilesDispoBouger(jCourant).size(); i++) {
                        //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                        if (getTuilesDispoBouger(jCourant).get(i).getId() == tuile.getId()) {
                            jCourant.seDeplacer(getTuilesDispoBouger(jCourant).get(i));
                            jCourant.actionEffectuee();
                            VueI.write("Déplacement effectué");
                        }
                    }
            }
            
            
            
        } else if (arg == Utils.Commandes.CHOISIR_TUILE) {

        } else if (arg == Utils.Commandes.RECUPERER_TRESOR) {
            if (jCourant.getPtsAction() > 0) {
                Utils.Tresor t = jCourant.getPosition().getTresor();
                if (tresorDispo(t)) {
                    CarteTresor c = new CarteTresor(t);
                    for (int i = 0; i < 4; i++) {
                        jCourant.defausser(c);
                    }
                    jCourant.gagnerTresor();
                    jCourant.actionEffectuee();
                    t.setDejaPris(true);
                }
            }
        } else if (arg == Utils.Commandes.TERMINER) {
            jCourant.resetPtsAction();
            tirerCarteTresor();
            tirerCarteInondation();
            int num = this.joueurs.indexOf(jCourant);                                       // On récupère le numéro du joueur dans l'ordre du tour
            if (num == this.joueurs.size() - 1) {                                               // Si c'était le dernier joueur
                jCourant = this.joueurs.get(0);                                             // On refait le tour
            } else {
                jCourant = this.joueurs.get(num++);                                           // Sinon on passe au joueur suivant
            }
        } else if (arg instanceof CarteTirage) {

        } else if (arg == Utils.Commandes.DEPLACER) {

        } else if (arg == Utils.Commandes.QUITTER) {
            System.exit(0);

        } else if (arg == Utils.Commandes.JOUER_HELICO) {
            action = Utils.Commandes.JOUER_HELICO;
            VueI.write("sélectionner la carte hélico à jouer");
        } else if (arg == Utils.Commandes.JOUER_SDS) {
            action = Utils.Commandes.JOUER_SDS;
            VueI.write("sélectionner la carte sac de sable à jouer");
        }

//        public void ValidationJoueurs() {
//            Aventurier j1 = new Aventurier
//        }
    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone(); //To change body of generated methods, choose Tools | Templates.
//    }
//    

    /**
     * se défausse de la carte en paramètre puis la place dans la defause de
     * carte
     */
    public void DefausserCarteJoueur(CarteTirage carte) {
        jCourant.getCartesEnMain().remove(carte);
        defausseTresor.add(carte);
        if (carte instanceof CarteHelicoptere || carte instanceof CarteSacsDeSable) {
            boolean use = false;
            Tuile tuileDepart = null;
            Tuile tuileArrivee = null;
            ArrayList<Aventurier> joueursChoisis = new ArrayList<>();

            //Demander utiliser effet
            if (use) {
                if (carte instanceof CarteHelicoptere) {
                    getTuilesDispoHelico();
                    //IHM Mettre tuiles dispo en évidence
                    //Getter la case de départ
                    tuileDepart.getAventuriersDessus();
                    //IHM Mettre les joueurs en évidence     
                    //Getter le ou les joueurs = joueursChoisis
                    getTuilesDispoHelico().remove(tuileDepart);
                    //IHM Mettre les cases arrivées en évidence
                    //Getter la case arrivée
                    useHelico(tuileDepart, tuileArrivee, joueursChoisis);
                }

                if (carte instanceof CarteSacsDeSable) {
                    Tuile tuileAassecher = null;
                    getTuilesDispoSacDeSable();
                    //IHM Mettre les tuiles dispo en évidencee
                    //Getter la case a assecher 
                    useSacDeSable(tuileAassecher);
                }
            }
        }
    }

    /**
     * La méthode choisirCarte permet de retourner la carte que choisit le
     * joueur en fonction des cartes qu'il possède dans sa main.
     *
     * @return
     */
    public CarteTirage choisirCarte() {
        CarteTirage c = null;
        for (int i = 0; i <= jCourant.getCartesEnMain().size(); i++) {

            if (jCourant.getCartesEnMain().get(i).getId() == getCarteChoisie(jCourant).getId()) {
                //getCarteChoisie = > méthode IHM qui demande au joueur quel carte il choisit à Défausser/Echanger
                c = jCourant.getCartesEnMain().get(i);
                //possibilité de mettre un booléen pour optimiser les itérations
            }
        }
        return c;
    }

    public void deroulementJeu() {
        boolean partieFinie = false;
        while (!partieFinie) {
            deroulementTour();
        }
    }

    public void deroulementTour() {
        if (jCourant.getCartesEnMain().size() > 5) {
            while (jCourant.getCartesEnMain().size() > 5) {
                DefausserCarteJoueur(choisirCarte());
            }
            while (jCourant.getPtsAction() > 0) {

            }

            tirerCarteTresor();
            tirerCarteInondation();

            // ACTIONS 
            Utils.Commandes action = Utils.Commandes.QUITTER; // a remplacer par la methode IHM qui rendra l'action 
//BOUGER

            //ASSECHER           
//DONNER            
//RECUPERER TRESOR
        }
    }

    private boolean tresorDispo(Utils.Tresor t) {
        boolean var = false;
        if (jCourant.getPosition().getEtatCourant() != Utils.EtatTuile.COULEE) {
            if (jCourant.getPosition().getTresor() != null) { // Si la tuile sur laquelle le joueur est possède un trésor            
                if (t.isDejaPris()) {
                    if (cartesTresorx4(jCourant, t)) {
                        var = true;
                    }
                }
            }
        }
        return var;
    }

    private boolean cartesTresorx4(Aventurier a, Utils.Tresor t) {
        int i = 0;
        CarteTresor te = new CarteTresor(t);
        for (CarteTirage c : a.getCartesEnMain()) {
            if (te.getNomCarte() == c.getNomCarte()) {
                i++;
            }
        }
        return i == 4;
    }

    private CarteTirage getCarteChoisie(Aventurier jCourant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Tuile getTuileChoisie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * retourne les case inondée possible a assecher
     *
     * @param jCourant
     * @return
     */
    private Aventurier getJoueurChoisi() { // methode ihm 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initialiserPiocheInondation() {

        this.piocheInondation = new ArrayList<>();

        piocheInondation.add(new CarteInondation("Héliport", IMAGES + "Heliport.png"));
        piocheInondation.add(new CarteInondation("La Caverne des Ombres", IMAGES + "LaCaverneDesOmbres.png"));
        piocheInondation.add(new CarteInondation("La Forêt Pourpre", IMAGES + "LaFpretPourpre.png"));
        piocheInondation.add(new CarteInondation("La Porte de Bronze", IMAGES + "LaForetDeBronze.png"));
        piocheInondation.add(new CarteInondation("La Porte de Fer", IMAGES + "LaPorteDeFer.png"));
        piocheInondation.add(new CarteInondation("La Tour de Guet", IMAGES + "LaTourDeGuet.png"));
        piocheInondation.add(new CarteInondation("Le Jardin des MurMures", IMAGES + "LeJardinDesMurmures.png"));
        piocheInondation.add(new CarteInondation("Le Marais Brumeux", IMAGES + "LeMaraisBrumeux.png"));
        piocheInondation.add(new CarteInondation("Le Palais des Marées", IMAGES + "LePalaisDesMarees.png"));
        piocheInondation.add(new CarteInondation("Le Rocher Fantôme", IMAGES + "LeRocherFantome.png"));
        piocheInondation.add(new CarteInondation("Les Falaises de L'Oubli", IMAGES + "LesFalaisesDeLOubli.png"));
        piocheInondation.add(new CarteInondation("Le Temple du Soleil", IMAGES + "LeTempleDuSoleil.png"));
        piocheInondation.add(new CarteInondation("L'Observatoire", IMAGES + "Observatoire.png"));
        piocheInondation.add(new CarteInondation("Le Val du Crépuscule", IMAGES + "LeValDuCrepuscule.png"));
        piocheInondation.add(new CarteInondation("Le Temple de la Lune", IMAGES + "LeTempleDeLaLune.png"));
        piocheInondation.add(new CarteInondation("Les Dunes de L'Illusion", IMAGES + "LesDunesDeLIllusion.png"));
        piocheInondation.add(new CarteInondation("Le Pont des Abîmes", IMAGES + "LePontDesAbime.png"));
        piocheInondation.add(new CarteInondation("Le Palais de Corail", IMAGES + "LePalaisDeCorail.png"));
        piocheInondation.add(new CarteInondation("Le Lagon Perdu", IMAGES + "LeLagonPerdu.png"));
        piocheInondation.add(new CarteInondation("Le Jardin des Hurlements", IMAGES + "LeJardinDesHurlements.png"));
        piocheInondation.add(new CarteInondation("La Porte D'Or", IMAGES + "LaPorteDOr.png"));
        piocheInondation.add(new CarteInondation("La Porte de Cuivre", IMAGES + "LaPorteDeCuivre.png"));
        piocheInondation.add(new CarteInondation("La Porte D'argent", IMAGES + "LaPortedArgent.png"));
        piocheInondation.add(new CarteInondation("La Caverne du Brasier", IMAGES + "CaverneDuBrasier.png"));
        for (int i = 0; i < 24; i++) {
            System.out.println("Génération CarteInondation n°" + i + " - ID#" + this.piocheInondation.get(i).getId() + " - " + this.piocheInondation.get(i).getNomCarte());
        }
        Collections.shuffle(this.piocheInondation);
    }

    private void initialiserPiocheTresor() {
        this.piocheTresor = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            piocheTresor.add(new CarteTresor(Utils.Tresor.PIERRE));
        }

        for (int i = 0; i < 5; i++) {
            piocheTresor.add(new CarteTresor(Utils.Tresor.CRISTAL));
        }

        for (int i = 0; i < 5; i++) {
            piocheTresor.add(new CarteTresor(Utils.Tresor.ZEPHYR));
        }
        for (int i = 0; i < 5; i++) {
            piocheTresor.add(new CarteTresor(Utils.Tresor.CALICE));
        }

        this.piocheTresor.add(new CarteMonteeDesEaux());
        this.piocheTresor.add(new CarteMonteeDesEaux());
        //Créer 3 cartes hélico
        this.piocheTresor.add(new CarteHelicoptere());
        this.piocheTresor.add(new CarteHelicoptere());
        this.piocheTresor.add(new CarteHelicoptere());
        //créer 2 cartes sacs de sable
        this.piocheTresor.add(new CarteSacsDeSable());
        this.piocheTresor.add(new CarteSacsDeSable());

        Collections.shuffle(piocheTresor);
    }

    private ArrayList<Tuile> getTuilesDispoHelico() {
        ArrayList<Tuile> casesDispo = new ArrayList<>();
        for (int i = 0; i < grille.getGrille().size(); i++) {
            if (grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.ASSECHEE || grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.INONDEE) {
                casesDispo.add(grille.getGrille().get(i));
            }
        }
        casesDispo.remove(jCourant.getPosition());
        return casesDispo;
    }

    private void useHelico(Tuile tuileDepart, Tuile tuileArrivee, ArrayList<Aventurier> joueurs) {
        for (int i = 0; i < joueurs.size(); i++) {
            joueurs.get(i).setPosition(tuileArrivee);
            tuileDepart.enleverAventurier(joueurs.get(i));
            //Mettre à jour IHM
        }
    }

    private void jouerCarteActionSpeciale(CarteTirage carte) {
        Tuile tuileDepart = null;
        Tuile tuileArrivee = null;
        ArrayList<Aventurier> joueursChoisis = new ArrayList<>();
        if (carte instanceof CarteHelicoptere) {
            getTuilesDispoHelico();
            //IHM Mettre tuiles dispo en évidence
            //Getter la case de départ
            tuileDepart.getAventuriersDessus();
            //IHM Mettre les joueurs en évidence     
            //Getter le ou les joueurs = joueursChoisis
            getTuilesDispoHelico().remove(tuileDepart);
            //IHM Mettre les cases arrivées en évidence
            //Getter la case arrivée
            useHelico(tuileDepart, tuileArrivee, joueursChoisis);
            jCourant.getCartesEnMain().remove(carte);
            defausseTresor.add(carte);
        }

        if (carte instanceof CarteSacsDeSable) {
            Tuile tuileAassecher = null;
            getTuilesDispoSacDeSable();
            //IHM Mettre les tuiles dispo en évidencee
            //Getter la case a assecher 
            useSacDeSable(tuileAassecher);
            jCourant.getCartesEnMain().remove(carte);
            defausseTresor.add(carte);

        }
    }

    private ArrayList<Tuile> getTuilesDispoSacDeSable() {
        ArrayList<Tuile> casesDispo = new ArrayList<>();
        for (int i = 0; i < grille.getGrille().size(); i++) {
            if (grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.INONDEE) {
                casesDispo.add(grille.getGrille().get(i));
            }
        }
        return casesDispo;
    }

    private void useSacDeSable(Tuile tuile) {
        tuile.setEtatCourant(Utils.EtatTuile.ASSECHEE);
    }

    private void tirerCarteTresorDebut() {
        for (int i = 0; i < 2; i++) {
            while (piocheTresor.get(piocheTresor.size() - 1) instanceof CarteMonteeDesEaux) {
                Collections.shuffle(piocheTresor);
            }

            jCourant.getCartesEnMain().add(piocheTresor.get(piocheTresor.size() - 1));
            piocheTresor.remove(piocheTresor.size() - 1);

        }

    }

    private void tirerCarteTresor() {
//        jCourant.getCartesEnMain().add(piocheTresor.get(piocheTresor.size() - 1));
//        piocheTresor.remove(piocheTresor.size() - 1);
//
//        while (defausseTresor.get(defausseTresor.size() - 1) instanceof CarteMonteeDesEaux) {
//            Collections.shuffle(defausseTresor);
//            
//        }
//
//        jCourant.getCartesEnMain().add(piocheTresor.get(piocheTresor.size() - 1));
//        piocheTresor.remove(piocheTresor.size() - 1);
        for (int p = 0; p < 2; p++) {

            if (piocheTresor.get(piocheTresor.size() - 1) instanceof CarteMonteeDesEaux) {
                VueN.setNiveau(VueN.getNiveau() + 1);
                Collections.shuffle(defausseInondation);

                for (int i = 0; i < defausseInondation.size(); i++) { // Pour chaque carte innondation de la défausse, on la déplace dans la pioche
                    piocheInondation.add(defausseInondation.get(i));
                }
                defausseInondation.clear();
            } else {
                jCourant.getCartesEnMain().add(piocheTresor.get(piocheTresor.size() - 1));
            }
        }

    }

    private void tirerCarteInondation() {
        for (int i = 0; i < VueN.getNiveau() + 1; i++) {
            innonder(piocheInondation.get(piocheInondation.size() - 1));
            piocheInondation.remove(piocheInondation.size() - 1);
            defausseInondation.add(piocheInondation.get(piocheInondation.size() - 1));
        }
    }

    private void innonder(CarteInondation carte) {
        for (int i = 0; i < grille.getGrille().size(); i++) {
            if (grille.getGrille().get(i).getNomTuile() == carte.getNomCarte()) {
                if (grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.ASSECHEE) {
                    grille.getGrille().get(i).setEtatCourant(Utils.EtatTuile.INONDEE);
                }
                if (grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.INONDEE) {
                    grille.getGrille().get(i).setEtatCourant(Utils.EtatTuile.COULEE);
                    defausseInondation.remove(carte);
                }
            }

        }
    }

    private ArrayList<Tuile> getTuilesDispoAssecher(Aventurier jCourant) {
        return grille.getAdjacentsAssecher(jCourant);
    }

    /**
     * retourne les case accesible pour se deplacer
     *
     * @param jCourant
     * @return
     */
    private ArrayList<Tuile> getTuilesDispoBouger(Aventurier jCourant) {
        return grille.getAdjacents(jCourant);

    }

    private ArrayList<Aventurier> getJoueursDispo() {
        ArrayList<Aventurier> joueursDispo = joueurs;
        if (jCourant instanceof Messager) {
            joueursDispo.remove(jCourant);
        } else {
            joueursDispo = jCourant.getPosition().getAventuriersDessus();
            joueursDispo.remove(jCourant);
        }
        return joueursDispo;
    }

    private ArrayList<CarteTirage> getCartesActionEnMain() {
        ArrayList<CarteTirage> cartesActionEnMain = new ArrayList<>();
        for (int i = 0; i < jCourant.getCartesEnMain().size(); i++) {
            if (jCourant.getCartesEnMain().get(i) instanceof CarteHelicoptere) {
                cartesActionEnMain.add(jCourant.getCartesEnMain().get(i));
            }

            if (jCourant.getCartesEnMain().get(i) instanceof CarteSacsDeSable) {
                cartesActionEnMain.add(jCourant.getCartesEnMain().get(i));
            }
        }
        return cartesActionEnMain;
    }

    private VueAventurier vueCourante() {
        VueAventurier v = null;
        if (VueJoueur1.getA() == this.jCourant) {
            v = VueJoueur1;
        } else if (VueJoueur2.getA() == this.jCourant) {
            v = VueJoueur2;
        } else if ((VueJoueur3 != null) && (VueJoueur3.getA() == this.jCourant)) {
            v = VueJoueur3;
        } else if ((VueJoueur4 != null) && (VueJoueur4.getA() == this.jCourant)) {
            v = VueJoueur4;
        }
        return v;
    }

    private ArrayList<CarteTirage> cartesDonnables() {
        ArrayList<CarteTirage> donnables = new ArrayList<>();
        for (CarteTirage c : jCourant.getCartesEnMain()) {
            if (!(c instanceof CarteHelicoptere) && !(c instanceof CarteSacsDeSable)) {
                donnables.add(c);
            }
        }
        return donnables;
    }

}