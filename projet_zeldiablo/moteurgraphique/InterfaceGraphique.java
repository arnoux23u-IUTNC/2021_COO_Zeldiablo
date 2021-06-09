package moteurgraphique;

import javax.swing.*;
import java.io.IOException;

/**
 * Classe de modelisation du GUI
 */
public class InterfaceGraphique {

    /**
     * le Panel lie a la JFrame
     */
    private final PanelDessin panel;

    /**
     * le controleur lie a la JFrame
     */
    private final Controleur controleur;

    /**
     * la construction de l'interface grpahique - construit la JFrame -
     * construit les Attributs
     *
     * @param afficheurUtil l'afficheur a utiliser dans le moteur
     */
    public InterfaceGraphique(DessinJeu afficheurUtil, int x, int y) {
        // creation JFrame
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creation panel
        this.panel = new PanelDessin(x, y, afficheurUtil);
        f.setContentPane(this.panel);

        // ajout du controleur
        Controleur controlleurGraph = new Controleur();
        this.controleur = controlleurGraph;
        this.panel.addKeyListener(controlleurGraph);

        // recuperation du focus
        f.pack();
        f.getContentPane().setFocusable(true);
        f.getContentPane().requestFocus();

        f.setVisible(true);

    }

    /**
     * retourne le controleur de l'affichage construit
     *
     * @return Controlleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * demande la mise a jour du dessin
     */
    public void dessiner() {
        this.panel.dessinerJeu();
    }
}
