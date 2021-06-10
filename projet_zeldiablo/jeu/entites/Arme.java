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
     * Position sur la carte
     */
    private Case position;

    /**
     * Texture de l'arme
     */
    private final Image texture;

    /**
     * attribut entier correspondant au degats de l'arme
     */
    private final int degats;

    /**
     * Constructeur d Arme qui construit une arme en fonction du parametre
     *
     * @param degats degats de l'arme
     * @param position position de l'arme
     * @throws IOException File exception
     */
    public Arme(int degats, Case position) throws IOException {
        this.degats = degats;
        this.position = position;
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

    /**
     * Methode dessiner
     *
     * @param crayon graphics du panel
     */
    public void dessiner(Graphics2D crayon) {
        crayon.drawImage(this.texture, position.x * DessinJeu.TAILLE_CASE, position.y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
    }
}
