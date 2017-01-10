package model.cartes;


import model.cartes.CarteTirage;
import util.Utils;

public class CarteTresor extends CarteTirage {
    
    private String nomCarte;
    private Utils.Tresor tresor; 
//    ArrayList<CarteTirage> carteTresors ;



    
    
    public CarteTresor(Utils.Tresor t) {
        super(t.name());
        this.tresor = t;
    }

//    public CarteTresor() {
//        super(null);
//    }
    
    
    
    CarteTresor pierre1 = new CarteTresor(Utils.Tresor.PIERRE) ; 
    CarteTresor pierre2 = new CarteTresor(Utils.Tresor.PIERRE) ;
    CarteTresor pierre3 = new CarteTresor(Utils.Tresor.PIERRE) ;
    CarteTresor pierre4 = new CarteTresor(Utils.Tresor.PIERRE) ;
    CarteTresor pierre5 = new CarteTresor(Utils.Tresor.PIERRE) ;    
    
    CarteTresor cristal1 = new CarteTresor(Utils.Tresor.CRISTAL) ;
    CarteTresor cristal2 = new CarteTresor(Utils.Tresor.CRISTAL) ;
    CarteTresor cristal3 = new CarteTresor(Utils.Tresor.CRISTAL) ;
    CarteTresor cristal4 = new CarteTresor(Utils.Tresor.CRISTAL) ;
    CarteTresor cristal5 = new CarteTresor(Utils.Tresor.CRISTAL) ;

    CarteTresor zephyr1 = new CarteTresor(Utils.Tresor.ZEPHYR) ;
    CarteTresor zephyr2 = new CarteTresor(Utils.Tresor.ZEPHYR) ;
    CarteTresor zephyr3 = new CarteTresor(Utils.Tresor.ZEPHYR) ;
    CarteTresor zephyr4 = new CarteTresor(Utils.Tresor.ZEPHYR) ;
    CarteTresor zephyr5 = new CarteTresor(Utils.Tresor.ZEPHYR) ;
    
    CarteTresor calice1 = new CarteTresor(Utils.Tresor.CALICE) ;
    CarteTresor calice2 = new CarteTresor(Utils.Tresor.CALICE) ;
    CarteTresor calice3 = new CarteTresor(Utils.Tresor.CALICE) ;
    CarteTresor calice4 = new CarteTresor(Utils.Tresor.CALICE) ;
    CarteTresor calice5 = new CarteTresor(Utils.Tresor.CALICE) ;    

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }
    
    
    
}