package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.Parameters;
import util.Utils;

public class VueInscription extends Observable {
    
    
    private final JFrame window;
    
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel panelCentre = new JPanel(new GridLayout(5,2));
    private JButton btnValider = new JButton("Valider");
    private JButton btnQuitter = new JButton("Quitter");
    private JLabel joueur1 = new JLabel("Joueur 1 :");
    private JLabel joueur2 = new JLabel("Joueur 2 :");
    private JLabel joueur3 = new JLabel("Joueur 3 :");
    private JLabel joueur4 = new JLabel("Joueur 4 :");
    private JTextField pseudo1 = new JTextField("");
    private JTextField pseudo2 = new JTextField("");
    private JTextField pseudo3 = new JTextField("");
    private JTextField pseudo4 = new JTextField("");

    public VueInscription() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(250,250);
        window.setLocation(1050,0);
        window.setTitle("Inscription");
        
        window.add(mainPanel);
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Utils.Commandes.VALIDER_JOUEURS);
                    clearChanged();
            }
        });
        
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Utils.Commandes.QUITTER);
                clearChanged();
            }
        });
        
        panelCentre.add(joueur1);
        panelCentre.add(pseudo1);
        panelCentre.add(joueur2);
        panelCentre.add(pseudo2);
        panelCentre.add(joueur3);
        panelCentre.add(pseudo3);
        panelCentre.add(joueur4);
        panelCentre.add(pseudo4);
        panelCentre.add(btnValider);
        panelCentre.add(btnQuitter);
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        
        
        pseudo1.setText("Pierre");
        pseudo2.setText("Paul");
        
        this.show();
//        Utils.poserQuestion("Slip ou caleçon ?");
        
    }
    
    
    
    public void terminerInscription() {
        window.invalidate();
        this.getMainPanel().removeAll();
        JPanel panelCentre2 = new JPanel(new GridLayout(5,2));
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(new JLabel());
        panelCentre2.add(btnValider);
        panelCentre2.add(btnQuitter);
        mainPanel.add(panelCentre2, BorderLayout.CENTER);
        window.validate();
        this.hide();
    }  
    
    
    
    
//    **********************************************
//    ************ GETTERS ET SETTERS **************
//    **********************************************
    
    
    public void show() {
        this.window.setVisible(true);
    }
    
    public void hide() {
        this.window.setVisible(false);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getPanelCentre() {
        return panelCentre;
    }

    public void setPanelCentre(JPanel panelCentre) {
        this.panelCentre = panelCentre;
    }

    public JButton getBtnValider() {
        return btnValider;
    }

    public void setBtnValider(JButton btnValider) {
        this.btnValider = btnValider;
    }

    public JButton getBtnQuitter() {
        return btnQuitter;
    }

    public void setBtnQuitter(JButton btnQuitter) {
        this.btnQuitter = btnQuitter;
    }

    public JLabel getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(JLabel joueur1) {
        this.joueur1 = joueur1;
    }

    public JLabel getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(JLabel joueur2) {
        this.joueur2 = joueur2;
    }

    public JLabel getJoueur3() {
        return joueur3;
    }

    public void setJoueur3(JLabel joueur3) {
        this.joueur3 = joueur3;
    }

    public JLabel getJoueur4() {
        return joueur4;
    }

    public void setJoueur4(JLabel joueur4) {
        this.joueur4 = joueur4;
    }

    public JTextField getPseudo1() {
        return pseudo1;
    }

    public void setPseudo1(JTextField pseudo1) {
        this.pseudo1 = pseudo1;
    }

    public JTextField getPseudo2() {
        return pseudo2;
    }

    public void setPseudo2(JTextField pseudo2) {
        this.pseudo2 = pseudo2;
    }

    public JTextField getPseudo3() {
        return pseudo3;
    }

    public void setPseudo3(JTextField pseudo3) {
        this.pseudo3 = pseudo3;
    }

    public JTextField getPseudo4() {
        return pseudo4;
    }

    public void setPseudo4(JTextField pseudo4) {
        this.pseudo4 = pseudo4;
    }

    public JFrame getWindow() {
        return window;
    }
    
    

}

