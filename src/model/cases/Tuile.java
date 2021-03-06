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
    private ArrayList<Aventurier> aventuriersDessus;
    private String cheminImage;
    private String cheminImageInonde;

    public Tuile(String nomTuile, String cheminImage, String cheminImageInonde) {
        this.nomTuile = nomTuile;
        this.cheminImage = cheminImage;
        this.cheminImageInonde = cheminImageInonde;
        this.etatCourant = EtatTuile.ASSECHEE;
        aventuriersDessus = new ArrayList<>();
        this.tresor = null;
        System.out.println(this.getId() + " - " + this.getNomTuile() + " - " + this.etatCourant + " - " + this.cheminImage + " - " + this.cheminImageInonde);
    }
    
    public Tuile(String nomTuile, String cheminImage, String cheminImageInonde, Utils.Tresor tresor) {
        this.nomTuile = nomTuile;
        this.cheminImage = cheminImage;
        this.cheminImageInonde = cheminImageInonde;
        this.etatCourant = EtatTuile.ASSECHEE;
        this.tresor = tresor;
        System.out.println(this.getId() + " - " + this.getNomTuile() + " - " + this.tresor + " - " + this.etatCourant + " - " + this.cheminImage + " - " + this.cheminImageInonde);
    }

    
    
    

    public EtatTuile getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(EtatTuile etatCourant) {
        this.etatCourant = etatCourant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utils.Tresor getTresor() {
        return tresor;
    }

    public void setTresor(Utils.Tresor tresor) {
        this.tresor = tresor;
    }

    public String getNomTuile() {
        return nomTuile;
    }

    public void setNomTuile(String nomTuile) {
        this.nomTuile = nomTuile;
    }

    public ArrayList<Aventurier> getAventuriersDessus() {
        return aventuriersDessus;
    }

    public void setAventuriersDessus(ArrayList<Aventurier> aventuriersDessus) {
        this.aventuriersDessus = aventuriersDessus;
    }
        
    public void ajouterAventurier(Aventurier a) {
        aventuriersDessus.add(a);
    }
    
    public void enleverAventurier(Aventurier a) {
        aventuriersDessus.remove(a);
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public String getCheminImageInonde() {
        return cheminImageInonde;
    }

    public void setCheminImageInonde(String cheminImageInonde) {
        this.cheminImageInonde = cheminImageInonde;
    }
    
    
    
    
}
