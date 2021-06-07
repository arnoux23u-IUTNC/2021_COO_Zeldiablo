package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

/**
 * Classe modelisant un troll
 *
 * @author AGJMX
 */
public class Troll extends Monstre {

    /**
     * booleen qui permet de determiner si le troll a ete tape dans le tour
     */
    private boolean tapeDansLeTour;

    /**
     * PV du Troll
     */
    private static final int PV = 3;

    /**
     * Degats du troll
     */
    private static final int DEGATS = 3;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Troll(Labyrinthe l, Case depart) {
        super(l, depart, PV, DEGATS);
        tapeDansLeTour = false;
    }

    /**
     * methode qui permet de regenerer le troll s'il n'a pas ete tape
     */
    public void seRegenerer() {
        if (!tapeDansLeTour) {
            this.setPv(this.getPv() + 1);
        }
    }

    /**
     * Methode pour dire que le troll se fait attaquer
     */
    public void trollSeFaitAttaquer() {
        tapeDansLeTour = true;
    }
}
