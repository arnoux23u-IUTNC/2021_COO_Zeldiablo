package jeu.cases;

import java.io.IOException;

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
     * @throws IOException texture
     */
    public Obstacle(int x, int y) throws IOException {
        super(x, y);
    }
}