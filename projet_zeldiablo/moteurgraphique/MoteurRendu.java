package moteurgraphique;

import jeu.*;

/**
 * Classe moteur de rendu
 *
 * @author vthomas
 * @author AGJMX
 */
public class MoteurRendu {

    /**
     * le jeu a executer
     */
    private final Jeu jeu;

    /**
     * l'interface graphique
     */
    private InterfaceGraphique gui;

    /**
     * l'afficheur a utiliser pour le rendu
     */
    private final DessinJeu dessin;

    /**
     * construit un moteur
     *
     * @param pJeu     jeu a lancer
     * @param pAffiche afficheur a utiliser
     */
    public MoteurRendu(Jeu pJeu, DessinJeu pAffiche) {
        // creation du jeu
        this.jeu = pJeu;
        this.dessin = pAffiche;
    }

    /**
     * permet de lancer le jeu
     */
    public void lancerJeu(int width, int height) throws InterruptedException {

        // creation de l'interface graphique
        this.gui = new InterfaceGraphique(this.dessin, width, height);
        Controleur controle = this.gui.getControleur();

        // boucle de jeu
        while (!this.jeu.etreFini()) {
            // fait evoluer le jeu
            this.jeu.evoluer(controle.getDirection(),controle.getAttaque());
            // affiche le jeu
            this.gui.dessiner();
            // met en attente
            Thread.sleep(100);
        }
    }

}
