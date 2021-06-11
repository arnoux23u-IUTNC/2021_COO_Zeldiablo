package jeu.utils;

import jeu.*;
import moteurgraphique.*;

import java.io.*;
import java.util.*;

/**
 * Classe Main
 *
 * @author AGJMX
 */
public class MainPerso {

    /**
     * Methode main, cree un Jeu
     *
     * @param args arguments
     * @throws InterruptedException exception when thread.sleep()
     * @throws IOException          File exception (images)
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Bienvenue");
        // creation du jeu particulier et de son afficheur
        JeuPerso jeu = new JeuPerso();
        DessinPerso aff = new DessinPerso(jeu);

        // classe qui lance le moteur de jeu generique
        MoteurRendu moteur = new MoteurRendu(jeu, aff);
        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(750, 900);
    }
}
