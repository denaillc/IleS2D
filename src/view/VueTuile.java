package view;
 
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.cases.Tuile;

public class VueTuile extends JPanel {
    
    Tuile t;
    JLabel labelNormal;
    JLabel labelInonde;

    public VueTuile(Tuile t) {
        this.t = t;
        labelNormal = new JLabel(new ImageIcon(t.getCheminImageInonde()));
        labelInonde = new JLabel(new ImageIcon(t.getCheminImage()));
        this.afficherNormal();
    }

    private void afficherNormal() {
        this.removeAll();
        this.add(labelNormal);
    }
    
    private void afficherInonde() {
        this.removeAll();
        this.add(labelInonde);
    }
    
    
    
}