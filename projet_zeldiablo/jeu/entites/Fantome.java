package jeu.entites;

import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.cases.Case;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe modelisant un fantome
 *
 * @author AGJMX
 */
public class Fantome extends Monstre {

    Image texture;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Fantome(Labyrinthe l, Case depart) throws IOException {
        super(l, depart, 5, 1, 3);
        texture = ImageIO.read(new File(JeuPerso.assetsDirectory,"Fantome.png"));
    }


    @Override
    public boolean peutTraverserChemin() {
        return true;
    }


    @Override
    public boolean peutTraverserMur() {
        return true;
    }


    @Override
    public boolean peutTraverserPiege() {
        return true;
    }


    @Override
    public boolean peutTraverserPorte() {
        return false;
    }


    @Override
    public boolean isJoueur() {
        return false;
    }


    @Override
    public boolean isTroll() {
        return false;
    }


    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.drawImage(texture, getCase().x * DessinJeu.TAILLE_CASE, getCase().y * DessinJeu.TAILLE_CASE,DessinJeu.TAILLE_CASE,DessinJeu.TAILLE_CASE, null);
    }
}
