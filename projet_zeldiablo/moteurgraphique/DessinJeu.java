package moteurgraphique;

import java.awt.image.BufferedImage;

/**
 * une interface representant la maniere de dessiner sur un JPanel
 *
 * @author vthomas
 */
public interface DessinJeu {

    /**
     * constante pour gerer la taille des cases
     */
    int TAILLE_CASE = 25;

    /**
     * methode dessiner a completer. Elle construit une image correspondant au
     * jeu. Jeu est un attribut de l'afficheur
     *
     * @param image image sur laquelle dessiner
     */
    void dessiner(BufferedImage image);
}
