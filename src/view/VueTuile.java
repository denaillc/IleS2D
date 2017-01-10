package view;
 
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.cases.Tuile;

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