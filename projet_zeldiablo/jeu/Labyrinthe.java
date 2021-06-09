package jeu;

import jeu.entites.*;
import jeu.cases.*;
import jeu.utils.*;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Classe modelisant un labyrinthe
 *
 * @author AGJMX
 */
public class Labyrinthe {

    /**
     * Tableau de cases
     */
    private final Case[][] cases;

    /**
     * Joueur, personnage principal
     */
    private final Joueur joueur;

    /**
     * Porte sur laquelle le joueur apparait
     */
    private Porte entree;

    /**
     * Point de sortie pour le joueur
     */
    private Porte sortie;

    /**
     * Taille du labyrinthe
     */
    public static final int TAILLE = 30;

    /**
     * Seed default
     */
    private static final String lab = "exxooooooooooooooooooooooooooo" +
            "xxxoxxxxxxxxxxxoxpxxxoxxxxxxxx" +
            "oxxooootxoooooooxxooooxxoxxooo" +
            "oxxxxxxxxxxxxxxxxxxxxoxxoxxxxx" +
            "oxpoxxoxxooooxxoooooooxxoooooo" +
            "oxxoxxoxxxxxoxxoxxxxxotxxxxxxx" +
            "oxxofxoooooooooooooxxoooooooxx" +
            "oxxoxxoxxxxxxxxxxxxxxoxxxxxxxx" +
            "oxxoxxoxxoooooooxxoxxoooopxoxx" +
            "oxxoxxxxxoxxxxxxxxoxxoxxoxxoxx" +
            "oxxooooooooooxxoooooooxxooooxx" +
            "oxxopxxxxxxxxxxoxxxxxxxxxxfxxx" +
            "otxoxxooooooooooxxooooxxoxxooo" +
            "oxxoxxxxxxxxoxxoxxoxxoxxoxxxxx" +
            "oooooooxxoxxoxxoxxoxxooooxxooo" +
            "oxxoxxxxxoxxxxxxxxoxxpxxoxxoxx" +
            "oxxoxxoxxooooxxooooxxooooxxoxx" +
            "oxxxxxoxxxxxoxxoxxxxxtxxxxxxxx" +
            "oxxopxooooooooooooooooooooooxx" +
            "oxxoxxoxxxxxxxxoxxxxxxxxxxxoxx" +
            "oxxoooooooxxoxxoxxoxxooooxxopx" +
            "oxxxxxxxfxxxoxxoxxoxxxxxoxxxxx" +
            "oxxoooooooooooooxxooooxxoooooo" +
            "oxxoxxxxxxxxxxxoxxoxxxxxoxxxxx" +
            "oxxooooooooooxxoooooooxxoxxoxx" +
            "oxxoxxoxxxxxxxxxxxoxxxxxofxoxx" +
            "oxxotxoooopxoxxoooooooxxoxpooo" +
            "oxxoxxxxxxxxoxxoxxxxxxxxxxxoxx" +
            "oxpoxxoxxooooooooooxxooooxxoxx" +
            "oxxxxxoxxxxxxxxoxxxxxxxxoxxxxe";

    /**
     * Liste de monstre
     */
    private final ArrayList<Monstre> lMonstre;

    /**
     * Liste de pieges
     */
    private final ArrayList<Piege> lPieges;

