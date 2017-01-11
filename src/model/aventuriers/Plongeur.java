package model.aventuriers;


import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Utils;

public class Plongeur extends Aventurier {

    public Plongeur(String pseudo, Utils.Pion pion, Tuile position) {
        super(pseudo, pion, position);
    }

//    @Override
//    public void seDeplacer(Tuile t) {
//        if(t.getEtatCourant()==t.getEtatCourant().COULEE && t.getEtatCourant()==t.getEtatCourant().INONDEE){ //si la tuile est manquante ou dans l'eau alors 
//        
//        super.seDeplacer(t); 
//        
//        
//        }
//    }


}