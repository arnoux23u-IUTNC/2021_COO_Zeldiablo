package jeu;

import jeu.Labyrinthe;
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
    public void evoluer(Direction d);

    /**
     * methode test fini
     *
     * @return true si et seulement si le jeu est fini
     */
    public boolean etreFini();

}
