package jeu.cases;

import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.entites.Personnage;

/**
 * Interface modelisant une case dans le labyrinthe
 *
 * @author AGJMX
 */
public abstract class Case {

    /**
     * Attribut representant l'abscisse de la case
     */
    public final int x;

    /**
     * Attribut representant l'ordonnee de la case
     */
    public final int y;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Case(int x, int y) {
        this.x = x < 0 ? 0 : Math.min(x, Labyrinthe.TAILLE - 1);
        this.y = y < 0 ? 0 : Math.min(y, Labyrinthe.TAILLE - 1);
    }

    /**
     * Methode abstraite pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si "p" peut passer dessus
     */
    public abstract boolean peutTraverser(Personnage p);

    /**
     * Methode getIdentifier
     *
     * @return String, caractere d'identification
     */
    public abstract String getIdentifier();

    /**
     * Methode toString
     *
     * @return String, affichage
     */
    @Override
    public String toString() {
        return getIdentifier().toUpperCase();
    }
}
