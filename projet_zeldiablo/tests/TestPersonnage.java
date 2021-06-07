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
     * HP du Personnage
     */
    private int pdv;

    /**
     * Case depart
     */
    private Case depart;

    /**
     * Degats du Personnage
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
     * Methode testCreerLab01
     * Test constructeur
     */
    @Test
    public void test01_personnage_diminuerVie_OK() {
        Personnage p1 = new Personnage(l,depart,10,2);
        Personnage p2 = new Personnage(l,depart,10,2);
        p1.attaquer(p2);
        assertEquals("Le personnage doit prendre des dégats",8,p1.getPv());
    }

    public void test01_personnage_augmenterVie_OK() {
        Personnage p1 = new Personnage(l,depart,10,2);
        Personnage p2 = new Personnage(l,depart,10,2);
        p1.setPv(12);
        assertEquals("Le personnage doit avoir une augmentation de vie",12,p1.getPv());
    }
}
