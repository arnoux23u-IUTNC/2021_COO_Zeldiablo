package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Porte;
import jeu.entites.Joueur;
import jeu.utils.Direction;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Labyrinthe
 *
 * @author AGJMX
 */
public class TestLabyrinthe {

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
     * Methode testCreerLab01
     * Test constructeur
     */
    @Test
    public void test01_labyrinthe_constructeur_OK() {
        Case c1 = l.getCase(13, 14);
        Case c2 = l.getCase(1, 0);
        Case c3 = l.getCase(0, 0);
        Porte entree = l.getEntree();
        Porte sortie = l.getSortie();
        assertEquals("cette case est cense etre une porte", "E", c1.toString());
        assertEquals("cette case est cense etre un mur", "\u220E", c2.toString());
        assertEquals("cette case est cense etre un chemin", "X", c3.toString());
        assertEquals("Entree devrait etre en 11,1", l.getCase(11,1), entree);
        assertEquals("Sortie devrait etre en 13,14", c1, sortie);
        assertEquals("Joueur devrait etre sur entree", entree, j.getCase());
    }

}
