package model.aventuriers;


import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Utils;

public class Messager extends Aventurier {

    public Messager(String pseudo, Utils.Pion pion, Tuile position) {
        super(pseudo, pion, position);
    }
}