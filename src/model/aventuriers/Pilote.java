package model.aventuriers;


import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Utils;

public class Pilote extends Aventurier {

    public Pilote(String pseudo, Utils.Pion pion, Tuile position) {
        super(pseudo, pion, position);
    }


public void bouger(Tuile t){
    if(t.getEtatCourant() != Utils.EtatTuile.COULEE){
        position.enleverAventurier(this);
        position = t ;
        t.ajouterAventurier(this);
        this.actionEffectuee();
    
    }
    
}


}