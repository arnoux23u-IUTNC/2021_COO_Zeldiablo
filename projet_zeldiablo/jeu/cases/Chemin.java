package jeu.cases;

import jeu.entites.Personnage;

/**
 * Classe representant un chemin vide
 *
 * @author AGJMX
 */
public class Chemin extends Case {

    /**
     * Caractere permettant l'identification sur une map
     */
    private static final char IDENTIFIER = 'X';

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
    public Chemin(int x, int y) {
        super(x, y);
    }

    /**
     * Methode pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si "p" peut passer dessus
     */
    @Override
    public boolean peutTraverser(Personnage p) {
        return true;
    }

}
