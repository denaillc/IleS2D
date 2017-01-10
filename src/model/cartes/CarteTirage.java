package model.cartes;

import java.util.ArrayList;
import model.ObjetIdentifie;

public abstract class CarteTirage extends ObjetIdentifie {
    
    
   private final String nomCarte;
   private String cheminImage;
//    private ArrayList<CarteTirage> tasDeCarte ;

    public CarteTirage(String nomCarte, String cheminImage) {
        this.nomCarte = nomCarte;
        this.cheminImage = cheminImage;
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

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
    
    
        
}