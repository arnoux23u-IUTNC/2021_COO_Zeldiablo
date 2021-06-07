package jeu;

import jeu.entites.*;
import jeu.cases.*;
import jeu.utils.*;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

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

    public static void main(String[] args) {
        Labyrinthe l = new Labyrinthe();
        System.out.println(l);
    }


    /**
     * Constructeur public par defaut
     */
    public Labyrinthe() {
        cases = new Case[TAILLE][TAILLE];
        //x = chemin
        //o = obstacle
        try {
            File fr = new File(".\\projet_zeldiablo\\jeu\\cartes");
            File[] maps = fr.listFiles();
            assert maps != null;
            FileReader map = new FileReader(maps[new Random().nextInt(maps.length)]);
            //On recupere une map au pif
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
                    case 'e':
                        c = new Porte(pos, line);
                        if (this.entree == null) {
                            this.entree = (Porte) c;
                        } else {
                            this.sortie = (Porte) c;
                        }
                        break;
                }

                cases[line][pos] = c;
                pos++;
                if(pos > 29){
                    map.read();
                    map.read();
                    pos = 0;
                    line++;
                }

            }
            map.close();
        } catch (FileNotFoundException e) {
            System.err.println("Impossible de lire le fichier !");
        } catch (IOException e) {
            String lab = "eooxxxooooooooooooooooooooooooxxxxoxxxooooooooxxxooooooooooooooooooxxoooooxxxoxxooooooooooooooooooxxoooxxooooxxxxxxoxxoooooooooooxxxxxoooooxoooooooxoooooooooooooooooooooxoooooxxxooooxooooooooooooooooxoooooxooooooxoooooooooooxxxxxxoooooxooooooxxxoooooooooxxxxxxxxxxxxooooooooxooooxxxxxxxxxxxooooooooooooooxooxxxooooxxxxxxooooooooooooooxxxxoooooooooxoooooooooooooooooooxoooooooooxoooooooooooooooooooxxxxooooooxxooooooooooooooooxxxooooooooooxxoooooooooooooooxoooooooooooooxoooooooooooooooxoooooooooooooxooooooooooooooooxxxxxxxxxooooxxoooooooooooooooxooooxxxxoooooxoooooooooooooooxooooooxooxxxxxoooooooooooooooxooooooxxxxooooooooooooooooxxxxoooooooooxooooooooooooooooxoooooooooooxxooooooooooooooooxoooooooooooxoooooooooooooooooxxxxoooooxxxxxxxxxxooooooooooooooxooooooooooooooxooooooooooooooxooooooooooooooxoooooooooooooooooooooooooooooxoooooooooooooooooooooooooooooxxxxxxxxx";
            int cursor = 0;
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    switch (lab.charAt(cursor)) {
                        case 'x':
                            Case c1 = new Chemin(i, j);
                            cases[i][j] = c1;
                            break;
                        case 'o':
                            Case m1 = new Mur(i, j);
                            cases[i][j] = m1;
                            break;
                        case 'e':
                            Porte p = new Porte(i, j);
                            cases[i][j] = p;
                            if (this.entree == null) {
                                this.entree = p;
                            } else {
                                this.sortie = p;
                            }
                            break;
                    }
                    cursor++;
                }
            }

        }
        this.joueur = new Joueur(this, entree);
    }

    /**
     * Constructeur public qui prends un parametre map
     *
     * @param lab carte du labyrinthe
     */
    public Labyrinthe(String lab) {
        cases = new Case[15][15];
        int cursor = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                switch (lab.charAt(cursor)) {
                    case 'x':
                        Case c1 = new Chemin(i, j);
                        cases[i][j] = c1;
                        break;
                    case 'o':
                        Case m1 = new Mur(i, j);
                        cases[i][j] = m1;
                        break;
                    case 'e':
                        Porte p = new Porte(i, j);
                        cases[i][j] = p;
                        if (this.entree == null) {
                            this.entree = p;
                        } else {
                            this.sortie = p;
                        }
                        break;
                }
                cursor++;
            }
        }
        this.joueur = new Joueur(this, entree);
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
        Case destination = null;
        try {
            destination = getDestination(p, dir);
        } catch (IndexOutOfBoundsException ignored) {
        }
        if (destination != null) {
            return destination.peutTraverser(p);
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
            p.setPosition(getDestination(p, d));
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
        switch (d) {
            case NORTH:
                destination = cases[actuel.x][actuel.y - 1];
                break;
            case SOUTH:
                destination = cases[actuel.x][actuel.y + 1];
                break;
            case EAST:
                destination = cases[actuel.x + 1][actuel.y];
                break;
            case WEST:
                destination = cases[actuel.x - 1][actuel.y];
                break;
        }
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

    public Case[][] getCases() {
        return cases;
    }
}
