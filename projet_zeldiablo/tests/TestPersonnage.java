package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Porte;
import jeu.entites.Joueur;
import jeu.entites.Personnage;
import jeu.utils.Direction;
import org.junit.*;

import static org.junit.Assert.*;

public class TestPersonnage {
    
    /**
     * Labyrinthe
     */
    private Labyrinthe l;

    /**
     * Joueur
     */
    private Joueur j;

    /**
     * HP du Joueur
     */
    private int pdv;

    /**
     * Case porte
     */
    private Porte porte;

    /**
     * Degats du Joueur
     */
    private int d;

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
     * Methode testPersonnage01
     * Test diminuerVie
     */
    @Test
    public void test01_Joueur_diminuerVie_OK() {
        Joueur j1 = new Joueur(l,porte,10,2);
        Joueur j2 = new Joueur(l,porte,10,2);
        j1.attaquer(j2);
        assertEquals("Le Joueur doit prendre des dégats",8,j1.getPv());
    }

    /**
     * Methode testPersonnage02
     * Test augmenterVie
     */
    @Test
    public void test02_Joueur_augmenterVie_OK() {
        Joueur p1 = new Joueur(l,porte,10,2);
        Joueur p2 = new Joueur(l,porte,10,2);
        p1.setPv(12);
        assertEquals("Le Joueur doit avoir une augmentation de vie",12,p1.getPv());
    }
}
