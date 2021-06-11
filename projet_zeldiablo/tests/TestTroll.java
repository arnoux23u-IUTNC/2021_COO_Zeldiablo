package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.entites.Troll;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour les trolls
 *
 * @author AGJMX
 */
public class TestTroll {

    /**
     * Labyrinthe
     */
    private Labyrinthe l;

    /**
     * Methode init
     */
    @Before
    public void init() throws IOException {
        this.l = new Labyrinthe(false);
    }

    /**
     * Methode testRegeneration
     * * Verifie si un troll regenere de la vie
     */
    @Test
    public void test00_troll_regeneration_OK() throws IOException {
        Case c = l.getCase(0, 0);
        Troll troll = new Troll(l, c);
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 3", 3, troll.getPv());
        troll.diminuerVie(1);
        assertEquals("Ses points devraient être à 2", 2, troll.getPv());
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 3", 3, troll.getPv());
    }

    /**
     * Methode testRegenerationAttaque
     * * Verifie si un troll ne regenere pas de la vie si il est tape
     */
    @Test
    public void test01_troll_regeneration_etantAttaque() throws IOException {
        Case c = l.getCase(0, 0);
        Troll troll = new Troll(l, c);
        troll.trollSeFaitAttaquer();
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 3", 3, troll.getPv());
    }

    /**
     * Methode testRegenerationFull
     * * Verifie si un troll ne regenere pas de la vie si il est a son maximum de pv
     */
    @Test
    public void test02_troll_regeneration_etantFull() throws IOException {
        Case c = l.getCase(0, 0);
        Troll troll = new Troll(l, c);
        assertEquals("Ses points devraient être à 3", 3, troll.getPv());
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 3", 3, troll.getPv());
    }
}
