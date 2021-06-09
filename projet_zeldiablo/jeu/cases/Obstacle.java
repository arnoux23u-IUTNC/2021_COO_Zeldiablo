package jeu.cases;

/**
 * Classe modelisant un obstacle
 *
 * @author AGJMX
 */
public abstract class Obstacle extends Case {

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Obstacle(int x, int y) {
        super(x, y);
    }
}