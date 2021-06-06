package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.entites.Joueur;
import jeu.utils.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Chemin
 *
 * @author AGJMX
 */
public class TestChemin {

    /**
     * Labyrinthe
     */
    private Labyrinthe l;

    /**
     * Joueur
     */
    private Joueur j;

    /**
     * Methode d'initialisation du contenu
     */
    @Before
    public void init() {
        String lab =
                "xoooooooooooooo" +
                        "xxoxxxooxxxeoxx" +
                        "oxxxoxooxooxoxo" +
                        "oooooxoxxoxxoxo" +
                        "oxxoxxoxxoxooxx" +
                        "oxooxooxoxxooox" +
                        "oxoxxooxoxoooox" +
                        "oxxxoxoxoxxxxox" +
                        "oooxoxxxxoooxxx" +
                        "xxoxxoooxoooooo" +
                        "oxooxoxxxxxxxox" +
                        "oxxoxxxoooooxox" +
                        "ooxooooxxxxxxox" +
                        "ooxooxxxooxooox" +
                        "ooxxxxooooxxxex";
        this.l = new Labyrinthe(lab);
        this.j = l.getJoueur();
        //On force un retour a la pos d'origine
        j.setPosition(l.getEntree());
    }

    /**
     * Methode testDeplacement01
     * Resultat OK
     */
    @Test
    public void test01_chemin_seDeplacer_OK() {
        //On recupere la pos du joueur
        Case actuel = j.getCase();
        //On tente de deplacer le joueur vers le sud
        boolean b = j.seDeplacer(Direction.SOUTH);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertTrue("deplacement devrait avoir eu lieu", b);
        assertEquals("Position x devrait etre egale a x", actuel.y, destination.y);
        assertEquals("Position y devrait etre egale a y+1", actuel.x + 1, destination.x);
    }

    /**
     * Methode testDeplacement02
     * Double deplacement, resultat ok
     */
    @Test
    public void test02_chemin_seDeplacer_doubleOK() {
        //On recupere la pos du joueur
        Case actuel = j.getCase();
        //On tente de deplacer le joueur deux fois vers le sud
        boolean b1 = j.seDeplacer(Direction.SOUTH);
        boolean b2 = j.seDeplacer(Direction.SOUTH);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertTrue("deplacement1 devrait avoir eu lieu", b1);
        assertTrue("deplacement2 devrait avoir eu lieu", b2);
        assertEquals("Position x devrait etre egale a x", actuel.y, destination.y);
        assertEquals("Position y devrait etre egale a y+2", actuel.x + 2, destination.x);
    }

}
