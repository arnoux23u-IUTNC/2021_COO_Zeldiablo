package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import moteurgraphique.DessinJeu;

import java.awt.*;

public class Troll extends Monstre {


    /**
     * booleen qui permet de determiner si le troll a ete tape dans le tour
     */
    private boolean tapeDansLeTour;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Troll(Labyrinthe l, Case depart) {
        super(l, depart, 3, 3, 5);
        tapeDansLeTour = false;
    }

    /**
     * Methode qui permet de regenerer le troll s'il n'a pas ete tape
     */
    public void seRegenerer() {
        if (!tapeDansLeTour) {
            this.setPv(this.getPv() + 1);
        }

    }

    @Override
    public boolean isTroll() {
        return true;
    }

    /**
     * Methode qui change l'etat attaque du troll
     */
    public void trollSeFaitAttaquer() {
        tapeDansLeTour = true;
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
        return false;
    }

    @Override
    public boolean isJoueur() {
        return false;
    }

    @Override
    public void dessiner(Graphics2D crayon) {
        crayon.setColor(Color.magenta);
        crayon.fillOval(getCase().x * DessinJeu.TAILLE_CASE, getCase().y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE);
    }
}
