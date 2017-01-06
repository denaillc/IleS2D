package model.cartes;


import model.cartes.CarteTirage;
import model.cases.Tuile;
import util.Utils;

public class CarteSacsDeSable extends CarteTirage {
    
    
    public void jouer(Tuile t) {
        t.setEtatCourant(Utils.EtatTuile.ASSECHEE);
    }
   
}