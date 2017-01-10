package model.aventuriers;

import model.cartes.CarteTirage;
import java.util.*;
import model.ObjetIdentifie;
import model.cartes.CarteHelicoptere;
import model.cartes.CarteSacsDeSable;
import model.cases.Tuile;
import util.Utils;

public abstract class Aventurier extends ObjetIdentifie {
        
        String pseudo;
        Utils.Pion pion;
	Tuile position;
	ArrayList<CarteTirage> cartesEnMain;
        ArrayList<Utils.Tresor> tresorsPossedes;
        int ptsAction;

    public Aventurier(String pseudo, Utils.Pion pion, Tuile position) {
        super();
        this.pseudo = pseudo;
        this.pion = pion;
        this.position = position;
        cartesEnMain = new ArrayList<>();
        tresorsPossedes = new ArrayList<>();
        ptsAction = 3;
        
    }
    

    
    public void seDeplacer(Tuile t) {
        position.enleverAventurier(this);
        position = t;
        t.ajouterAventurier(this);
        this.actionEffectuee();
    }
    
    public void donnerCarte(Aventurier a, CarteTirage c) {
        a.cartesEnMain.add(c);
        this.cartesEnMain.remove(c);
        this.actionEffectuee();
    }
    
    public void defausser(CarteTirage c) {
        this.cartesEnMain.remove(c);
    }
    
    public void assecherTuile(Tuile t) {
        t.setEtatCourant(Utils.EtatTuile.ASSECHEE);
        this.actionEffectuee();
    }
    
    public void gagnerTresor() {
        this.tresorsPossedes.add(this.getPosition().getTresor());
        this.actionEffectuee();
    }
    
    public void actionSpeciale(CarteHelicoptere c, ArrayList<Aventurier> a, Tuile t) {
        c.jouer(a, t);
        this.cartesEnMain.remove(c);
    }
    
    public void actionSpeciale(CarteSacsDeSable c, Tuile t) {
        c.jouer(t);
        this.cartesEnMain.remove(c);
    }
    
    
    /**
     * retire un point d'action
     */
    public void actionEffectuee() {
        this.ptsAction--;
    }

    
    
    
    
    
//    **********************************************
//    ************ GETTERS ET SETTERS **************
//    **********************************************
    
    
    
    
    
    
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Utils.Pion getPion() {
        return pion;
    }

    public void setPion(Utils.Pion pion) {
        this.pion = pion;
    }

    public Tuile getPosition() {
        return position;
    }

    public void setPosition(Tuile position) {
        this.position = position;
    }

    public ArrayList<CarteTirage> getCartesEnMain() {
        return cartesEnMain;
    }

    public void setCartesEnMain(ArrayList<CarteTirage> cartesEnMain) {
        this.cartesEnMain = cartesEnMain;
    }

    public ArrayList<Utils.Tresor> getTresorsPossedes() {
        return tresorsPossedes;
    }

    public void setTresorsPossedes(ArrayList<Utils.Tresor> tresorsPossedes) {
        this.tresorsPossedes = tresorsPossedes;
    }

    public int getPtsAction() {
        return ptsAction;
    }


    public void setPtsAction(int ptsAction) {
        this.ptsAction = ptsAction;
    }
    
    public void resetPtsAction() {
        this.ptsAction = 3;
    }

   
    
    
 

}