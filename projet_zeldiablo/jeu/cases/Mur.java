package jeu.cases;

import jeu.JeuPerso;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.io.IOException;

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

    /**
     * Methode dessiner
     *
     * @param crayon graphics du panel
     * @throws IOException Exception de File
     */
    @Override
    public void dessiner(Graphics2D crayon) throws IOException {
        crayon.drawImage(ImageIO.read(new File(JeuPerso.assetsDirectory,"Mur.png")), x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE,DessinJeu.TAILLE_CASE,DessinJeu.TAILLE_CASE, null);
    }
}