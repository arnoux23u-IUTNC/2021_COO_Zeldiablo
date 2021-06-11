package jeu;

import jeu.entites.*;
import jeu.utils.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe modelisant le jeu d'un personnage
 * Implemente Jeu
 *
 * @author AGJMX
 */
public class JeuPerso implements Jeu {

    /**
     * Joueur concerne
     */
    private final Joueur pj;

    /**
     * Repertoire des assets
     */
    public static final String assetsDirectory = "projet_zeldiablo\\jeu\\utils\\assets\\";

    /**
     * Constructeur public par defaut
     *
     * @throws IOException textures
     */
    public JeuPerso() throws IOException {
        Labyrinthe l = new Labyrinthe(true);
        this.pj = new Joueur(l, l.getEntree());
    }

    /**
     * Methode d'evolution
     *
     * @param d direction de l'utilisateur
     */
    @Override
    public void evoluer(Direction d, boolean b) {
        this.pj.seDeplacer(d);
        if (b) {
            this.pj.attaquerAutour();
        }
        for(Monstre m : pj.getLabyrinthe().getlMonstre()){
            if(m.isTroll()){
                Troll t = (Troll)m;
                t.seRegenerer();
            }
        }
    }

    @Override
    public void evoluerMonstres() {
        Labyrinthe l = pj.getLabyrinthe();
        for (Monstre m : l.getlMonstre()) {
            m.seDeplacerVersJoueur();
            m.attaquerLeJoueur();
        }
    }

    /**
     * Methode de test fini
     *
     * @return booleen, a vrai si fini
     */
    @Override
    public boolean etreFini() {
        if (!pj.etreMort() && !pj.getCase().equals(pj.getLabyrinthe().getSortie())) {
            return false;
        }
        System.out.println("Vous êtes mort ou vous avez gagné, à vous de voir !");
        return true;
    }

    /**
     * Methode dessiner
     *
     * @param crayon graphics
     */
    public void dessiner(Graphics2D crayon) {
        pj.dessiner(crayon);
    }
}