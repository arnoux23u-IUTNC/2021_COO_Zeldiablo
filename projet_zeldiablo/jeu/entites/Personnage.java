package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.utils.Direction;

/**
 * Classe modelisant un personnage, de type passif (joueur) ou actif (monstre)
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
        position = depart;
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



    public void diminuerVie(int vieDown){
        this.setPv(this.getPv()-vieDown);
    }

    public void augmenterVie(int vieUp){
        if(vieUp>0){
            this.setPv(this.getPv()+vieUp);
        }
    }

    public int getPv(){
        return this.pv;
    }

    public void setPv(int newPV){
        this.pv = newPV;
    }

    public void attaquer(Personnage p){
        if(p instanceof Troll){
            ((Troll) p).trollSeFaitAttaquer();
        }
        p.diminuerVie(this.degats);
    }
}
