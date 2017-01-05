package model.cases;

import java.util.Collection;
import model.ObjetIdentifie;
import model.aventuriers.Aventurier;
import util.Utils.EtatTuile;

/**
 *
 * @author IUT2-Dept Info
 */
public class Tuile extends ObjetIdentifie {
    
    EtatTuile etatCourant;
    Collection<Aventurier> aventuriers;
    
}
