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
    private ImageIcon get ;
    private ImageIcon move;
    private ImageIcon move_disabled;
    private ImageIcon dry;
    //private ImageIcon dry_disabled;
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
        btnDonner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Utils.Commandes.DONNER);
                    clearChanged();
            }
        });
        
//        get = new ImageIcon(util.Parameters.ICON_GET);
//        btn = new JButton(get);  on le fait pas car pas de bouton 
//        btn.addActionListener(new ActionListener() {
//                public void action preformed(ActionEvent e){
//                 setChanged();
//                 notifyObservers(Utils.Commandes.RECEVOIR);
//                 clearChanged();
//                }
//        });


                
        move = new ImageIcon(util.Parameters.ICON_MOVE);
        btnDeplacer = new JButton(move);
        btnDeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Utils.Commandes.DEPLACER); // ? bouger  != deplacer
                    clearChanged();
            }
        });
        
        move_disabled = new ImageIcon(util.Parameters.ICON_MOVE_DISABLED);
//        btnDeplacer = new JButton(move_disabled);
//        btnDeplacer.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    setChanged();
//                    notifyObservers(Utils.Commandes.DEPLACER);
//                    clearChanged();
//            }
//        });
        
        dry = new ImageIcon(util.Parameters.ICON_DRY);
        btnAssecher = new JButton(dry);
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Utils.Commandes.ASSECHER);
                    clearChanged();
            }
        });

        shift = new ImageIcon(util.Parameters.ICON_SHIFT);
        btnJump = new JButton(dry) ;
        btnJump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Utils.Commandes.BOUGER);
                clearChanged();
            }
        });
        
        
        
        
        /*
        RESTE A FAIRE : 
        GET 
     //   GET_DIASABLED
        GIVE
        MOVE
       // MOVE_DISABLED
        DRY
      //  DRY_DISABLED
        SHIFT
        */
        
        
        
        /*
        MAQUETTE AVENTURIER GOGO
        */
    }
            
            
}