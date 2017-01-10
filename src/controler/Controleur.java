package controler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
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

    private VueInscription VueI;
    private VuePlateau VueP;
    private VueNiveau VueN;
    private VueAventurier VueJoueur1;
    private VueAventurier VueJoueur2;
    private VueAventurier VueJoueur3;
    private VueAventurier VueJoueur4;

    public Controleur() {
        
        
        
        
        
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
                System.out.println("Pas assez de joueurs");
            } else {
                VueI.terminerInscription();
//                VueP.show();

                J1 = new Explorateur(VueI.getPseudo1().getText(), Utils.Pion.VERT, grille.getTuiles()[3][3]);
                VueJoueur1 = new VueAventurier(J1);
                VueJoueur1.addObserver(this);
            }

            //Debut création voir TODO
        } else if (arg == Utils.Commandes.BOUGER) {

        } else if (arg == Utils.Commandes.ASSECHER) {

        } else if (arg == Utils.Commandes.DONNER) {

        } else if (arg == Utils.Commandes.RECUPERER_TRESOR) {

        } else if (arg == Utils.Commandes.TERMINER) {
            jCourant.resetPtsAction();
            int num = this.joueurs.indexOf(jCourant);                                       // On récupère le numéro du joueur dans l'ordre du tour
            if (num == this.joueurs.size()) {                                               // Si c'était le dernier joueur
                jCourant = this.joueurs.get(0);                                             // On refait le tour
            } else {
                jCourant = this.joueurs.get(num++);                                           // Sinon on passe au joueur suivant
            }

        } else if (arg == Utils.Commandes.RECEVOIR) {

        } else if (arg == Utils.Commandes.CHOISIR_CARTE) {

        } else if (arg == Utils.Commandes.CHOISIR_TUILE) {

        } else if (arg == Utils.Commandes.DEPLACER) {

        } else if (arg == Utils.Commandes.VOIR_DEFAUSSE) {

        } else if (arg == Utils.Commandes.QUITTER) {
            System.exit(0);

        } else if (arg == Utils.Commandes.PIOCHER_INONDATION) {
            
        } else if (arg == Utils.Commandes.PIOCHER_TRESOR) {
            
        }
        
        
        
        
        if (o instanceof VueAventurier) {
            
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
        if (carte instanceof CarteHelicoptere || carte instanceof CarteSacsDeSable){
            boolean use = false;
            Tuile tuileDepart = null;
            Tuile tuileArrivee = null;
            ArrayList<Aventurier> joueursChoisis = new ArrayList<>();
            
        //Demander utiliser effet
        if (use){
            if (carte instanceof CarteHelicoptere){
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
            
            if (carte instanceof CarteSacsDeSable){
                Tuile tuileAassecher = null;
                getTuilesDispoSacDeSable();
                //IHM Mettre les tuiles dispo en évidence
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

    public void deroulementTour() {
        if (jCourant.getCartesEnMain().size() > 5) {
//            System.out.println("Entrer un carte parmi les carte dans votre main pour la Défaussé ensuite ");
//            Scanner sc = new Scanner(System.in);
//            String nomcarteaDefausse;
//            nomcarteaDefausse = sc.next();
//            // Pour la version texte mais après on aura un ihm qui nous donnera directement une carte
//            //if(getCarteaDefausse(jCourant).getId()==jCourant.getCartesEnMain().)

            DefausserCarteJoueur(choisirCarte());

            //System.out.println("Resaisir une carte, la carte n'est pas valide ");     
        }

        // ACTIONS 
        Utils.Commandes action = Utils.Commandes.QUITTER;
//BOUGER
        if (jCourant.getPtsAction() > 0) {
        }
        if (action == Utils.Commandes.BOUGER) { //action est un message retourné par une vue
            if (getTuilesDispoBouger(jCourant).size() > 0) {
                //demander quelle tuile il veut aller (IHM)
                Tuile tuile = getTuileChoisie();
                //lui afficher les case et lui faire chosir une case (IHM)
                for (int i = 0; i < getTuilesDispoBouger(jCourant).size(); i++) {
                    //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                    if (getTuilesDispoBouger(jCourant).get(i).getId() == tuile.getId()) {
                        jCourant.seDeplacer(getTuilesDispoBouger(jCourant).get(i));
                        jCourant.actionEffectuee();
                    }

                }
            } else {
                //Le joueur ne peut pas se déplacer
            }
        }

        //ASSECHER           
        if (action == Utils.Commandes.ASSECHER) {
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

//DONNER            
        if (action == Utils.Commandes.DONNER) {
            ArrayList<Aventurier> joueursDispo = jCourant.getPosition().getAventuriersDessus();
            joueursDispo.remove(jCourant);
            if (joueursDispo.size() > 0) {
                if (jCourant.getCartesEnMain().size() > 0) { //VERIFIER LES CARTES ACTIONS SPECIALES
                    //demander quelle joueur il veut echanger (IHM)
                    Aventurier receveur = getJoueurChoisi();//méthode IHM
                    //lui afficher les joueur et lui faire chosir un joueur (IHM)
                    for (int i = 0; i < joueursDispo.size(); i++) {
                        //on parcourt la liste des joueurs dispo pour comparer avec celle que le joueur a choisit
                        if (joueursDispo.get(i).getId() == getJoueurChoisi().getId()) {
                            jCourant.donnerCarte(joueursDispo.get(i), choisirCarte());
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

//RECUPERER TRESOR

        /*


         */
        if (action == Utils.Commandes.RECUPERER_TRESOR) {
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
        return i==4;
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

    private Aventurier getJoueurChoisi() { // methode ihm 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    private void initialiserPiocheInondation() {
    piocheInondation.add(new CarteInondation("Héliport", IMAGES+"Heliport.png"));
    CarteInondation c1 = new CarteInondation("La Caverne des Ombres",IMAGES+"LaCaverneDesOmbres.png") ;
    CarteInondation c2 = new CarteInondation("La Forêt Pourpre",IMAGES+"LaFpretPourpre.png");
    CarteInondation c3 = new CarteInondation("La Porte de Bronze",IMAGES+"LaForetDeBronze.png");
    CarteInondation c4 = new CarteInondation("La Porte de Fer",IMAGES+"LaPorteDeFer.png");
    CarteInondation c5 = new CarteInondation("La Tour de Guet",IMAGES+"LaTourDeGuet.png");
    CarteInondation c6 = new CarteInondation("Le Jardin des MurMures",IMAGES+"LeJardinDesMurmures.png");
    CarteInondation c7 = new CarteInondation("Le Marais Brumeux",IMAGES+"LeMaraisBrumeux.png");
    CarteInondation c8 = new CarteInondation("Le Palais des Marées",IMAGES+"LePalaisDesMarees.png");
    CarteInondation c9 = new CarteInondation("Le Rocher Fantôme",IMAGES+"LeRocherFantome.png");
    CarteInondation c10 = new CarteInondation("Les Falaises de L'Oubli",IMAGES+"LesFalaisesDeLOubli.png");
    CarteInondation c11 = new CarteInondation("Le Temple du Soleil",IMAGES+"LeTempleDuSoleil.png");
    CarteInondation c12 = new CarteInondation("L'Observatoire",IMAGES+"Observatoire.png");
    CarteInondation c13 = new CarteInondation("Le Val du Crépuscule",IMAGES+"LeValDuCrepuscule.png");
    CarteInondation c14 = new CarteInondation("Le Temple de la Lune",IMAGES+"LeTempleDeLaLune.png");
    CarteInondation c15 = new CarteInondation("Les Dunes de L'Illusion",IMAGES+"LesDunesDeLIllusion.png");
    CarteInondation c16 = new CarteInondation("Le Pont des Abîmes",IMAGES+"LePontDesAbime.png");
    CarteInondation c17 = new CarteInondation("Le Palais de Corail",IMAGES+"LePalaisDeCorail.png");
    CarteInondation c18 = new CarteInondation("Le Lagon Perdu",IMAGES+"LeLagonPerdu.png");
    CarteInondation c19 = new CarteInondation("Le Jardin des Hurlements",IMAGES+"LeJardinDesHurlements.png");
    CarteInondation c20 = new CarteInondation("La Porte D'Or",IMAGES+"LaPorteDOr.png");
    CarteInondation c21 = new CarteInondation("La Porte de Cuivre",IMAGES+"LaPorteDeCuivre.png");
    CarteInondation c22 = new CarteInondation("La Porte D'argent",IMAGES+"LaPortedArgent.png");
    CarteInondation c23 = new CarteInondation("La Caverne du Brasier",IMAGES+"CaverneDuBrasier.png");
    
    
        this.piocheInondation = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            System.out.println("Génération CarteInondation n°" + i + " - ID#" + this.piocheInondation.get(i).getId() + " - " + this.piocheInondation.get(i).getNomCarte());
        }
    }

    private void initialiserPiocheTresor() {
        
    }

    private ArrayList<Tuile> getTuilesDispoHelico() {
        ArrayList<Tuile> casesDispo = new ArrayList<>();
        for (int i = 0; i<grille.getGrille().size();i++){
            if (grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.ASSECHEE || grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.INONDEE){
                casesDispo.add(grille.getGrille().get(i));
            }
        }
        casesDispo.remove(jCourant.getPosition());
        return casesDispo;
    }

    private void useHelico (Tuile tuileDepart, Tuile tuileArrivee, ArrayList<Aventurier> joueurs) {
        for (int i = 0; i<joueurs.size ();i++){
        joueurs.get(i).setPosition(tuileArrivee);
        tuileDepart.enleverAventurier(joueurs.get(i));
        //Mettre à jour IHM
         }
    }

    private ArrayList<Tuile> getTuilesDispoSacDeSable() {
        ArrayList<Tuile> casesDispo = new ArrayList<>();
        for (int i = 0; i<grille.getGrille().size();i++){
            if (grille.getGrille().get(i).getEtatCourant() == Utils.EtatTuile.INONDEE){
                casesDispo.add(grille.getGrille().get(i));
            }
        }
        return casesDispo;
    }

    private void useSacDeSable(Tuile tuile) {
        tuile.setEtatCourant(Utils.EtatTuile.ASSECHEE);
    }

}
