package jeu;

import jeu.entites.*;
import jeu.utils.*;

public class JeuPerso implements Jeu {

    private Labyrinthe l;
    private Joueur pj;
    private boolean partieEnCours;

    public JeuPerso() {
        this.partieEnCours = true;
        this.l = new Labyrinthe();
        this.pj = l.getJoueur();
    }


    @Override
    public void evoluer(Direction d) {
        this.pj.seDeplacer(d);
    }

    @Override
    public boolean etreFini() {
        return !partieEnCours;
    }

    public Joueur getJoueur() {
        return pj;
    }
}
