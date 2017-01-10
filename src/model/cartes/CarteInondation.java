package model.cartes;

import model.ObjetIdentifie;
import model.cases.Tuile;

public class CarteInondation extends ObjetIdentifie {

private Tuile tuileAssociee;

    public CarteInondation(Tuile t) {
        super();
        this.tuileAssociee = t;
        
    }

    public Tuile getTuileAssociee() {
        return tuileAssociee;
    }

    public void setTuileAssociee(Tuile tuileAssociee) {
        this.tuileAssociee = tuileAssociee;
    }

   

    
    
    
    
    
    
    
}