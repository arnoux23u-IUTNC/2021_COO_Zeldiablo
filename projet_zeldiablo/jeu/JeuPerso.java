package jeu;

import jeu.cases.Case;
import jeu.cases.Piege;
import jeu.entites.*;
import jeu.utils.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Classe modelisant le jeu d'un personnage
 * Implemente Jeu
 */
public class JeuPerso implements Jeu {

    /**
     * Labyrinthe concerne
     */
    private Labyrinthe l;

    /**
     * Joueur concerne
     */
    private Joueur pj;

    /**
     * Booleen, a vrai si la partie n'est pas finie
     */
    private boolean partieEnCours;

    /**
     * Constructeur public par defaut
     */
    public JeuPerso() {
        this.partieEnCours = true;
        this.l = new Labyrinthe(true);
        this.pj = l.getJoueur();
    }

    /**
     * Methode d'evolution
     *
     * @param d direction de l'utilisateur
     */
    @Override
    public void evoluer(Direction d, boolean b) {
        this.pj.seDeplacer(d);
        if (b) {
            this.pj.attaquerAutour();
        }
        l.supprimerLesMorts();
    }

    /**
     * Methode de test fini
     *
     * @return booleen, a vrai si fini
     */
    @Override
    public boolean etreFini() {
        if (!pj.etreMort() && !pj.getCase().equals(getLabyrinthe().getSortie())) {
            return false;
        }
        System.out.println("Vous êtes mort");
        return true;
    }

    /**
     * Getter joueur
     *
     * @return joueur
     */
    public Joueur getJoueur() {
        return pj;
    }

    /**
     * Getter labyrinthe
     *
     * @return labyrinthe
     */
    public Labyrinthe getLabyrinthe() {
        return l;
    }

    public void dessiner(Graphics2D im) {
        l.dessiner(im);
        pj.dessiner(im);
    }
}