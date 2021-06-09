package moteurgraphique;

import jeu.*;
import jeu.cases.Case;
import jeu.cases.Piege;
import jeu.entites.*;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.swing.*;

/**
 * Classe modelisant le dessin du Jeu
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
    public void dessiner(BufferedImage im) throws IOException {
        jeuEnCours.dessiner((Graphics2D) im.getGraphics());
    }

}
