package tests;

import jeu.*;
import jeu.cases.*;
import jeu.entites.*;
import jeu.utils.*;
import org.junit.*;

import java.io.IOException;

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
    public void init() throws IOException {
        this.l = new Labyrinthe(false);
        this.j = new Joueur(l, l.getEntree());
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
        assertEquals("Position x devrait etre egale a x", actuel.x, destination.x);
        assertEquals("Position y devrait etre egale a y+1", actuel.y + 1, destination.y);
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
        assertEquals("Position x devrait etre egale a x", actuel.x, destination.x);
        assertEquals("Position y devrait etre egale a y+2", actuel.y + 2, destination.y);
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
        boolean b = j.seDeplacer(Direction.NORTH);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertFalse("deplacement ne devrait pas avoir eu lieu", b);
        assertEquals("Position x devrait etre egale a x", actuel.x, destination.x);
        assertEquals("Position y devrait etre egale a y", actuel.y, destination.y);
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
        assertEquals("Position x devrait etre egale a x", actuel.x, destination.x);
        assertEquals("Position y devrait etre egale a y+1", actuel.y + 1, destination.y);
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
        boolean b1 = j.seDeplacer(Direction.NORTH);
        boolean b2 = j.seDeplacer(Direction.WEST);
        //On recupere sa nouvelle position
        Case destination = j.getCase();
        //Asserts
        assertFalse("deplacement 1 ne devrait pas avoir eu lieu", b1);
        assertFalse("deplacement 2 ne devrait pas avoir eu lieu", b2);
        assertEquals("Position x devrait etre egale a x", actuel.x, destination.x);
        assertEquals("Position y devrait etre egale a y", actuel.y, destination.y);
    }

    /**
     * Methode de test 06
     * On test le fait que le joueur puisse bien attaquer autour de lui
     * @throws IOException
     */
    @Test
    public void test06_joueur_attaquerAutour_OK() throws IOException {
        Case casejoueur = l.getEntree();
        Case casemonstre1 = l.getCase(casejoueur.x,casejoueur.y+1);
        Case casemonstre2 = l.getCase(casejoueur.x,casejoueur.y+2);
        Fantome f = new Fantome(l,casemonstre1);
        Troll t = new Troll(l,casemonstre2);
        l.getlMonstre().add(f);
        l.getlMonstre().add(t);
        j.attaquerAutour();
        j.attaquerAutour();
        j.attaquerAutour();
        j.attaquerAutour();
        j.attaquerAutour();
        assertTrue("Le fantome devrait etre mort",f.etreMort());
        assertFalse("Le troll devrait etre vivant",t.etreMort());

    }

    /**
     * Methode de test 07
     * On test le fait que le joueur ne puisse pas se trouver sur la meme case qu'un monstre
     * @throws IOException
     */
    @Test
    public void test07_joueur_collisionJoueurMonstre_OK() throws IOException {
        Case casejoueur = l.getEntree();
        Case casemonstre1 = l.getCase(casejoueur.x,casejoueur.y+1);
        Fantome f = new Fantome(l, casemonstre1);
        j.seDeplacer(Direction.WEST);
        assertEquals("Le joueur ne doit pas avoir bougé", l.getEntree(), j.getCase());
    }

    /**
     * Methode de test 08
     * On test le fait que les monstres ne puissent pas se trouver sur la meme case
     * @throws IOException
     */
    @Test
    public void test08_joueur_collisionMonstreMonstre_OK() throws IOException {
        Case casemonstre1 = l.getEntree();
        Case casemonstre2 = l.getCase(casemonstre1.x,casemonstre1.y+1);
        Troll t1 = new Troll(l, casemonstre1);
        Troll t2 = new Troll(l, casemonstre2);
        j.seDeplacer(Direction.WEST);
        assertEquals("Le troll t1 ne doit pas avoir bougé", l.getEntree(), t1.getCase());
    }

    /**
     * Methode de test 09
     * On teste le ramassage des armes par le joueur
     */
    @Test
    public void test09_joueur_ramasserArme_OK(){
        this.j.setPosition(l.getCase(11,18));
        this.j.seDeplacer(Direction.WEST);
        assertTrue("le joueur devrait avoir une arme",this.j.getArmeEnMain()!=null);
    }


    /**
     * Methode de test 09
     * On teste le ramassage des armes par le joueur
     */
    @Test
    public void test10_joueur_ramasserBouclier_OK(){
        this.j.setPosition(l.getCase(26,3));
        this.j.seDeplacer(Direction.NORTH);
        assertTrue("le joueur devrait avoir un bouclier",this.j.getBouclierEnMain()!=null);
    }


}