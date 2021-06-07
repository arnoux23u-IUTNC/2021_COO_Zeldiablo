package moteurgraphique;

import jeu.*;
import jeu.cases.Case;
import jeu.entites.*;

import java.awt.*;
import java.awt.image.*;

public class DessinPerso implements DessinJeu {

    /**
     * constante pour gerer la taille des cases
     */
    private final static int TAILLE_CASE = 25;

    /**
     * lien vers le jeu a afficher
     */
    private final JeuPerso jeuEnCours;

    /**
     * appelle constructeur parent
     *
     * @param j le jeutest a afficher
     */
    public DessinPerso(JeuPerso j) {
        this.jeuEnCours = j;
    }

    /**
     * dessiner un objet consiste a dessiner sur l'image suivante methode
     * redefinie de Afficheur
     */
    private void dessinerObjet(String s, int x, int y, BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        switch (s) {
            case "Joueur":
                crayon.setColor(Color.blue);
                crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
                        TAILLE_CASE);
                break;
            case "Mur":
                crayon.setColor(Color.gray);
                crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
                        TAILLE_CASE);
                break;
            case "Porte":
                crayon.setColor(Color.green);
                crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
                        TAILLE_CASE);
                break;
            case "Chemin":
                crayon.setColor(Color.orange);
                crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
                        TAILLE_CASE);
                break;
            default:
                throw new AssertionError("objet inexistant");
        }
    }

    /**
     * methode dessiner redefinie de Afficheur retourne une image du jeu
     */
    @Override
    public void dessiner(BufferedImage im) {
        Joueur j = jeuEnCours.getJoueur();

        for(Case[] c1 : jeuEnCours.getLabyrinthe().getCases()){
            for(Case c : c1){
                this.dessinerObjet(c.getClass().getSimpleName(),c.x,c.y,im);
            }
        }
        this.dessinerObjet("Joueur", j.getCase().x, j.getCase().y, im);
    }

}
