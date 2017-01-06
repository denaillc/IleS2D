package model.cases;

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
 * @author IUT2-Dept Info
 */
public class Grille {

    Tuile[][] tuiles ; // Les tuiles du jeu
    
    /** -------------------------------------------------------------------------------------------------------------
     * Constructeur
     */
    public Grille() {
        String nomTuile = null;
        this.tuiles = new Tuile[6][6];
        //premier ligne
        tuiles[0][0] = null;
        tuiles[0][1] = null;
        tuiles[0][2] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[0][3] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[0][4] = null ;
        tuiles[0][5] = null ;
        //deuxieme ligne
        tuiles[1][0] = null ;
        tuiles[1][1] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[1][2] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[1][3] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[1][4] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[1][5] = null ;
        //troisieme ligne
        tuiles[2][0] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[2][1] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[2][2] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[2][3] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[2][4] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[2][5] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        //quatrieme ligne 
        tuiles[3][0] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[3][1] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[3][2] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[3][3] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[3][4] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[3][5] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        //cinquième ligne 
        tuiles[4][0] = null ;
        tuiles[4][1] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[4][2] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[4][3] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[4][4] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[4][5] = null ;
        // sixième ligne
        tuiles[5][0] = null ;
        tuiles[5][1] = null ;
        tuiles[5][2] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[5][3] = new Tuile(nomTuile, Utils.EtatTuile.ASSECHEE) ;
        tuiles[5][4] = null;
        tuiles[5][5] = null;
    }
}
