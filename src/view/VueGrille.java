package view;

import java.util.ArrayList;
import javax.swing.JPanel;
import model.cases.Grille;
import model.cases.Tuile;
 
public class VueGrille extends JPanel {
    
    ArrayList<VueTuile> vuesTuiles = new ArrayList<>();

    public VueGrille(Grille g) {
        for (Tuile[] ts : g.getTuiles())
            for (Tuile t : ts) {
                VueTuile v = new VueTuile(t);
                this.vuesTuiles.add(v);
            }
    }
    
    
    
}