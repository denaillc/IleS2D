package model.aventuriers;


import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Utils;

public class Navigateur extends Aventurier {

    public Navigateur(String pseudo, Utils.Pion pion, Tuile position) {
        super(pseudo, pion, position);
    }

    
    @Override
    public void resetPtsAction() {
        this.ptsAction = 4;
    }
}