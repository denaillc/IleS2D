package model.cases;

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
    private Utils.Tresor tresor ;
    private String nomTuile ;
    private EtatTuile etatCourant;
    private Collection<Aventurier> aventuriers;

    public Tuile(String nomTuile, EtatTuile etatCourant) {
        this.tresor = tresor;
        this.nomTuile = nomTuile;
        this.etatCourant = etatCourant;
        this.aventuriers = aventuriers;
    }
    
  
    
    
    
    
    
}
