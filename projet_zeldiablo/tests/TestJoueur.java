package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Chemin;
import jeu.cases.Porte;
import jeu.entites.Joueur;
import jeu.entites.Personnage;
import jeu.utils.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Classe pour les tests de Joueur
 *
 * @author AGJMX
 */
public class TestJoueur {

    @Test
    public void test01_Joueur_ConstructeurPoisition_OK(){
        Labyrinthe l = new Labyrinthe();
        Porte p = new Porte(5,8);
        Joueur j = new Joueur(l,p);

        assertEquals("le joueur doit etre en x=5", j.getCase().x, 5);
        assertEquals("le joueur doit etre en y=8", j.getCase().y, 8);

    }



}