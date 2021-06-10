package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.utils.Direction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe abstraite pour modeliser un monstre
 *
 * @author AGJMX
 */
public abstract class Monstre extends Personnage {

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l           labyrinthe
     * @param depart      position de depart
     * @param pointsDeVie Points de vie du monstre
     * @param degats      degats engendres par ses attaques
     * @throws IOException texture
     */
    public Monstre(Labyrinthe l, Case depart, int pointsDeVie, int degats) throws IOException {
        super(l, depart, pointsDeVie, degats);
    }

    /**
     * Methode de deplacement du monstre
     *
     * @return booleen, a vrai si deplace
     */
    public boolean seDeplacerVersJoueur() {
        Direction[] directions = Direction.values();
        return this.seDeplacer(directions[new Random().nextInt(directions.length)]);
    }

    /**
     * Methode pour tenter d'attaquer le joueur
     */
    public void attaquerLeJoueur() {
        Labyrinthe l = getLabyrinthe();
        if (trouverCasesAutour().contains(l.getJoueur().getCase())) {
            System.out.println("gropdee");
            //this.attaquer(l.getJoueur());
        } else {
            //System.out.println("dochlamerde");
        }

        l.supprimerLesMorts();
    }
}
