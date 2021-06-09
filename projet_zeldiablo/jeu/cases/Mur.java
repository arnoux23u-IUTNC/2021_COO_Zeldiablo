package jeu.cases;

import jeu.entites.Personnage;

/**
 * Classe modelisant un Mur
 *
 * @author AGJMX
 */
public class Mur extends Obstacle {

    /**
     * Caractere permettant l'identification sur une map
     */
    private static final char IDENTIFIER = 'O';

    /**
     * Methode getIdentifier
     *
     * @return String, caractere d'identification
     */
    @Override
    public String getIdentifier() {
        return Character.toString(IDENTIFIER);
    }

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Mur(int x, int y) {
        super(x, y);
    }

}