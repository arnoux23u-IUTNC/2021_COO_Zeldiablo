package jeu;

import jeu.entites.*;
import jeu.utils.*;

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
    public void evoluer(Direction d) {
        this.pj.seDeplacer(d);
    }

    /**
     * Methode de test fini
     *
     * @return booleen, a vrai si fini
     */
    @Override
    public boolean etreFini() {
        if(!pj.etreMort()){
            return !partieEnCours;
        }
        else{
            System.out.println("Vous êtes mort");
        }
        return partieEnCours;
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
}

