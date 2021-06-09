package jeu.cases;

import moteurgraphique.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.setColor(Color.orange);
        crayon.fillRect(x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE);
    }
}
