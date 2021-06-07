package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Porte;

/**
 * Classe modelisant un Joueur
 *
 * @author AGJMX
 */

public class Joueur extends Personnage {

    /**
     * PV du Joueur
     */
    private static final int PV = 20;

    /**
     * Degats du joueur
     */
    private static final int DEGATS = 4;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l Labyrinthe sur lequel il joue
     * @param e Point d'apparition
     */
    public Joueur(Labyrinthe l, Porte e) {
        super(l, e, PV, DEGATS);
        e.setFerme(true);
    }

}
