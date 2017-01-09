package model.cases;

import java.util.ArrayList;
import static util.Parameters.TUILES;
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
    
        aPlacer.add(new Tuile("Héliport", TUILES+"Heliport.png", TUILES+"Heliport_Inonde.png"));
        aPlacer.add(new Tuile("La Caverne des Ombres", TUILES+"LaCaverneDesOmbres.png", TUILES+"LaCaverneDesOmbres_Inonde.png", Utils.Tresor.CRISTAL));
        aPlacer.add(new Tuile("La Forêt Pourpre", TUILES+"LaForetPourpre.png", TUILES+"LaForetPourpre_Inonde.png"));
        aPlacer.add(new Tuile("La Porte de Bronze", TUILES+"LaPorteDeBronze.png", TUILES+"LaPorteDeBronze_Inonde.png"));
        aPlacer.add(new Tuile("La Porte de Fer", TUILES+"LaPorteDeFer.png", TUILES+"aPorteDeFer_Inonde.png"));
        aPlacer.add(new Tuile("La Tour de Guet", TUILES+"LaTourDuGuet.png", TUILES+"LaTourDuGuet_Inonde.png"));
        aPlacer.add(new Tuile("Le Jardin des Murmures", TUILES+"LeJardinDesMurmures.png", TUILES+"LeJardinDesMurmures_Inonde.png", Utils.Tresor.ZEPHYR));
        aPlacer.add(new Tuile("Le Marais Brumeux", TUILES+"LeMaraisBrumeux.png", TUILES+"LeMaraisBrumeux_Inonde.png"));
        aPlacer.add(new Tuile("Le Palais des Marées", TUILES+"LePalaisDesMarees.png", TUILES+"LePalaisDesMarees_Inonde.png", Utils.Tresor.CALICE));
        aPlacer.add(new Tuile("Le Rocher Fantôme", TUILES+"LeRocherFantome.png", TUILES+"LeRocherFantome_Inonde.png"));
        aPlacer.add(new Tuile("Les Falaises de L'Oubli", TUILES+"LesFalaisesDeLOubli.png", TUILES+"LesFalaisesDeLOubli_Inonde.png"));
        aPlacer.add(new Tuile("Le Temple du Soleil", TUILES+"LeTempleDuSoleil.png", TUILES+"LeTempleDuSoleil_Inonde.png", Utils.Tresor.PIERRE));
        aPlacer.add(new Tuile("L'Observatoire", TUILES+"Observatoire.png", TUILES+"Observatoire_Inonde.png"));
        aPlacer.add(new Tuile("Le Val du Crépuscule", TUILES+"LeValDuCrepuscule.png", TUILES+"LeValDuCrepuscule_Inonde.png"));
        aPlacer.add(new Tuile("Le Temple de la Lune", TUILES+"LeTempleDeLaLune.png", TUILES+"LeTempleDeLaLune_Inonde.png", Utils.Tresor.PIERRE));
        aPlacer.add(new Tuile("Les Dunes de L'Illusion", TUILES+"LesDunesDeLIllusion.png", TUILES+"LesDunesDeLIllusion_Inonde.png"));
        aPlacer.add(new Tuile("Le Pont des Abîmes", TUILES+"LePontDesAbimes.png", TUILES+"LePontDesAbimes_Inonde.png"));
        aPlacer.add(new Tuile("Le Palais de Corail", TUILES+"LePalaisDeCorail.png", TUILES+"LePalaisDeCorail_Inonde.png", Utils.Tresor.CALICE));
        aPlacer.add(new Tuile("Le Lagon Perdu", TUILES+"LeLagonPerdu.png", TUILES+"LeLagonPerdu_Inonde.png"));
        aPlacer.add(new Tuile("Le Jardin des Hurlements", TUILES+"LeJardinDesHurlements.png", TUILES+"LeJardinDesHurlements_Inonde.png"));
        aPlacer.add(new Tuile("La Porte D'Or", TUILES+"LaPortedOr.png", TUILES+"LaPortedOr_Inonde.png"));
        aPlacer.add(new Tuile("La Porte de Cuivre", TUILES+"LaPorteDeCuivre.png", TUILES+"LaPorteDeCuivre_Inonde.png"));
        aPlacer.add(new Tuile("La Porte D'argent", TUILES+"LaPortedArgent.png", TUILES+"LaPortedArgent_Inonde.png"));
        aPlacer.add(new Tuile("La Caverne du Brasier", TUILES+"LaCaverneDuBrasier.png", TUILES+"LaCaverneDuBrasier_Inonde.png", Utils.Tresor.CRISTAL));
        
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
