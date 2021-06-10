package moteurgraphique;

import jeu.*;

import javax.swing.*;

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
        //creation gui
        InterfaceGraphique gui = new InterfaceGraphique(this.dessin, width, height);
        Controleur controle = gui.getControleur();

        int iterate = 0;

        // boucle de jeu
        while (!this.jeu.etreFini()) {
            // fait evoluer le jeu
            this.jeu.evoluer(controle.getDirection(), controle.getAttaque());
            //on bouge les monstres a 10
            if(iterate == 10){
                iterate = 0;
                this.jeu.evoluerMonstres();
            }
            // affiche le jeu
            gui.dessiner();
            // met en attente
            //noinspection BusyWait
            Thread.sleep(100);
            //on deplace
            iterate++;
        }
        JOptionPane.showMessageDialog(new JPanel(), "Fin du jeu !", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
        System.exit(1);
    }

}
