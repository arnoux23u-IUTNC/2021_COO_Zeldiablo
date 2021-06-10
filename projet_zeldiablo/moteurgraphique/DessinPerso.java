package moteurgraphique;

import jeu.*;

import java.awt.*;
import java.awt.image.*;

/**
 * Classe modelisant le dessin du Jeu
 *
 * @author vthomas
 * @author AGJMX
 */
public class DessinPerso implements DessinJeu {

    /**
     * lien vers le jeu a afficher
     */
    private final JeuPerso jeuEnCours;

    /**
     * appelle constructeur parent
     *
     * @param j le jeutest a afficher
     */
    public DessinPerso(JeuPerso j) {
        this.jeuEnCours = j;
    }

    /**
     * methode dessiner redefinie de Afficheur retourne une image du jeu
     */
    @Override
    public void dessiner(BufferedImage im) {
        jeuEnCours.dessiner((Graphics2D) im.getGraphics());
    }
}
