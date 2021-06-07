package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.entites.Troll;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestTroll {

    /**
     * Methode testRegeneration
     *      * Verifie si un troll regenere de la vie
     */
    @Test
    public void test00_troll_regeneration_OK(){
        Labyrinthe l = new Labyrinthe();
        Case c = l.getCase(0,0);
        Troll troll = new Troll(l,c);
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 4",4,troll.getPv());
    }

    /**
     * Methode testRegenerationAttaque
     *      * Verifie si un troll ne regenere pas de la vie si il est tape
     */
    @Test
    public void test01_troll_regeneration_etantAttaque(){
        Labyrinthe l = new Labyrinthe();
        Case c = l.getCase(0,0);
        Troll troll = new Troll(l,c);
        troll.trollSeFaitAttaquer();
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 3",3,troll.getPv());
    }
}
