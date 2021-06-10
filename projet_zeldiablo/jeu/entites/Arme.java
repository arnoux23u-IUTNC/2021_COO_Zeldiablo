package jeu.entites;

import jeu.JeuPerso;
import jeu.cases.Case;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

/**
 * Classe modelisant une arme
 *
 * @author AGJMX
 */
public class Arme {

    /**
     * Texture de l'arme
     */
    public final Image texture;

    /**
     * attribut entier correspondant au degats de l'arme
     */
    private final int degats;

    /**
     * Constructeur d Arme qui construit une arme en fonction du parametre
     *
     * @param degats degats de l'arme
     * @throws IOException File exception
     */
    public Arme(int degats) throws IOException {
        this.degats = degats;
        this.texture = ImageIO.read(new File(JeuPerso.assetsDirectory, "Arme.png"));
    }

    /**
     * Getter des degats de l'arme
     *
     * @return degats de l'arme
     */
    public int getDegats() {
        return this.degats;
    }

}