    /**
     * Constructeur public par defaut
     * Supression des warns de read
     *
     * @param autoGenerate, booleen sur vrai pour une map auto
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public Labyrinthe(boolean autoGenerate) throws IOException{
        lMonstre = new ArrayList<Monstre>();
        lPieges = new ArrayList<Piege>();
        cases = new Case[TAILLE][TAILLE];
        if (autoGenerate) {
            try {
                File fr = new File(".\\projet_zeldiablo\\jeu\\cartes");
                File[] maps = fr.listFiles();
                assert maps != null;
                //On recupere une map au pif
                FileReader map = new FileReader(maps[new Random().nextInt(maps.length)]);
                int line = 0, pos = 0;
                Case c = null;
                while (line < 30) {
                    char item = (char) map.read();
                    switch (item) {
                        case 'x':
                            c = new Chemin(pos, line);
                            break;
                        case 'o':
                            c = new Mur(pos, line);
                            break;
                        case 'p':
                            c = new Piege(pos, line);
                            break;
                        case 'e':
                            c = new Porte(pos, line);
                            if (this.entree == null) {
                                this.entree = (Porte) c;
                            } else {
                                this.sortie = (Porte) c;
                            }
                            break;
                        case 't':
                            c = new Chemin(pos, line);
                            Monstre m2 = new Troll(this, c);
                            lMonstre.add(m2);
                            c.setPersonnage(m2);
                            break;
                        case 'f':
                            c = new Chemin(pos, line);
                            Monstre m3 = new Fantome(this, c);
                            lMonstre.add(m3);
                            c.setPersonnage(m3);
                            break;
                    }
                    cases[line][pos] = c;
                    pos++;
                    if (pos > 29) {
                        map.read();
                        map.read();
                        pos = 0;
                        line++;
                    }

                }
                map.close();
            } catch (Exception e) {
                System.err.println("Impossible de lire le fichier !");
                int cursor = 0;
                for (int i = 0; i < TAILLE; i++) {
                    for (int j = 0; j < TAILLE; j++) {
                        switch (lab.charAt(cursor)) {
                            case 'x':
                                Case c1 = new Chemin(i, j);
                                cases[i][j] = c1;
                                break;
                            case 'o':
                                Case m1 = new Mur(i, j);
                                cases[i][j] = m1;
                                break;
                            case 'p':
                                Piege pi = new Piege(i, j);
                                lPieges.add(pi);
                                cases[i][j] = pi;
                                break;
                            case 'e':
                                Porte po = new Porte(i, j);
                                cases[i][j] = po;
                                if (this.entree == null) {
                                    this.entree = po;
                                } else {
                                    this.sortie = po;
                                }
                                break;
                            case 't':
                                Case c2 = new Chemin(i, j);
                                Monstre m2 = new Troll(this, c2);
                                lMonstre.add(m2);
                                cases[i][j] = c2;
                                c2.setPersonnage(m2);
                                break;
                            case 'f':
                                Case c3 = new Chemin(i, j);
                                Monstre m3 = new Fantome(this, c3);
                                lMonstre.add(m3);
                                cases[i][j] = c3;
                                c3.setPersonnage(m3);
                                break;
                        }
                        cursor++;
                    }
                }
            }
        } else {
            int cursor = 0;
            for (int i = 0; i < TAILLE; i++) {
                for (int j = 0; j < TAILLE; j++) {
                    Case caseCursor = null;
                    switch (lab.charAt(cursor)) {
                        case 'x':
                            caseCursor = new Chemin(i, j);
                            break;
                        case 'o':
                            caseCursor = new Mur(i, j);
                            break;
                        case 'p':
                            caseCursor = new Piege(i, j);
                            lPieges.add((Piege) caseCursor);
                            break;
                        case 'e':
                            caseCursor = new Porte(i, j);
                            if (this.entree == null) {
                                this.entree = (Porte) caseCursor;
                            } else {
                                this.sortie = (Porte) caseCursor;
                            }
                            break;
                        case 't':
                            caseCursor = new Chemin(i, j);
                            Monstre m = new Troll(this, caseCursor);
                            lMonstre.add(m);
                            caseCursor.setPersonnage(m);
                            break;
                        case 'f':
                            caseCursor = new Chemin(i, j);
                            Monstre m2 = new Fantome(this, caseCursor);
                            lMonstre.add(m2);
                            caseCursor.setPersonnage(m2);
                            break;
                    }
                    cases[i][j] = caseCursor;
                    cursor++;
                }
            }
        }
        this.joueur = new Joueur(this, entree);
        entree.setPersonnage(this.joueur);
    }

    /**
     * Methode de test pour savoir si un Personnage peut bouger
     * On checrche la case sur laquelle il veut aller puis on verifie si le personnage peut aller dessus
     *
     * @param p   personnage a tester
     * @param dir direction souhaitee
     * @return booleen, a vrai s'il peut bouger
     */
    private boolean peutBouger(Personnage p, Direction dir) {
        Case destination;
        try {
            destination = getDestination(p, dir);
        } catch (IndexOutOfBoundsException e) {
            destination = null;
        }
        if ((destination != null) && (getDestination(p, dir).getPersonnage() == null)) {
            switch (destination.getIdentifier()) {
                case "P":
                    return p.peutTraverserPiege();
                case "O":
                    return p.peutTraverserMur();
                case "X":
                    return p.peutTraverserChemin();
                case "E":
                    Porte pa = (Porte) destination;
                    return p.peutTraverserPorte() && !pa.isFerme();
            }
        }
        return false;
    }

