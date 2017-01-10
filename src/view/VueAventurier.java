package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.aventuriers.Aventurier;
import model.cartes.CarteTirage;
import util.Utils;
 
public class VueAventurier extends Observable {
    
    
    private final JFrame window;

    private Aventurier a;
    
    private JPanel mainPanel;
    private JPanel panelCentre;
    private JPanel panelDroite;
    
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
    private ImageIcon helico;
    private ImageIcon sable;
    
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
        
        helico = new ImageIcon(util.Parameters.TRESORS+"helicoptere.png");
        btnHelico = new JButton(helico);
        btnJump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Utils.Commandes.JOUER_HELICO);
                clearChanged();
            }
        });
        
        sable = new ImageIcon(util.Parameters.TRESORS+"sable.png");
        btnSacDeSable = new JButton(sable);
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

        actualiserCartes();

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
        panelCentre.removeAll();
        for(CarteTirage c : a.getCartesEnMain()) {
            ImageIcon imgCarte = new ImageIcon(this.a.getCartesEnMain().get(0).getCheminImage());
            imgCarte.setImage(imgCarte.getImage().getScaledInstance(150, 150, 110)); //Crée une instance 100x100 de l'image
            JLabel labelCarte = new JLabel(imgCarte);
            labelCarte.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            panelCentre.add(labelCarte);
        }
    }
    
    
    public void show() {
        this.window.setVisible(true);
    }
    
    public void hide() {
        this.window.setVisible(false);
    }
}