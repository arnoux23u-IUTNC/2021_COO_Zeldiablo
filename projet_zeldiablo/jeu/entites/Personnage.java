package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.utils.Direction;

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
    private int degats;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Personnage(Labyrinthe l, Case depart, int pointsDeVie, int degats) {
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
        return l.deplacerJoueur(this, d);
    }

    /**
     * Methode pour diminuer la vie du personnage
     *
     * @param vieDown retrait
     */
    public void diminuerVie(int vieDown) {
        if (vieDown > 0) {
            if (this.getPv() - vieDown > 0) {
                this.setPv(this.getPv() - vieDown);
            } else {
                this.setPv(0);
            }
        }
    }

    /**
     * Methode pour augmenter la vie du personnage
     *
     * @param vieUp augmentation
     */
    public void augmenterVie(int vieUp) {
        if (vieUp > 0) {
            if (this.getPv() > 0) {
                this.setPv(this.getPv() + vieUp);
            }
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
     * Setter PV
     *
     * @param newPV nouveaux pv du personnage
     */
    public void setPv(int newPV) {
        this.pv = newPV;
    }

    /**
     * Methode pour attaquer un autre personnage
     *
     * @param p victime
     */
    public void attaquer(Personnage p) {
        if (p instanceof Troll) {
            ((Troll) p).trollSeFaitAttaquer();
        }
        p.diminuerVie(this.degats);
    }


    //methode qui renvoie true si les PV du personnage tombent a 0

    public boolean etreMort(){
        if (this.pv > 0) {
            return false;
        }
            return true;
    }

    /**
     * Getter labyrinthe
     * @return labyrinthe
     */
    public Labyrinthe getLabyrinthe() {
        return l;
    }
}