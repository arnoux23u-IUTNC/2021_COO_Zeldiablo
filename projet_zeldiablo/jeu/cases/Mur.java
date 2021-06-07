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
    private static final char IDENTIFIER = '\u220E';

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

    /**
     * Methode pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si "p" peut passer dessus
     */
    @Override
    public boolean peutTraverser(Personnage p) {
        switch (p.getClass().getSimpleName()) {
            case "Fantome":
                return true;
        }
        return false;
    }
}