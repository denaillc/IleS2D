package model.cartes;

import java.util.ArrayList;
import model.ObjetIdentifie;

public abstract class CarteTirage extends ObjetIdentifie {
    
    
   private final String nomCarte ;
   
//    private ArrayList<CarteTirage> tasDeCarte ;

    public CarteTirage(String nomCarte) {
        this.nomCarte = nomCarte;
    }
    
    
    
    
}