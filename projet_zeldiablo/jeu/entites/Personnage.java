package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.utils.Direction;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Classe modelisant un personnage, de type passif (joueur) ou actif (monstre)
 *
 * @author AGJMX
 */
public abstract class Personnage {

    /**
     * Position du joueur
     */
    private Case position;

    /**
     * Labyrinthe actuel
     */
    private final Labyrinthe l;

    /**
     * HP du Personnage
     */
    private int pv;

    /**
     * Degats du Personnage
     */
    private final int degats;

    /**
     * Constructeur public par defaut a quatre parametres
     *
     * @param l           labyrinthe
     * @param depart      position de depart
     * @param pointsDeVie points de vie
     * @param degats      degats infliges
     * @throws IOException texture
     */
    public Personnage(Labyrinthe l, Case depart, int pointsDeVie, int degats) throws IOException {
        this.position = depart;
        this.l = l;
        this.degats = degats;
        this.pv = pointsDeVie;
    }

    /**
     * Getter position
     *
     * @return position du personnage
     */
    public Case getCase() {
        return position;
    }

    /**
     * Setter position
     *
     * @param position nouvelle position du joueur
     */
    public void setPosition(Case position) {
        this.position = position;
    }

    /**
     * Methode pour deplacer un personnage
     *
     * @param d direction voulue
     * @return booleen, a vrai s'il a ete deplace
     */
    public boolean seDeplacer(Direction d) {
        if (d == null)
            return false;
        return l.deplacerPersonnage(this, d);
    }

    /**
     * Methode pour diminuer la vie du personnage
     *
     * @param vieDown retrait
     */
    public void diminuerVie(int vieDown) {
        if (vieDown > 0 && pv > 0) {
            this.pv = Math.max(pv - vieDown, 0);
        }
    }

    /**
     * Methode pour augmenter la vie du personnage
     *
     * @param vieUp augmentation
     */
    public void augmenterVie(int vieUp) {
        if (vieUp > 0 && pv > 0) {
            this.pv += vieUp;
        }
    }

    /**
     * Getter PV
     *
     * @return pvs du personnage
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Methode pour attaquer un autre personnage
     *
     * @param p victime
     */
    public void attaquer(Personnage p) {
        if (this.isJoueur()) {
            if (p.isTroll())
                ((Troll) p).trollSeFaitAttaquer();
            Arme arme = ((Joueur) this).getArmeEnMain();
            p.diminuerVie(arme != null ? arme.getDegats() + this.degats : this.degats);
        } else {
            if (p.isJoueur())
                p.diminuerVie(this.degats);
        }
    }

    /**
     * Methode equals
     *
     * @param o objet a comparer
     * @return booleen, a vrai si egal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personnage)) return false;
        Personnage that = (Personnage) o;
        return pv == that.pv && degats == that.degats && Objects.equals(position, that.position) && Objects.equals(l, that.l);
    }

    /**
     * Methode etreMort
     *
     * @return booleen, a vrai si mort
     */
    public boolean etreMort() {
        return this.pv <= 0;
    }

    /**
     * Methode peutTraverserChemin
     *
     * @return booleen, a vrai si p peut traverser le chemin
     */
    public abstract boolean peutTraverserChemin();

    /**
     * Methode peutTraverserMur
     *
     * @return booleen, a vrai si p peut traverser le mur
     */
    public abstract boolean peutTraverserMur();

    /**
     * Methode peutTraverserPiege
     *
     * @return booleen, a vrai si p peut traverser le piege
     */
    public abstract boolean peutTraverserPiege();

    /**
     * Methode peutTraverserPorte
     *
     * @return booleen, a vrai si p peut traverser la porte
     */
    public abstract boolean peutTraverserPorte();

    /**
     * Methode isJoueur
     *
     * @return booleen, a vrai si c'est un Joueur
     */
    public abstract boolean isJoueur();

    /**
     * Methode isTroll
     *
     * @return booleen, a vrai si c'est un troll
     */
    public abstract boolean isTroll();

    /**
     * Methode abstraite dessiner
     *
     * @param crayon graphics
     */
    public abstract void dessiner(Graphics2D crayon);

    /**
     * Getter Labyrinthe
     *
     * @return Labyrinthe
     */
    public Labyrinthe getLabyrinthe() {
        return l;
    }

    /**
     * Methode pour trouver les cases autour du Joueur
     *
     * @return Cases autour du joueur
     */
    public ArrayList<Case> trouverCasesAutour() {
        Case c = this.getCase();
        Case nord, sud, est, ouest;
        try {
            nord = l.getCase(Math.max(c.x, 0), Math.max(c.y - 1, 0));
        } catch (IndexOutOfBoundsException ignored) {
            nord = null;
        }
        try {
            sud = l.getCase(Math.max(c.x, 0), Math.max(c.y + 1, 0));
        } catch (IndexOutOfBoundsException ignored) {
            sud = null;
        }
        try {
            est = l.getCase(Math.max(c.x + 1, 0), Math.max(c.y, 0));
        } catch (IndexOutOfBoundsException ignored) {
            est = null;
        }
        try {
            ouest = l.getCase(Math.max(c.x - 1, 0), Math.max(c.y, 0));
        } catch (IndexOutOfBoundsException ignored) {
            ouest = null;
        }
        ArrayList<Case> caseautour = new ArrayList<Case>();
        caseautour.add(nord);
        caseautour.add(sud);
        caseautour.add(est);
        caseautour.add(ouest);
        return caseautour;
    }
}