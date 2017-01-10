package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.aventuriers.Aventurier;
import util.Utils;
 
public class VueAventurier extends Observable {
    
    
    private final JFrame window;

    private Aventurier a;
    
    private JPanel panelCentre = new JPanel(new GridLayout(5,2));
    
    private JButton btnTerminer;
    private JButton btnDonner;
    private JButton btnDeplacer;
    private JButton btnAssecher;
    private JButton btnJump;
    
    private ImageIcon done;
    private ImageIcon give;
    private ImageIcon move;
    private ImageIcon move_disabled;
    private ImageIcon dry;
    private ImageIcon dry_disabled;
    private ImageIcon shift;
    
    public VueAventurier(Aventurier a) {
        this.a = a;
        window = new JFrame();
        
        done = new ImageIcon(util.Parameters.ICON_DONE);
        btnTerminer = new JButton(done);
        btnTerminer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Utils.Commandes.TERMINER);
                    clearChanged();
            }
        });
        
        give = new ImageIcon(util.Parameters.ICON_GIVE);
        btnDonner = new JButton(give);
        /*
        RESTE A FAIRE : 
        GIVE
        MOVE
        MOVE_DISABLED
        DRY
        DRY_DISABLED
        SHIFT
        */
        
        
        
        /*
        MAQUETTE AVENTURIER GOGO
        */
    }
            
            
}