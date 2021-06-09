package jeu.cases;

import jeu.JeuPerso;
import jeu.Labyrinthe;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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
     * Methode dessiner
     *
     * @param crayon graphics
     * @throws IOException Exception de l'image
     */
    @Override
    public void dessiner(Graphics2D crayon) throws IOException {
        crayon.drawImage(ImageIO.read(new File(JeuPerso.assetsDirectory,"Chemin.png")), x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE,DessinJeu.TAILLE_CASE,null);
    }
}
