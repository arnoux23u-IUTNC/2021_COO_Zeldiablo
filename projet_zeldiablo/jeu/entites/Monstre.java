package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

public abstract class Monstre extends Personnage {
    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Monstre(Labyrinthe l, Case depart, int pdv, int d) {
        super(l, depart,pdv,d);
    }
}
