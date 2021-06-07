package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

public class Fantome extends Monstre{
    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Fantome(Labyrinthe l, Case depart) {
        super(l, depart,5,1);
    }
}