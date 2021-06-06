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
      assertEquals("cette case est cense etre une porte", );
      assertEquals("cette case est cense etre un mur", );
      assertEquals("cette case est cense etre un chemin", );
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

  @Test
  public void test_getDestination(){
      Labyrinthe l = new Labyrinthe();
      Porte e = new Porte(0,0);
      Joueur j = new Joueur(l,e);
  }




}
