package view;
 
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.aventuriers.Aventurier;
import model.cases.Tuile;
import util.Parameters;

public class VueTuile extends JPanel {
    
    Tuile t;
    JLabel labelNormal;
    JLabel labelInonde;

    public VueTuile(Tuile tuile) {
        this.t = tuile;
        ImageIcon imgNormal = new ImageIcon(this.getT().getCheminImage());
        imgNormal.setImage(imgNormal.getImage().getScaledInstance(150, 150, 110)); //Crée une instance 100x100 de l'image
        ImageIcon imgInonde = new ImageIcon(this.getT().getCheminImageInonde());
        imgInonde.setImage(imgInonde.getImage().getScaledInstance(150, 150, 110)); //Crée une instance 100x100 de l'image
        
        labelNormal = new JLabel(imgNormal);
        labelInonde = new JLabel(imgInonde);
        this.afficherNormal();
    }
    
    public VueTuile() {
    }

    private void afficherNormal() {
        this.removeAll();
        this.add(labelNormal);
    }
    
    private void afficherInonde() {
        this.removeAll();
        this.add(labelInonde);
    }
    
    private void actualiserAventuriers() {
        for (Aventurier a : t.getAventuriersDessus()) {
            ImageIcon imgAventurier = new ImageIcon(Parameters.PIONS+a.getPion().getPath());
            JLabel labelAventurier = new JLabel(imgAventurier);
            this.add(labelAventurier);
        }
//        ATTENTION LES PIONS VONT S'ENPILER -> LES SEPARER SUR LA CASE
    }
    
    
    
    
    
    

    public Tuile getT() {
        return t;
    }

    public void setT(Tuile t) {
        this.t = t;
    }

    public JLabel getLabelNormal() {
        return labelNormal;
    }

    public void setLabelNormal(JLabel labelNormal) {
        this.labelNormal = labelNormal;
    }

    public JLabel getLabelInonde() {
        return labelInonde;
    }

    public void setLabelInonde(JLabel labelInonde) {
        this.labelInonde = labelInonde;
    }
    
    
    
}