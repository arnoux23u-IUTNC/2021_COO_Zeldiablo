package jeu;

import jeu.entites.*;
import jeu.utils.*;

import java.awt.*;
import java.io.IOException;

/**
 * Classe modelisant le jeu d'un personnage
 * Implemente Jeu
 *
 * @author AGJMX
 */
public class JeuPerso implements Jeu {

    /**
     * Labyrinthe concerne
     */
    private final Labyrinthe l;

    /**
     * Joueur concerne
     */
    private final Joueur pj;

    /**
     * Repertoire des assets
     */
    public static final String assetsDirectory = "projet_zeldiablo\\jeu\\utils\\assets\\";

    /**
     * Constructeur public par defaut
     */
    public JeuPerso() throws IOException {
        this.l = new Labyrinthe(true);
        this.pj = new Joueur(l, l.getEntree());
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

    /**
     * Methode dessiner
     *
     * @param crayon graphics
     */
    public void dessiner(Graphics2D crayon) {
        l.dessiner(crayon);
        pj.dessiner(crayon);
    }
}