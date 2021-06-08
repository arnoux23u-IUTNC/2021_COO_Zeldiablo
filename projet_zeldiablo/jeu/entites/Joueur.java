package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Porte;

import java.util.ArrayList;

/**
 * Classe modelisant un Joueur
 *
 * @author AGJMX
 */

public class Joueur extends Personnage {

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l Labyrinthe sur lequel il joue
     * @param e Point d'apparition
     */
    public Joueur(Labyrinthe l, Porte e) {
        super(l, e, 20, 5);
        e.setFerme(true);
    }

    public void attaquerAutour() {
        Case c = this.getCase();
        Labyrinthe l = getLabyrinthe();
        Case nord = l.getCase(c.x, Math.max(c.y - 1,0));
        Case sud = l.getCase(c.x, c.y + 1);
        Case est = l.getCase(c.x + 1, c.y);
        Case ouest = l.getCase(Math.max(c.x - 1,0), c.y);
        ArrayList<Case> caseautour = new ArrayList<Case>();
        caseautour.add(nord);
        caseautour.add(sud);
        caseautour.add(est);
        caseautour.add(ouest);
        for (Monstre monstre : l.getlMonstre()) {
            Case n = monstre.getCase();
            if (caseautour.contains(n)) {
                this.attaquer(monstre);
            }
        }
    }


}
