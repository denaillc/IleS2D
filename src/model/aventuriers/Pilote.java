package model.aventuriers;


import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Utils;

public class Pilote extends Aventurier {

    public Pilote(String pseudo, Utils.Pion pion, Tuile position) {
        super(pseudo, pion, position);
    }
}