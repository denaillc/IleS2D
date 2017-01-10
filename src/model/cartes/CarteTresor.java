package model.cartes;


import model.cartes.CarteTirage;
import util.Utils;

public class CarteTresor extends CarteTirage {
    
    private String nomCarte;
    private Utils.Tresor tresor; 
//    ArrayList<CarteTirage> carteTresors ;



    
    
    public CarteTresor(Utils.Tresor t) {
        super(t.name(), t.getPathPicture());
        this.tresor = t;
    }

//    public CarteTresor() {
//        super(null);
//    }
    
    
    


    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }
    
    
    
}