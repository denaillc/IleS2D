package model.cartes;


import model.cartes.CarteTirage;
import util.Utils;

public class CarteTresor extends CarteTirage {
    
    private Utils.Tresor tresor; 
//    ArrayList<CarteTirage> carteTresors ;



    
    
    public CarteTresor(Utils.Tresor t) {
        super(t.toString(), t.getPathPicture());
        this.tresor = t;
    }

//    public CarteTresor() {
//        super(null);
//    }
    
    
    
}