package jeu.cases;

import jeu.JeuPerso;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe modelisant une porte
 *
 * @author AGJMX
 */
public class Porte extends Case {

    /**
     * Texture de la porte
     */
    private final Image texture;

    /**
     * Caractere permettant l'identification sur une map
     */
    public static final char IDENTIFIER = 'E';

    /**
     * Booleen, a vrai si la porte est fermee
     * Une porte est par defaut ouverte, elle se ferme quand le joueur y passe
     */
    private boolean ferme;


    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Porte(int x, int y) throws IOException {
        super(x, y);
        ferme = false;
        texture = ImageIO.read(new File(JeuPerso.assetsDirectory, "Porte.png"));
    }

    /**
     * Setter ferme
     *
     * @param b etat de la porte
     */
    public void setFerme(boolean b) {
        this.ferme = b;
    }

    /**
     * Getter ferme
     *
     * @return etat de la porte
     */
    public boolean isFerme() {
        return ferme;
    }

    @Override
    public String getIdentifier() {
        return Character.toString(IDENTIFIER);
    }

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.drawImage(texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
    }
}
