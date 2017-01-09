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
    private VueInscription VueI;
    private Aventurier jCourant;

    public Controleur() {
        VueI = new VueInscription();
        VueI.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg == Utils.Commandes.VALIDER_JOUEURS) {
            if (VueI.getPseudo1().getText().equals("")
                    || VueI.getPseudo2().getText().equals("")) {
                System.out.println("Pas assez de joueurs");
            } else {
                VueI.terminerInscription();
            }

            //Debut création voir TODO
        } else if (arg == Utils.Commandes.BOUGER) {

        } else if (arg == Utils.Commandes.ASSECHER) {

        } else if (arg == Utils.Commandes.DONNER) {

        } else if (arg == Utils.Commandes.RECUPERER_TRESOR) {

        } else if (arg == Utils.Commandes.TERMINER) {

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
        for (int i = 0; i <= jCourant.getCartesEnMain().size(); i++) {

                if (jCourant.getCartesEnMain().get(i).getId() == getCarteChoisie(jCourant).getId()) { 
                //getCarteChoisit = > méthode IHM qui demande au joueur quel carte il choisit à Défausser/Echanger
                   return jCourant.getCartesEnMain().get(i);
                   //possibilité de mettre un booléen pour optimiser les itérations
                }
            }
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
        
       
//BOUGER
        if (jCourant.getPtsAction() > 0) {        
        }
            if (action == Utils.Commandes.BOUGER) { //action est un message retourné par une vue 
                tuilesDispo[] = getTuilesDispoBouger(jCourant);
                if (getTuilesDispoBouger(jCourant).size() > 0) {
                    //demander quelle tuile il veut aller (IHM)
                    tuile = getTuileChoisie();
                    //lui afficher les case et lui faire chosir une case (IHM)
                    for (int i = 0; i < getTuilesDispoBouger(jCourant).size(); i++) {
                        //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                        if (getTuilesDispoBouger(jCourant).get(i).get(Id) == getTuileChoisie().getId()) {
                            jCourant.seDeplacer(getTuilesDispoBouger(jCourant)[i]);
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
                        tuilesDispo[] = getTuilesDispoAssecher(jCourant);
                if (getTuilesDispoAssecher(jCourant).size() > 0) {
                    //demander quelle tuile il veut assecher (IHM)
                    tuile = getTuileChoisie();//méthode IHM
                    //lui afficher les case et lui faire chosir une case (IHM)
                    for (int i = 0; i < getTuilesDispoAssecher(jCourant).size(); i++) {
                        //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                        if (getTuilesDispoAssecher(jCourant).get(i).get(Id) == getTuileChoisie().getId()) {
                            jCourant.assecherTuile(getTuilesDispoAssecher(jCourant)[i]);
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
                        tuilesDispo[] = getTuilesDispoAssecher(jCourant);
                        //demander quelle tuile il veut assecher (IHM)
                        tuile = getTuileChoisie();//méthode IHM
                        //lui afficher les case et lui faire chosir une case (IHM)
                        for (int i = 0; i < getTuilesDispoAssecher(jCourant).size(); i++) {
                            //on parcourt la liste des tuiles dispo pour comparer avec celle que le joueur a choisit
                            if (getTuilesDispoAssecher(jCourant).get(i).get(Id) == getTuileChoisie().getId()) {
                                jCourant.assecherTuile(getTuilesDispoAssecher(jCourant)[i]);
                            }
                        }
                    }
                }
            }
            
//DONNER            
            if (action == Utils.Commandes.DONNER) {
                joueursDispo[] = getJoueursDispo(jCourant);
                if (getJoueursDispo().size() > 0) {
                    if (jCourant.getCartesEnMain().size() > 0){ //VERIFIER LES CARTES ACTIONS SPECIALES
                        //demander quelle joueur il veut echanger (IHM)
                        joueur = getJoueurChoisit();//méthode IHM
                        //lui afficher les joueur et lui faire chosir un joueur (IHM)
                        for (int i = 0; i < getJoueursDispo(jCourant).size(); i++) {
                            //on parcourt la liste des joueurs dispo pour comparer avec celle que le joueur a choisit
                            if (getJoueursDispo(jCourant).get(i).get(Id) == getJoueurChoisit().getId()) {
                                jCourant.donnerCarte(getJoueursDispo(jCourant).get(i),choisirCarte());
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
                if(jCourant.getPosition().getTresor()!= null){    // Si la tuile sur laquelle le joueur est possède un trésor            
                    for (int i = 0; i < joueurs.size(); i++) { 
                        if (joueurs.get(i).getTresorsPossedes().contains(jCourant.getPosition().getTresor()) ){
                            tresorRecup = true;
                        }
                        
                       
                    }
                  if (tresorRecup){
                        //Demander si le joueur veut récupérer le trésor
                                //SI OUI
                                 jCourant.gagnerTresor(jCourant.getPosition().getTresor());
                                 jCourant.actionEffectuee();
                        }
                        else {
                            //Le trésor a déjà été récupéré
                        }   
                }                                               
            }

    private Object getCarteChoisie(Aventurier jCourant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getTuileChoisie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ArrayList<Tuile> getTuilesDispoAssecher(Aventurier jCourant) {
    return grille.getAdjacents(jCourant) ;
        }
    


    }
