package model.cartes;


import java.util.ArrayList;
import model.aventuriers.Aventurier;
import model.cartes.CarteTirage;
import model.cases.Tuile;

public class CarteHelicoptere extends CarteTirage {

    public CarteHelicoptere() {
        super("Hélicoptère", util.Parameters.IMAGES + "Helicoptere.png");
    }
    
    
    public void jouer(ArrayList<Aventurier> a, Tuile t) {
        Tuile depart = a.get(0).getPosition();
        for (Aventurier aventurier : a) {
            depart.enleverAventurier(aventurier);
            aventurier.setPosition(t);
            t.ajouterAventurier(aventurier);
        }
    }
    
}