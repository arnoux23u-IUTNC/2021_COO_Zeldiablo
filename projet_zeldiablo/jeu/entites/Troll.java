package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

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
        super(l, depart, 3, 3);
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

    /**
     * Methode qui change l'etat attaque du troll
     */
    public void trollSeFaitAttaquer() {
        tapeDansLeTour = true;
    }
}
