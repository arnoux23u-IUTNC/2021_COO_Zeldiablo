package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.entites.Joueur;
import jeu.utils.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Mur
 *
 * @author AGJMX
 */
public class TestMur {

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
     * Methode de test deplacement unique
     * On tente de deplacer le joueur vers un mur
     */
    @Test
    public void test01_Mur_seDeplacer_NOK() {
        //On recupere la pos du joueur
        Case actuel = j.getCase();
        //On tente de deplacer le joueur vers l'est
        boolean b = j.seDeplacer(Direction.EAST);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertFalse("deplacement ne devrait pas avoir eu lieu", b);
        assertEquals("Position x devrait etre egale a x", actuel.y, destination.y);
        assertEquals("Position y devrait etre egale a y", actuel.x, destination.x);
    }

    /**
     * Methode de test deplacement double
     * On tente de deplacer le joueur deux fois vers un mur
     */
    @Test
    public void test02_Mur_seDeplacer_doubleNOK() {
        //On recupere la pos du joueur
        Case actuel = j.getCase();
        //On tente de deplacer le joueur deux fois vers l'est
        boolean b1 = j.seDeplacer(Direction.EAST);
        boolean b2 = j.seDeplacer(Direction.EAST);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertFalse("deplacement 1 ne devrait pas avoir eu lieu", b1);
        assertFalse("deplacement 2 ne devrait pas avoir eu lieu", b2);
        assertEquals("Position x devrait etre egale a x", actuel.y, destination.y);
        assertEquals("Position y devrait etre egale a y", actuel.x, destination.x);
    }

}
