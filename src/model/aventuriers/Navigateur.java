package model.aventuriers;


import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Utils;

public class Navigateur extends Aventurier {

    public Navigateur(Utils.Pion pion, Tuile position) {
        super(pion, position);
    }

    
    @Override
    public void resetPtsAction() {
        this.ptsAction = 4;
    }
}