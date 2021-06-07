package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

/**
 * Classe modelisant un fantome
 *
 * @author AGJMX
 */
public class Fantome extends Monstre {

    /**
     * PV du fantome
     */
    private static final int PV = 5;

    /**
     * Degats du fantome
     */
    private static final int DEGATS = 1;


    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Fantome(Labyrinthe l, Case depart) {
        super(l, depart, PV, DEGATS);
    }
}
