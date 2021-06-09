package jeu.cases;

import moteurgraphique.DessinJeu;

import java.awt.*;

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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.setColor(Color.black);
        crayon.fillRect(x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE);
    }
}
