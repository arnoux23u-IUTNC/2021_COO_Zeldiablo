package jeu.cases;

import jeu.JeuPerso;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe modelisant un Piege
 *
 * @author AGJMX
 */
public class Piege extends Obstacle {


    Image texture;

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
    public Piege(int x, int y) throws IOException {
        super(x, y);
        texture = ImageIO.read(new File(JeuPerso.assetsDirectory,"Piege.png"));
    }

    /**
     * Methode dessiner
     *
     * @param crayon graphics du panel
     * @throws IOException Exception de file
     */
    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.drawImage(texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE,DessinJeu.TAILLE_CASE,null);
    }
}
