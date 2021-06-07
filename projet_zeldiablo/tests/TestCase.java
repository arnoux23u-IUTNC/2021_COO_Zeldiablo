package tests;

import jeu.Labyrinthe;
import jeu.cases.*;
import jeu.entites.*;
import jeu.utils.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Chemin
 *
 * @author AGJMX
 */
public class TestCase {

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
     * Methode testPeutTraverser01
     * Verifie si un personnage peut traverser un chemin
     */
    @Test
    public void test00_case_peutTraverserChemin_OK() {
        Case c = new Chemin(0, 0);
        assertTrue("Joueur devrait pouvoir aller dessus", c.peutTraverser(j));
    }

    /**
     * Methode testPeutTraverser02
     * Verifie si un personnage peut traverser un mur
     */
    @Test
    public void test01_case_peutTravserserMur_OK() {
        Case c = new Mur(0, 0);
        assertFalse("Joueur ne devrait pas pouvoir aller dessus", c.peutTraverser(j));
    }

    /**
     * Methode testPeutTraverser03
     * Verifie si un personnage peut traverser une porte
     */
    @Test
    public void test02_case_peutTraverserPorte_OK() {
        Porte c = new Porte(0, 0);
        Porte c2 = new Porte(0, 0);
        c2.setFerme(true);
        assertTrue("Joueur devrait pouvoir aller dessus", c.peutTraverser(j));
        assertFalse("Joueur ne devrait pas pouvoir aller dessus", c2.peutTraverser(j));
    }
    /**
     * Methode testPeutTraverser04
     * Verifie si un fantome peut traverser un mur
     */
    @Test
    public void test03_case_mur_peutTraverserparFantome() {
        Fantome f = new Fantome(l,l.getCase(0,1));
        Mur c = new Mur(0, 0);
        assertTrue("Joueur devrait pouvoir aller dessus", c.peutTraverser(f));
    }

}
