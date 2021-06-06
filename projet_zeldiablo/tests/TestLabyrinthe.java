package tests;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Porte;
import jeu.entites.Joueur;
import jeu.entites.Personnage;
import jeu.utils.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe pour les tests de Labyrinthe
 *
 * @author AGJMX
 */
public class TestLabyrinthe {

  @Test
  public void test_creerLabyrinthe(){
      Labyrinthe l = new Labyrinthe();
      String c1 = l.getCase(14,13);
      String c2 = l.getCase(0,1);
      String c3 = l.getCase(0,0);
      assertEquals("cette case est cense etre une porte","E", c1);
      assertEquals("cette case est cense etre un mur","\u220E", c2);
      assertEquals("cette case est cense etre un chemin","X", c3);
  }

  @Test
  public void test_deplacerJoueur(){
      Labyrinthe l = new Labyrinthe();
      Porte e = new Porte(0,0);
      Joueur j = new Joueur(l,e);
      l.deplacerJoueur(j,Direction.SOUTH);
      l.deplacerJoueur(j,Direction.EAST);
      assertEquals("mauvaise position en X",1,j.getCase().x);
      assertEquals("mauvaise position en Y",1,j.getCase().y);
  }



}
