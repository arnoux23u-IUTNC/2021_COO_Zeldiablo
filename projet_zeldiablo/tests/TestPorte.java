package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.entites.Joueur;
import jeu.utils.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Porte
 *
 * @author AGJMX
 */
public class TestPorte {

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
     * On tente de deplacer le joueur vers une porte
     */
    @Test
    public void test01_porte_seDeplacer_revenirNOK() {
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

}
