package jeu.cases;

import jeu.JeuPerso;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

/**
 * Classe modelisant un Piege
 *
 * @author AGJMX
 */
public class Piege extends Obstacle {

    /**
     * Texture du piege
     */
    private final Image texture;

    /**
     * Caractere permettant l'identification sur une map
     */
    private static final char IDENTIFIER = 'P';

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     * @throws IOException texture
     */
    public Piege(int x, int y) throws IOException {
        super(x, y);
        texture = ImageIO.read(new File(JeuPerso.assetsDirectory, "PiegeV2.png"));
    }

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.drawImage(texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
    }

    @Override
    public String getIdentifier() {
        return Character.toString(IDENTIFIER);
    }

}
