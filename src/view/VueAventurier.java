package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.aventuriers.Aventurier;
import util.Utils;
 
public class VueAventurier extends Observable {
    
    
    private final JFrame window;

    private Aventurier a;
    
    private JPanel mainPanel;
    private JPanel panelCentre;
    private JPanel panelDroite;
    
    private JFrame carte1 = new JFrame();
    private JFrame carte2 = new JFrame();
    private JFrame carte3 = new JFrame();
    private JFrame carte4 = new JFrame();
    private JFrame carte5 = new JFrame();
    private JFrame carte6 = new JFrame();
    private JFrame carte7 = new JFrame();
    private JFrame carte8 = new JFrame();
    private JFrame carte9 = new JFrame();
    
    private JButton btnTerminer;
    private JButton btnDonner;
    private JButton btnRecupTresor;
    private JButton btnDeplacer;
    private JButton btnAssecher;
    private JButton btnJump;
    private JButton btnHelico;
    private JButton btnSacDeSable;
    
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
        
        get = new ImageIcon(util.Parameters.ICON_GET);
        btnRecupTresor = new JButton(get);
        btnRecupTresor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                    setChanged();
                    notifyObservers(Utils.Commandes.RECUPERER_TRESOR);
                    clearChanged();
            }
        });


                
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
        
//        move_disabled = new ImageIcon(util.Parameters.ICON_MOVE_DISABLED);
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
        
        
        panelCentre = new JPanel(new GridLayout(3,3));
        panelDroite = new JPanel(new GridLayout(6,1));
        mainPanel = new JPanel(new BorderLayout());

        panelCentre.add(carte1);
        panelCentre.add(carte2);
        panelCentre.add(carte3);
        panelCentre.add(carte4);
        panelCentre.add(carte5);
        panelCentre.add(carte6);
        panelCentre.add(carte7);
        panelCentre.add(carte8);
        panelCentre.add(carte9);

        panelDroite.add(btnDeplacer);
        panelDroite.add(btnAssecher);
        panelDroite.add(btnDonner);
        panelDroite.add(btnRecupTresor);
        panelDroite.add(btnHelico);
        panelDroite.add(btnSacDeSable);
        panelDroite.add(btnJump);
        panelDroite.add(btnTerminer);
        
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        mainPanel.add(panelDroite, BorderLayout.EAST);

    }
            
    
    private void actualiserCartes() {
        
    }
}