package model.cartes;

import model.ObjetIdentifie;
import model.cases.Tuile;

public class CarteInondation extends ObjetIdentifie {

private String nomCarte;
private String cheminImage;

    public CarteInondation(String nomCarte, String cheminImage) {
        super();
        this.nomCarte = nomCarte;
        this.cheminImage = cheminImage;
        
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }


   

    
    
    
    
    
    
    
}