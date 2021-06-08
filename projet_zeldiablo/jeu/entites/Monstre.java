package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

/**
 * Classe abstraite pour modeliser un monstre
 *
 * @author AGJMX
 */
public abstract class Monstre extends Personnage {

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Monstre(Labyrinthe l, Case depart, int pointsDeVie, int degats) {
        super(l, depart, pointsDeVie, degats);
    }
}
