package view;

import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.cases.Grille;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends Observable {
    
    
    private final JFrame window;
    
    private JPanel plateau;
    
    
    

    public VuePlateau() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(1000,1000);
//        window.setLocation(p);
        window.setTitle("L'île perdue");
        
        plateau = new VueGrille(Grille g);
    }
    
    
    
    
}
