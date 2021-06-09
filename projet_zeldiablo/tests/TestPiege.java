package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Piege;
import jeu.cases.Porte;
import jeu.entites.Joueur;
import jeu.entites.Personnage;
import jeu.entites.Troll;
import jeu.utils.Direction;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestPiege {
    /**
     * Labyrinthe
     */
    private Labyrinthe l;

    /**
     * Joueur
     */
    private Joueur j;

    /**
     * Case porte
     */
    private Porte porte;

    /**
     * Case piege
     */
    private Piege piege;

    /**
     * Methode pour initialiser le contenu
     */
    @Before
    public void init() throws IOException {
        this.l = new Labyrinthe(false);
        this.j = l.getJoueur();
        porte = l.getEntree();
        //On force un retour a la pos d'origine
        j.setPosition(l.getEntree());
    }

    /**
     * Methode testPiege00
     * Test la generation du piege
     */
    @Test
    public void test00_piege_piegegenere_OK() {
        assertEquals("La case 0,1 doit etre un piege ", "P", l.getCase(17, 1).getIdentifier());

    }

    /**
     * Methode testPiege01
     * Test prendDegats
     */
    @Test
    public void test01_piege_prendDegats_OK() throws IOException {
        Joueur j1 = new Joueur(l, porte);
        j.seDeplacer(Direction.SOUTH);
        j.seDeplacer(Direction.SOUTH);
        j.seDeplacer(Direction.EAST);
        j.seDeplacer(Direction.EAST);
        j.seDeplacer(Direction.EAST);
        j.seDeplacer(Direction.EAST);
        assertEquals("Le Joueur doit prendre des dégats", 19, j1.getPv());
    }

    @Test
    public void test02_piege_trollPrendDegat_OK() throws IOException {
        Troll t = new Troll(l, porte);
        t.seDeplacer(Direction.SOUTH);
        assertEquals("Le Troll ne doit pas prendre de dégats", 3, t.getPv());
    }


}
