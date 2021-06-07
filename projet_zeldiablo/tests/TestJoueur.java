package tests;

import jeu.*;
import jeu.cases.*;
import jeu.entites.*;
import jeu.utils.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Joueur
 *
 * @author AGJMX
 */
public class TestJoueur {

    /**
     * Labyrinthe
     */
    private Labyrinthe l;

    /**
     * Joueur
     */
    private Joueur j;

    /**
     * Methode pour initialiser le contenu
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
     * Test constructeur
     * Resultat OK
     */
    @Test
    public void test00_joueur_constructeur_OK(){
        assertNotNull("joueur ne devrait pas etre nul", j);
        assertNotNull("position joueur ne devrait pas etre nulle", j.getCase());
    }

    /**
     * Methode testDeplacement01
     * On deplace un joueur une fois
     * Resultat OK
     */
    @Test
    public void test01_joueur_seDeplacer_OK() {
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
     * On deplace un joueur 2 fois
     * Double deplacement, resultat ok
     */
    @Test
    public void test02_joueur_seDeplacer_doubleOK() {
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

    /**
     * Methode testDeplacement03
     * On tente de deplacer le joueur vers un mur
     * Resultat NOK
     */
    @Test
    public void test03_joueur_seDeplacer_NOK() {
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
     * Methode testDeplacement04
     * On tente de deplacer le joueur vers une porte
     * Resultat NOK
     */
    @Test
    public void test04_joueur_seDeplacer_revenirNOK() {
        //On recupere la pos du joueur
        Case actuel = j.getCase();
        //On tente de deplacer le joueur vers l'est
        j.seDeplacer(Direction.SOUTH);
        boolean b = j.seDeplacer(Direction.NORTH);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertFalse("deuxieme deplacement ne devrait pas avoir eu lieu, joueur doit etre sous la porte", b);
        assertEquals("Position x devrait etre egale a x", actuel.y, destination.y);
        assertEquals("Position y devrait etre egale a y+1", actuel.x + 1, destination.x);
    }

    /**
     * Methode testDeplacement05
     * On tente de deplacer le joueur deux fois vers un mur
     * Resultat NOK
     */
    @Test
    public void test05_joueur_seDeplacer_doubleNOK() {
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