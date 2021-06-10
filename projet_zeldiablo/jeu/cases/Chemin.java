package jeu.cases;

import jeu.JeuPerso;
import jeu.entites.Arme;
import jeu.entites.Bouclier;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

/**
 * Classe representant un chemin vide
 *
 * @author AGJMX
 */
public class Chemin extends Case {

    /**
     * Arme sur la case
     */
    private Arme arme;

    /**
     * Bouclier
     */
    private Bouclier bouclier;

    /**
     * Texture du chemin
     */
    private final Image texture;

    /**
     * Caractere permettant l'identification sur une map
     */
    private static final char IDENTIFIER = 'X';

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     * @throws IOException texture
     */
    public Chemin(int x, int y) throws IOException {
        super(x, y);
        texture = ImageIO.read(new File(JeuPerso.assetsDirectory, "CheminV2.png"));
    }

    @Override
    public String getIdentifier() {
        return Character.toString(IDENTIFIER);
    }

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.drawImage(texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
        if (arme != null)
            crayon.drawImage(arme.texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
        if (bouclier != null) {
            crayon.drawImage(bouclier.texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
        }
    }

    /**
     * Setter Arme
     *
     * @param arme nouvelle arme
     */
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    /**
     * Setter bouclier
     *
     * @param bouclier nouveau bouclier
     */
    public void setBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }

    /**
     * Getter Arme
     *
     * @return Arme
     */
    public Arme getArme() {
        return arme;
    }

    /**
     * Getter bouclier
     *
     * @return Bouclier
     */
    public Bouclier getBouclier() {
        return bouclier;
    }
}
