package model.cartes;

import java.util.ArrayList;
import model.ObjetIdentifie;

public abstract class CarteTirage extends ObjetIdentifie {
    
    
   private final String nomCarte ;
   
//    private ArrayList<CarteTirage> tasDeCarte ;

    public CarteTirage(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCarte() {
        return nomCarte;
    }
    
    
        
}