package jeu.cases;

import jeu.Labyrinthe;
import jeu.entites.Personnage;

import java.util.Objects;

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
     * Attribut représentant le personnage sur la case
     */
    private Personnage p;

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

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Case aCase = (Case) o;
        return x == aCase.x && y == aCase.y && getIdentifier().equals(aCase.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Methode permettant d'indiquer le personnage sur la case
     *
     * @param per personnage sur la case
     */
    public void setPersonnage(Personnage per) {
        this.p = per;
    }

    /**
     * Methode permettant de retirer un personnage de la case
     */
    public void removePersonnage() {
        this.p = null;
    }

    /**
     * Methode retournant le personnage sur la case
     *
     * @return le personnage p
     */
    public Personnage getPersonnage() {
        return this.p;
    }
}
