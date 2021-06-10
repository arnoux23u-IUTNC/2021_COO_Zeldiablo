package jeu;

import jeu.utils.Direction;

/**
 * Interface modelisant un Objet Jeu
 * Celui ci est l'element mere
 *
 * @author AGJMX
 */
public interface Jeu {

    /**
     * methode qui contient l'evolution du jeu en fonction de la direction
     *
     * @param d direction de l'utilisateur
     */
    void evoluer(Direction d, boolean b);

    /**
     * methode test fini
     *
     * @return true si et seulement si le jeu est fini
     */
    boolean etreFini();

    /**
     * Methode d'evolution pour les monstres
     */
    void evoluerMonstres();
}
