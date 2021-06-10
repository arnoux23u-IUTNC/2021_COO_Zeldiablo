package jeu.entites;

import jeu.JeuPerso;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

/**
 * Classe modelisant un bouclier
 *
 * @author AGJMX
 */
public class Bouclier {

    /**
     * attribut eniter correspondant a la resistance du bouclier
     */
    private int resistance;

    /**
     * Texture du bouclier
     */
    private final Image texture;

    /**
     * constructeur de bouclier
     *
     * @param resi resistance du bouclier
     */
    public Bouclier(int resi) throws IOException {
        this.resistance = resi;
        texture = read(new File(JeuPerso.assetsDirectory, "Bouclier.png"));
    }

    /**
     * getter de la resistance
     *
     * @return la resistance du bouclier
     */
    public int getResistance() {
        return resistance;
    }

    /**
     * methode qui permets de diminuer la resistance du boucleir
     *
     * @param degats degats pris dans le bouclier
     *               //TODO COMPRENDRE
     * @return degats du joueur
     */
    public int diminuerResistance(int degats) {
        int degatsjoueur = 0;
        if (degats > 0) {
            if (resistance - degats > 0) {
                resistance -= degats;
            } else {
                degatsjoueur = degats - resistance;
            }
        }
        return degatsjoueur;
    }

    /**
     * methode qui permets de savoir si le bouclier est casse ou non
     *
     * @return true si resistance est inferieure ou egale a zero
     */
    public boolean etreCasseBouclier() {
        return resistance <= 0;
    }

    public void dessiner(Graphics2D crayon) {
        //crayon.drawImage(this.texture, x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, null);
    }
}