    /**
     * Methode pour deplacer un Personnage
     * Appelle d'abord peutBouger
     *
     * @param p Personnage a deplacer
     * @param d Direction voulue
     * @return booleen, a vrai si le personnage a bouge
     */
    public boolean deplacerJoueur(Personnage p, Direction d) {
        if (peutBouger(p, d)) {
            Case destination = getDestination(p, d);
            destination.setPersonnage(p);
            p.getCase().setPersonnage(null);
            p.setPosition(destination);
            if ("P".equals(p.getCase().getIdentifier())) {
                System.out.println("le joueur prend un dégat");
                p.diminuerVie(1);
            }
            return true;
        }
        return false;
    }

    /**
     * Methode getDestination, utilisee pour trouver la case avec une direction
     *
     * @param p personnage
     * @param d direction voulue
     * @return Case correspondant a la destination
     */
    private Case getDestination(Personnage p, Direction d) {
        Case actuel = p.getCase();
        Case destination = null;
        System.out.println("se trouve en " + actuel.x + " , " + actuel.y);
        System.out.println(d);
        switch (d) {
            case NORTH:
                destination = cases[actuel.y - 1][actuel.x];
                break;
            case SOUTH:
                destination = cases[actuel.y + 1][actuel.x];
                break;
            case EAST:
                destination = cases[actuel.y][actuel.x + 1];
                break;
            case WEST:
                destination = cases[actuel.y][actuel.x - 1];
                break;
        }
        destination = getCase(destination.x, destination.y);
        System.out.println("veut aller en " + destination.x + " , " + destination.y);
        return destination;
    }

    /**
     * Getter joueur
     *
     * @return joueur principal
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Methode toString
     *
     * @return String, affichage
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Case[] caseL : cases) {
            for (Case tile : caseL) {
                s.append(tile.getIdentifier());
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Getter entree
     *
     * @return entree du labyrinthe
     */
    public Porte getEntree() {
        return entree;
    }

    /**
     * Getter de case
     * Attention, inversion des axes
     * Ex : getCase(2,1) retourne cases[1][2]
     *
     * @return char, identifier de case
     */
    public Case getCase(int x, int y) {
        return cases[y][x];
    }

    /**
     * Getter sortie
     *
     * @return sortie du lab
     */
    public Porte getSortie() {
        return this.sortie;
    }

    /**
     * Getter de cases
     *
     * @return cases du labyrinthe
     */
    public Case[][] getCases() {
        return cases;
    }

    /**
     * Getter des monstres
     *
     * @return arraylist de monstre
     */
    public ArrayList<Monstre> getlMonstre() {
        return lMonstre;
    }

    /**
     * Methode dessiner
     *
     * @param crayon graphics
     */
    public void dessiner(Graphics2D crayon) {
        for (Case[] c1 : cases) {
            for (Case c : c1) {
                c.dessiner(crayon);
            }
        }
        for (Monstre m : lMonstre) {
            m.dessiner(crayon);
        }
    }

    public void supprimerLesMorts() {
        //On recupere tous les monstres morts
        ArrayList<Monstre> monstresMort = (ArrayList<Monstre>) getlMonstre().stream().filter(Personnage::etreMort).collect(Collectors.toList());
        for (Monstre m : monstresMort) {
            m.getCase().setPersonnage(null);
            lMonstre.remove(m);
        }
    }
}