package jeu.utils;

import jeu.*;
import moteurgraphique.*;

import java.util.Scanner;

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
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Bienvenue");
        // creation du jeu particulier et de son afficheur
        JeuPerso jeu = new JeuPerso();
        DessinPerso aff = new DessinPerso(jeu);

        // classe qui lance le moteur de jeu generique
        MoteurRendu moteur = new MoteurRendu(jeu, aff);
        // lance la boucle de jeu qui tourne jusque la fin du jeu
        moteur.lancerJeu(750, 750);

        // lorsque le jeu est fini
        System.out.println("Fin du Jeu - appuyer sur entree");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.exit(1);
        //TODO MAIN
    }
}
