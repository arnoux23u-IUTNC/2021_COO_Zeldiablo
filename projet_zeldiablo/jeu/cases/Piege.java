package jeu.cases;

import jeu.entites.Joueur;
import jeu.entites.Personnage;


/**
 * Classe modelisant un Piege
 *
 * @author AGJMX
 */
public class Piege extends Obstacle {

    /**
     * Caractere permettant l'identification sur une map
     */
    private static final char IDENTIFIER = 'P';

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
    public Piege(int x, int y) {
        super(x, y);
    }

    /**
     * Methode pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si peut passer dessus
     */
    @Override
    public boolean peutTraverser(Personnage p) {
        return true;
    }

    /**
     * Methode retirant 1pv du joueur
     * @param p personnage auquel on retire 1pv
     *
     */
    public void prendDegats(Personnage p) {
        switch (p.getClass().getSimpleName()) {
            case "Joueur":
                p.diminuerVie(1);
                break;
        }

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
