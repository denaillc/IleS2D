package controler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import model.aventuriers.*;
import model.cartes.*;
import util.Utils;
import view.*;

public class Controleur implements Observer {
    
    private ArrayList<Aventurier> joueurs;
    private ArrayList<CarteInondation> piocheInondation;
    private ArrayList<CarteInondation> defausseInondation;
    private ArrayList<CarteTirage> piocheTirage;
    private ArrayList<CarteTirage> defausseTirage;
    private VueInscription VueI;
    

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
            
//            System.exit(0);

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
    
    
    
    
}