package jeu.cases;

import jeu.entites.Personnage;

/**
 * Classe modelisant une porte
 *
 * @author AGJMX
 */
public class Porte extends Case {

    /**
     * Caractere permettant l'identification sur une map
     */
    public static final char IDENTIFIER = 'E';

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
     * Booleen, a vrai si la porte est fermee
     * Une porte est par defaut ouverte, elle se ferme quand le joueur y passe
     */
    private boolean ferme;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Porte(int x, int y) {
        super(x, y);
        ferme = false;
    }

    /**
     * Setter ferme
     *
     * @param b etat de la porte
     */
    public void setFerme(boolean b) {
        this.ferme = b;
    }

    /**
     * Methode pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si "p" peut passer dessus
     */
    @Override
    public boolean peutTraverser(Personnage p) {
        //TODO VERIFIER FERME
        if (ferme) {
            return false;
        }
        switch (p.getClass().getSimpleName()) {
            case "Joueur":

                return true;
        }
        return false;
    }


}
