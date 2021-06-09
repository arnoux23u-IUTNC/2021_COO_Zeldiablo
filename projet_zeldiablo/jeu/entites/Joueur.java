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

    private Arme armeEnMain;
    private Bouclier bouclierEnMain;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l Labyrinthe sur lequel il joue
     * @param e Point d'apparition
     */
    public Joueur(Labyrinthe l, Porte e) {
        super(l, e, 20, 1);
        e.setFerme(true);
        armeEnMain = null;
        bouclierEnMain = null;
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

    /**
     * methode qui permet dajouter une arme a linventaire
     * @param arme arme a ajouter
     */
    public void ajouterArme(Arme arme){
        this.armeEnMain = arme;
        setDegats(this.getDegats()+armeEnMain.getDegats());
    }
    /**
     * methode qui permet dajouter un bouclier a linventaire
     * @param bouclier bouclier a ajouter
     */
    public void ajouterBouclier(Bouclier bouclier){
        this.bouclierEnMain = bouclier;
        this.setPv(this.getPv()+ bouclier.getResistance());
    }

    @Override
    public void diminuerVie(int vieDown) {
        super.diminuerVie(vieDown);
        if(bouclierEnMain!= null){
            bouclierEnMain.diminuerResistance(vieDown);
            if(bouclierEnMain.etreCasserBouclier()){
                bouclierEnMain = null;
            }
        }
    }

    @Override
    public boolean peutTraverserChemin() {
        return true;
    }

    @Override
    public boolean peutTraverserMur() {
        return false;
    }

    @Override
    public boolean peutTraverserPiege() {
        return true;
    }

    @Override
    public boolean peutTraverserPorte() {
        return true;
    }

    @Override
    public boolean isJoueur() {
        return true;
    }

    @Override
    public boolean isTroll() {
        return false;
    }

    @Override
    public boolean isFantome() {
        return false;
    }
}
