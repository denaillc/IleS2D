package controler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import model.ObjetIdentifie;
import model.aventuriers.*;
import model.cartes.*;
import model.cases.*;
import model.cases.Grille ;
import util.Utils;
import view.*;

public class Controleur implements Observer {

    // ON PASSE A 9H ET DEMI
    private ArrayList<Aventurier> joueurs;
    private ArrayList<CarteInondation> piocheInondation;
    private ArrayList<CarteInondation> defausseInondation;
    private ArrayList<CarteTirage> piocheTirage;
    private ArrayList<CarteTirage> defausseTirage;
    private Grille grille;
    private Aventurier jCourant;
    
    private VueInscription VueI;
    private VuePlateau VueP;

    public Controleur() {
        VueI = new VueInscription();
        VueI.addObserver(this);
        
        grille = new Grille();
        
        VueP = new VuePlateau(grille);
        VueP.addObserver(this);
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
            }
            else {
                jCourant = this.joueurs.get(num++);                                           // Sinon on passe au joueur suivant
            }

        } else if (arg == Utils.Commandes.RECEVOIR) {

        } else if (arg == Utils.Commandes.CHOISIR_CARTE) {

        } else if (arg == Utils.Commandes.CHOISIR_TUILE) {

        } else if (arg == Utils.Commandes.DEPLACER) {

        } else if (arg == Utils.Commandes.VOIR_DEFAUSSE) {

        } else if (arg == Utils.Commandes.QUITTER) {
            System.exit(0);

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
    public void seDefausser(CarteTirage carte) {
        jCourant.getCartesEnMain().remove(carte);
        defausseTirage.add(carte);
    }
    /**
     * La méthode choisirCarte permet de retourner la carte que choisit le joueur en fonction des cartes qu'il possède dans sa main.
     * @return 
     */
    public CarteTirage choisirCarte(){
        CarteTirage c = null;
        for (int i = 0; i <= jCourant.getCartesEnMain().size(); i++) {

                if (jCourant.getCartesEnMain().get(i).getId() == getCarteChoisie(jCourant).getId()) { 
                //getCarteChoisit = > méthode IHM qui demande au joueur quel carte il choisit à Défausser/Echanger
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
            
            seDefausser(choisirCarte());
            

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
                }
                else {
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
                }
                
                else {
                    //Le joueur ne peut pas assécher de tuiles
                }
            }
                
                if (jCourant instanceof Ingénieur){
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
                    if (jCourant.getCartesEnMain().size() > 0){ //VERIFIER LES CARTES ACTIONS SPECIALES
                        //demander quelle joueur il veut echanger (IHM)
                        Aventurier receveur = getJoueurChoisi();//méthode IHM
                        //lui afficher les joueur et lui faire chosir un joueur (IHM)
                        for (int i = 0; i < joueursDispo.size(); i++) {
                            //on parcourt la liste des joueurs dispo pour comparer avec celle que le joueur a choisit
                            if (joueursDispo.get(i).getId() == getJoueurChoisi().getId()) {
                                jCourant.donnerCarte(joueursDispo.get(i),choisirCarte());
                                jCourant.actionEffectuee();
                            }
                        }
                    }
                    else {
                        //Le joueur n'a pas de carte à donner
                    }
                }
                else {
                    //Le joueur ne peut donner de cartes à aucun joueur
                }
            }
            
//RECUPERER TRESOR
            if (action == Utils.Commandes.RECUPERER_TRESOR) {
                boolean tresorRecup = false;
               // if(jCourant.getPosition().getTresor()!= null){    // Si la tuile sur laquelle le joueur est possède un trésor            
                //    for (int i = 0; i < joueurs.size(); i++) { 
                 //       if (joueurs.get(i).getTresorsPossedes().contains(jCourant.getPosition().getTresor()) ){
                 //           tresorRecup = true;
                 //       }
                        
                       
                //    }
                  if (tresorRecup){
                        //Demander si le joueur veut récupérer le trésor
                                //SI OUI
                                 jCourant.gagnerTresor();
                                 jCourant.actionEffectuee();
                        }
                        else {
                            //Le trésor a déjà été récupéré
                        }   
                //}                                               
            }
    }

    private CarteTirage getCarteChoisie(Aventurier jCourant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Tuile getTuileChoisie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * retourne les case inondée possible a assecher
 * @param jCourant
 * @return 
 */
    private ArrayList<Tuile> getTuilesDispoAssecher(Aventurier jCourant) {
    return grille.getAdjacentsAssecher(jCourant) ;
        }
/**
 * retourne les case accesible pour se deplacer
 * @param jCourant
 * @return 
 */
    private ArrayList<Tuile> getTuilesDispoBouger(Aventurier jCourant) {
    return grille.getAdjacents(jCourant) ;    }

    private Aventurier getJoueurChoisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    }
