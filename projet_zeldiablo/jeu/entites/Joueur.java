package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Porte;
import moteurgraphique.DessinJeu;

import java.awt.*;
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
        if (nord != null) caseautour.add(nord);
        if (nord != sud) caseautour.add(sud);
        if (nord != est) caseautour.add(est);
        if (nord != ouest) caseautour.add(ouest);
        for (Monstre monstre : l.getlMonstre()) {
            Case n = monstre.getCase();
            if (caseautour.contains(n)) {
                this.attaquer(monstre);
            }
        }
    }

    /**
     * methode qui permet dajouter une arme a linventaire
     *
     * @param arme arme a ajouter
     */
    public void ajouterArme(Arme arme) {
        this.armeEnMain = arme;
        setDegats(this.getDegats() + armeEnMain.getDegats());
    }

    /**
     * methode qui permet dajouter un bouclier a linventaire
     *
     * @param bouclier bouclier a ajouter
     */
    public void ajouterBouclier(Bouclier bouclier) {
        this.bouclierEnMain = bouclier;
        this.setPv(this.getPv() + bouclier.getResistance());
    }

    @Override
    public void diminuerVie(int vieDown) {
        super.diminuerVie(vieDown);
        if (bouclierEnMain != null) {
            bouclierEnMain.diminuerResistance(vieDown);
            if (bouclierEnMain.etreCasserBouclier()) {
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
    public void dessiner(Graphics2D crayon) {
        crayon.setColor(Color.blue);
        int pv = getPv();
        crayon.fillOval(getCase().x * DessinJeu.TAILLE_CASE, getCase().y * DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE, DessinJeu.TAILLE_CASE);
        crayon.setColor(Color.red);
        crayon.fillRect(DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 1) * DessinJeu.TAILLE_CASE, 20 * pv, 20);
        crayon.setColor(Color.black);
        crayon.setFont(new Font("Arial", Font.PLAIN, 20));
        crayon.drawString("" + pv + "/20", DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 3) * DessinJeu.TAILLE_CASE);
        crayon.drawRect(DessinJeu.TAILLE_CASE, (Labyrinthe.TAILLE + 1) * DessinJeu.TAILLE_CASE, 400, 20);
    }
}
