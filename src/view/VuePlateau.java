package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.cases.Grille;
import util.Parameters;

/**
 *
 * @author IUT2-Dept Info
 */
public class VuePlateau extends Observable {
    
    
    private final JFrame window;
    
    private VueGrille plateau;
    private JLabel imageFond;
    private JPanel mainPanel;
    

    public VuePlateau(Grille g) {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(1000,1000);
//        window.setLocation(p);
        window.setTitle("L'île perdue");
//        imageFond = new JLabel(new ImageIcon(Parameters.IMAGES + "ocean.jpeg"));
//        window.add(imageFond);
        plateau = new VueGrille(g);
        
        
        
        this.mainPanel = new JPanel(new GridLayout(6,6));
        for (VueTuile tuile : plateau.getVuesTuiles()) {
            mainPanel.add(tuile);
            if (tuile.getT() != null) {
            tuile.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setChanged();
                    notifyObservers(tuile);
                    clearChanged();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
                
                
            });
        }
        }
        window.add(mainPanel);
        
        
        this.show();
    }
    
    
    
    
    
    public void show() {
        this.window.setVisible(true);
    }
    
    public void hide() {
        this.window.setVisible(false);
    }
}
