package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.entites.Troll;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestTroll {

    @Test
    public void test00_Troll_regeneration_OK(){
        Labyrinthe l = new Labyrinthe();
        Case c = l.getCase(0,0);
        Troll troll = new Troll(l,c);
        troll.seRegenerer();
        assertEquals("Ses points devraient être à 4",4,troll.getPv());
    }
}
