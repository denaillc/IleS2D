package model.cases;

import java.util.ArrayList;
import util.Utils;

/**
 * Classe permettant de gérer la grille des tuiles du jeu
 Elle gère un unique attribut : un tableau de 6 x 6 tuiles
 Il y a 12 tuiles null et 24 tuiles réelles.
 * Les tuiles sont donc (ligne, colonne)
  null    null    (0,2)   (0,3)   null    null
  null    (1,1)   (1,2)   (1,3)   (1,4)   null
  (2,0)   (2,1)   (2,2)   (2,3)   (2,4)   (2,5)
  (3,0)   (3,1)   (3,2)   (3,3)   (3,4)   (3,5)
  null    (4,1)   (4,2)   (4,3)   (4,4)   null
  null    null    (5,2)   (5,3)   null    null
 * @author IUT2-Dept Info03
 */
public class Grille {

    ArrayList<Tuile> aPlacer;
    Tuile[][] tuiles ; // Les tuiles du jeu
    
   
    
    
    /** -------------------------------------------------------------------------------------------------------------
     * Constructeur
     */
    public Grille() {
    Utils.melangerTuile(aPlacer) ;
    
        aPlacer.add(new Tuile("Héliport"));
        aPlacer.add(new Tuile("La Caverne des Ombres", Utils.Tresor.CRISTAL));
        aPlacer.add(new Tuile("La Forêt Pourpre"));
        aPlacer.add(new Tuile("La Porte de Bronze"));
        aPlacer.add(new Tuile("La Porte de Fer"));
        aPlacer.add(new Tuile("La Tour de Guet"));
        aPlacer.add(new Tuile("Le Jardin des MurMures", Utils.Tresor.ZEPHYR));
        aPlacer.add(new Tuile("Le Marais Brumeux"));
        aPlacer.add(new Tuile("Le Palais des Marées", Utils.Tresor.CALICE));
        aPlacer.add(new Tuile("Le Rocher Fantôme"));
        aPlacer.add(new Tuile("Les Falaises de L'Oubli"));
        aPlacer.add(new Tuile("Le Temple du Soleil", Utils.Tresor.PIERRE));
        aPlacer.add(new Tuile("L'Observatoire"));
        aPlacer.add(new Tuile("Le Val du Crépuscule"));
        aPlacer.add(new Tuile("Le Temple de la Lune", Utils.Tresor.PIERRE));
        aPlacer.add(new Tuile("Les Dunes de L'Illusion"));
        aPlacer.add(new Tuile("Le Pont des Abîmes"));
        aPlacer.add(new Tuile("Le Palais de Corail",Utils.Tresor.CALICE));
        aPlacer.add(new Tuile("Le Lagon Perdu"));
        aPlacer.add(new Tuile("Le Jardin des Hurlements"));
        aPlacer.add(new Tuile("La Porte D'Or"));
        aPlacer.add(new Tuile("La Porte de Cuivre"));
        aPlacer.add(new Tuile("La Porte D'argent"));
        aPlacer.add(new Tuile("La Carverne du Brasier", Utils.Tresor.CRISTAL));
        
        String nomTuile = null;
        this.tuiles = new Tuile[6][6];
        //premier ligne
        tuiles[0][0] = null;
        tuiles[0][1] = null;
        tuiles[0][2] = aPlacer.get(0);
        tuiles[0][3] = aPlacer.get(1);
        tuiles[0][4] = null ;
        tuiles[0][5] = null ;
        //deuxieme ligne
        tuiles[1][0] = null ;
        tuiles[1][1] = aPlacer.get(2);
        tuiles[1][2] = aPlacer.get(3);
        tuiles[1][3] = aPlacer.get(4);
        tuiles[1][4] = aPlacer.get(5);
        tuiles[1][5] = null ;
        //troisieme ligne
        tuiles[2][0] = aPlacer.get(6);
        tuiles[2][1] = aPlacer.get(7);
        tuiles[2][2] = aPlacer.get(8);
        tuiles[2][3] = aPlacer.get(9);
        tuiles[2][4] = aPlacer.get(10);
        tuiles[2][5] = aPlacer.get(11);
        //quatrieme ligne 
        tuiles[3][0] = aPlacer.get(12);
        tuiles[3][1] = aPlacer.get(13);
        tuiles[3][2] = aPlacer.get(14);
        tuiles[3][3] = aPlacer.get(15);
        tuiles[3][4] = aPlacer.get(16);
        tuiles[3][5] = aPlacer.get(17);
        //cinquième ligne 
        tuiles[4][0] = null ;
        tuiles[4][1] = aPlacer.get(18);
        tuiles[4][2] = aPlacer.get(19);
        tuiles[4][3] = aPlacer.get(20);
        tuiles[4][4] = aPlacer.get(21);
        tuiles[4][5] = null ;
        // sixième ligne
        tuiles[5][0] = null ;
        tuiles[5][1] = null ;
        tuiles[5][2] = aPlacer.get(22);
        tuiles[5][3] = aPlacer.get(23);
        tuiles[5][4] = null;
        tuiles[5][5] = null;
    }

    
    
    
    
    
    
    
    
    
//    **********************************************
//    ************ GETTERS ET SETTERS **************
//    **********************************************
    
    public Tuile[][] getTuiles() {
        return tuiles;
    }

    public void setTuiles(Tuile[][] tuiles) {
        this.tuiles = tuiles;
    }

}
