package model.aventuriers;

import model.cartes.CarteTirage;
import java.util.*;
import model.ObjetIdentifie;
import model.cases.Tuile;

public abstract class Aventurier extends ObjetIdentifie {

	Tuile position;
	ArrayList<CarteTirage> cartesEnMain;
        int ptsAction = 3;
        
        
        
        
        
//        private void piocherCarteTirage (int i) {
//            for (int j = 0; j < i; j++) {
//                
//                
//            }
//            
//            
//            
//        
//        }

    public int getPtsAction() {
        return ptsAction;
    }

    public void setPtsAction(int ptsAction) {
        this.ptsAction = ptsAction;
    }
    
    public void actionJouee() {
        this.ptsAction--;
    }
    
    public void debutTour() {
        this.ptsAction = 3;
    }
        
}