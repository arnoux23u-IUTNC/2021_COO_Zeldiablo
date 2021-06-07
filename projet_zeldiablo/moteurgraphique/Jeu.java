package moteurgraphique;

import jeu.Labyrinthe;

/**
 * Interface modelisant un Objet Jeu
 * Celui ci est l'element mere
 *
 * @author AGJMX
 */
public interface Jeu {

    /**
     * methode qui contient l'evolution du jeu en fonction de la commande
     *
     * @param commandeUser
     *            commande utilisateur
     */
    public void evoluer(Commande commandeUser);

    /**
     * @return true si et seulement si le jeu est fini
     */
    public boolean etreFini();

}
