package jeu.entites;

import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe modelisant une arme
 *
 * @author AGJMX
 */
public class Arme {

    /**
     * attribut entier correspondant au degats de l'arme
     */
    private final int degats;

    /**
     * Constructeur d Arme qui construit une arme en fonction du parametre
     *
     * @param d degats de l'arme
     */
    public Arme(int d) {
        this.degats = d;
    }

    /**
     * Getter des degats de l'arme
     *
     * @return degats de l'arme
     */
    public int getDegats() {
        return this.degats;
    }

    /**
     * Methode dessiner
     *
     * @param crayon graphics du panel
     * @throws IOException Exception de file
     */
    public void dessiner(Graphics2D crayon) throws IOException {
        //TODO ARME
        //crayon.drawImage(ImageIO.read(new File("../utils/assets/Arme.png")), x * DessinJeu.TAILLE_CASE, y * DessinJeu.TAILLE_CASE, null);
    }
}
