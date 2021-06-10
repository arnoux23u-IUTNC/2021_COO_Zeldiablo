package tests;

import jeu.Labyrinthe;
import jeu.cases.*;
import jeu.entites.*;
import jeu.utils.*;
import org.junit.*;

import java.io.IOException;

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
    public void init() throws IOException {
        this.l = new Labyrinthe(false);
        this.j = l.getJoueur();
        //On force un retour a la pos d'origine
        j.setPosition(l.getEntree());
    }

    /**
     * Methode testPeutTraverser01
     * Verifie si un personnage peut traverser un chemin
     */
    @Test
    public void test01_case_peutTraverserChemin_OK() throws IOException {
        assertTrue("Joueur devrait pouvoir aller dessus", j.peutTraverserChemin());
    }

    /**
     * Methode testPeutTraverser02
     * Verifie si un personnage peut traverser un mur
     */
    @Test
    public void test02_case_peutTravserserMur_OK() throws IOException {
        assertFalse("Joueur ne devrait pas pouvoir aller dessus", j.peutTraverserMur());
    }

    /**
     * Methode testPeutTraverser03
     * Verifie si un personnage peut traverser une porte
     */
    @Test
    public void test03_case_peutTraverserPorte_OK() throws IOException {
        assertTrue("Joueur devrait pouvoir aller dessus", j.peutTraverserPorte());
        assertFalse("Joueur ne devrait pas pouvoir aller dessus", j.peutTraverserPorte());
    }

    /**
     * Methode testPeutTraverser04
     * Verifie si un fantome peut traverser un mur
     */
    @Test
    public void test04_case_mur_peutTraverserparFantome() throws IOException {
        Fantome f = new Fantome(l, l.getCase(3, 0));
        Mur c = new Mur(0, 0);
        assertTrue("Fantome devrait pouvoir aller dessus", f.peutTraverserMur());
        assertTrue("Fantome devrait etre dans le mur", f.seDeplacer(Direction.SOUTH));
    }

    /**
     * Methode testPeutTraverser05
     * Verifie si un troll ne peut pas traverser un mur
     */
    @Test
    public void test05_case_mur_nepeutpasTraverserparTroll() throws IOException {
        Troll f = new Troll(l, l.getCase(3, 0));
        Mur c = (Mur) l.getCase(4, 0);
        assertFalse("Troll ne devrait pas pouvoir aller dessus", f.peutTraverserMur());
        assertFalse("Troll ne devrait pas etre dans le mur", f.seDeplacer(Direction.SOUTH));
    }

}