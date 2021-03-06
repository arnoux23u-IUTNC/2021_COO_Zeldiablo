package jeu.cases;

import jeu.Labyrinthe;
import jeu.entites.Arme;
import jeu.entites.Bouclier;

import java.awt.*;
import java.io.IOException;

/**
 * Classe abstraite modelisant une case dans le labyrinthe
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
     * @throws IOException File exception
     */
    public Case(int x, int y) throws IOException {
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

    /**
     * Methode ecrasee equals
     *
     * @param o objet a comparer
     * @return booleen, a vrai si memes objets
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Case)) return false;
        Case aCase = (Case) o;
        return x == aCase.x && y == aCase.y;
    }

    /**
     * Methode abstraite dessiner
     *
     * @param crayon graphics du panel
     */
    public abstract void dessiner(Graphics2D crayon);
}
