package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

import java.io.IOException;

/**
 * Classe abstraite pour modeliser un monstre
 *
 * @author AGJMX
 */
public abstract class Monstre extends Personnage {

    /**
     * Intelligence du monstre
     */
    private final int intelligence;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Monstre(Labyrinthe l, Case depart, int pointsDeVie, int degats, int intelligence) throws IOException {
        super(l, depart, pointsDeVie, degats);
        this.intelligence = intelligence;
    }

    /**
     * Getter intelligence
     *
     * @return intelligence du monstre
     */
    public int getIntelligence() {
        return intelligence;
    }
}
