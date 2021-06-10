package jeu.entites;

import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.cases.*;
import moteurgraphique.DessinJeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Classe modelisant un Joueur
 *
 * @author AGJMX
 */

public class Joueur extends Personnage {

    /**
     * Texture du Joueur vide
     */
    private final Image textureVide;

    /**
     * Texture du Joueur avec arme
     */
    private final Image textureArme;

    /**
     * Texture du Joueur avec bouclier
     */
    private final Image textureBouclier;

    /**
     * Texture du Joueur avec bouclier et arme
     */
    private final Image textureBouclierArme;

    /**
     * Arme du joueur
     */
    private Arme armeEnMain;

    /**
     * Bouclier du joueur
     */
    private Bouclier bouclierEnMain;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l Labyrinthe sur lequel il joue
     * @param e Point d'apparition
     */
    public Joueur(Labyrinthe l, Porte e) throws IOException {
        super(l, e, 20, 1);
        e.setFerme(true);
        armeEnMain = null;
        bouclierEnMain = null;
        textureVide = ImageIO.read(new File(JeuPerso.assetsDirectory, "CharacterV2.png"));
        textureBouclier = ImageIO.read(new File(JeuPerso.assetsDirectory, "CharacterBouclierV2.png"));
        textureArme = ImageIO.read(new File(JeuPerso.assetsDirectory, "CharacterArmeV2.png"));
        textureBouclierArme = ImageIO.read(new File(JeuPerso.assetsDirectory, "CharacterFullV2.png"));
    }

    /**
     * Methode pour attaquer tout autour de lui
     */
    public void attaquerAutour() {
        Labyrinthe l = getLabyrinthe();
        for (Monstre monstre : l.getlMonstre()) {
            Case n = monstre.getCase();
            if (trouverCasesAutour().contains(n)) {
                this.attaquer(monstre);
            }
        }
        l.supprimerLesMorts();
    }

    /**
     * methode qui permet dajouter une arme a linventaire
     *
     * @param arme arme a ajouter
     */
    public void ajouterArme(Arme arme) {
        this.armeEnMain = arme;
    }

    public Arme getArmeEnMain() {
        return this.armeEnMain;
    }

    /**
     * methode qui permet dajouter un bouclier a linventaire
     *
     * @param bouclier bouclier a ajouter
     */
    public void ajouterBouclier(Bouclier bouclier) {
        this.bouclierEnMain = bouclier;
    }

    /**
     * Methode permettant de diminuer la vie du joueur
     *
     * @param vieDown retrait
     */
    public void diminuerVie(int vieDown) {
        if (bouclierEnMain != null) {
            int degatsubis = bouclierEnMain.diminuerResistance(vieDown);
            super.diminuerVie(degatsubis);
            if (bouclierEnMain.etreCasseBouclier()) {
                bouclierEnMain = null;
            }
        } else {
            super.diminuerVie(vieDown);
        }
    }

    @Override
    public boolean peutTraverserChemin() {
        return true;
    }

    @Override
    public boolean peutTraverserMur() {
        return false;
    }

    @Override
    public boolean peutTraverserPiege() {
        return true;
    }

    @Override
    public boolean peutTraverserPorte() {
        return true;
    }

    @Override
    public boolean isJoueur() {
        return true;
    }

    @Override
    public boolean isTroll() {
        return false;
    }

    @Override
    public void dessiner(Graphics2D crayon) {
        getLabyrinthe().dessiner(crayon);
        if (armeEnMain != null && bouclierEnMain != null)
            crayon.drawImage(textureBouclierArme, getCase().x * DessinJeu.TAILLE_CASE, getCase().y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
        else
            crayon.drawImage(armeEnMain != null ? textureArme : bouclierEnMain != null ? textureBouclier : textureVide, getCase().x * DessinJeu.TAILLE_CASE, getCase().y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, null);
        crayon.setColor(Color.red);
        crayon.fillRect(DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 1) * DessinJeu.TAILLE_CASE, 20 * getPv(), 20);
        crayon.setColor(Color.black);
        crayon.setFont(new Font("Arial", Font.PLAIN, 20));
        crayon.drawString("" + getPv() + "/20", DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 3) * DessinJeu.TAILLE_CASE);
        crayon.drawRect(DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 1) * DessinJeu.TAILLE_CASE, 400, 20);

        if (this.bouclierEnMain != null) {
            crayon.setColor(Color.orange);
            crayon.fillRect(DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 4) * DessinJeu.TAILLE_CASE, 20 * bouclierEnMain.getResistance(), 20);
            crayon.setColor(Color.black);
            crayon.setFont(new Font("Arial", Font.PLAIN, 20));
            crayon.drawString("" + bouclierEnMain.getResistance() + "/20", DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 6) * DessinJeu.TAILLE_CASE);
            crayon.drawRect(DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 4) * DessinJeu.TAILLE_CASE, 400, 20);
        }
    }
}
