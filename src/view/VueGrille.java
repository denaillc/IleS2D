package view;

import java.util.ArrayList;
import javax.swing.JPanel;
import model.cases.Grille;
import model.cases.Tuile;
 
public class VueGrille extends JPanel {
    
    ArrayList<VueTuile> vuesTuiles = new ArrayList<>();

    public VueGrille(Grille g) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                Tuile t = g.getTuiles()[i][j];
                if (t != null) {
                    VueTuile v = new VueTuile(t);
                    this.vuesTuiles.add(v);
                    System.out.println("tuile ajoutée - #" + v.getT().getId());
                } else {
                    VueTuile v = new VueTuile();
                    this.vuesTuiles.add(v);
                    System.out.println("tuile ajoutée - type null");
                }
                
            }
        }
        
        System.out.println("******************CONSTRUCTION GRILLE 100%******************");
    }

    public ArrayList<VueTuile> getVuesTuiles() {
        return vuesTuiles;
    }

    public void setVuesTuiles(ArrayList<VueTuile> vuesTuiles) {
        this.vuesTuiles = vuesTuiles;
    }
    
    
    
}