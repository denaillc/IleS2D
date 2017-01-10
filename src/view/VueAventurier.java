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
    
    private JLabel carte1;
    private JLabel carte2;
    private JLabel carte3;
    private JLabel carte4;
    private JLabel carte5;
    private JLabel carte6;
    private JLabel carte7;
    private JLabel carte8;
    private JLabel carte9;
    
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
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(500,400);
        window.setLocation(1000,500);
        window.setTitle("Au tour de " + a.getPseudo());
        
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
        btnJump = new JButton(shift) ;
        btnJump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Utils.Commandes.BOUGER);
                clearChanged();
            }
        });
        
        btnHelico = new JButton("Hélicoptère");
        btnJump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Utils.Commandes.JOUER_HELICO);
                clearChanged();
            }
        });
        
        btnSacDeSable = new JButton("Sac de Sable");
        btnSacDeSable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Utils.Commandes.JOUER_SDS);
                clearChanged();
            }
        });
        
        
        
        panelCentre = new JPanel(new GridLayout(3,3));
        panelDroite = new JPanel(new GridLayout(4,2));
        mainPanel = new JPanel(new BorderLayout());

        panelCentre.add(carte1 = new JLabel("carte n°1"));
        panelCentre.add(carte2 = new JLabel("carte n°2"));
        panelCentre.add(carte3 = new JLabel("carte n°3"));
        panelCentre.add(carte4 = new JLabel("carte n°4"));
        panelCentre.add(carte5 = new JLabel("carte n°5"));
        panelCentre.add(carte6 = new JLabel("carte n°6"));
        panelCentre.add(carte7 = new JLabel("carte n°7"));
        panelCentre.add(carte8 = new JLabel("carte n°8"));
        panelCentre.add(carte9 = new JLabel("carte n°9"));

        panelDroite.add(btnDeplacer);
        panelDroite.add(btnDonner);
        panelDroite.add(btnAssecher);
        panelDroite.add(btnRecupTresor);
        panelDroite.add(btnHelico);
        panelDroite.add(btnSacDeSable);
        panelDroite.add(btnJump);
        panelDroite.add(btnTerminer);
        
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        mainPanel.add(panelDroite, BorderLayout.EAST);
        
        window.add(mainPanel);
        this.show();
    }
            
    
    private void actualiserCartes() {
        
    }
    
    
    public void show() {
        this.window.setVisible(true);
    }
    
    public void hide() {
        this.window.setVisible(false);
    }
}