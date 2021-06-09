package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Porte;
import jeu.entites.Joueur;
import jeu.utils.Direction;
import org.junit.*;

import java.io.IOException;

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
    public void init() throws IOException {
        this.l = new Labyrinthe(false);
        this.j = l.getJoueur();
        //On force un retour a la pos d'origine
        j.setPosition(l.getEntree());
    }

    /**
     * Methode testCreerLab01
     * Test constructeur
     */
    @Test
    public void test00_labyrinthe_constructeur_OK() {
        Case c1 = l.getCase(0, 0);
        Case c2 = l.getCase(0, 1);
        Case c3 = l.getCase(0, 3);
        Case c4 = l.getCase(29, 29);
        Porte entree = l.getEntree();
        Porte sortie = l.getSortie();
        assertEquals("cette case est cense etre une porte", "E", c1.toString());
        assertEquals("cette case est cense etre un mur", "O", c3.toString());
        assertEquals("cette case est cense etre un chemin", "X", c2.toString());
        assertEquals("cette case est cense etre une porte", "E", c4.toString());
        assertEquals("Entree devrait etre en 0,0", c1, entree);
        assertEquals("Sortie devrait etre en 13,14", c4, sortie);
        assertEquals("Joueur devrait etre sur entree", entree, j.getCase());
    }

}
