package tests;

import jeu.entites.Bouclier;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBouclier {


    @Test
    public void test01_bouclier_diminuerResistance_OK(){
        Bouclier b = new Bouclier(5);
        b.diminuerResistance(3);
        assertEquals("Le bouclier  doit avoir 2 de resistance",2,b.getResistance());
    }

    @Test
    public void test02_bouclier_diminuerResistance_Casse(){
        Bouclier b = new Bouclier(2);
        b.diminuerResistance(3);
        assertTrue("Le bouclier doit etre casse",b.etreCasserBouclier());
    }

}
