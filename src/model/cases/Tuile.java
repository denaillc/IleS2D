package model.cases;

import java.util.ArrayList;
import java.util.Collection;
import model.ObjetIdentifie;
import model.aventuriers.Aventurier;
import util.Utils;
import util.Utils.EtatTuile;

/**
 *
 * @author IUT2-Dept Info
 */
public class Tuile extends ObjetIdentifie {
    private Utils.Tresor tresor;
    private String nomTuile ;
    private EtatTuile etatCourant;
    private ArrayList<Aventurier> aventuriers;

    public Tuile(String nomTuile) {
        this.nomTuile = nomTuile;
        this.etatCourant = EtatTuile.ASSECHEE;
        aventuriers = new ArrayList<>();
        this.tresor = null;
    }
    
    public Tuile(String nomTuile, Utils.Tresor tresor) {
        this.nomTuile = nomTuile;
        this.tresor = tresor;
    }
    
    
    

    public EtatTuile getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(EtatTuile etatCourant) {
        this.etatCourant = etatCourant;
    }

    public Collection<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }
    
    public void ajouterAventurier(Aventurier a) {
        aventuriers.add(a);
    }
    
    public void enleverAventurier(Aventurier a) {
        aventuriers.remove(a);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
}
