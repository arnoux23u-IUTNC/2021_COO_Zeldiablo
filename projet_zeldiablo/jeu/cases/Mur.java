package jeu.cases;

import moteurgraphique.DessinJeu;

import java.awt.*;

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

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.setColor(Color.gray);
        crayon.fillRect(x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE);
    }
}