/**
 * Classe modelisant un Objet Jeu
 * Celui ci est l'element mere
 *
 * @author AGJMX
 */
public class Jeu {

    /**
     * Labyrinthe concernce par le jeu
     */
    private Labyrinthe l;

    /**
     * Constructeur public par defaut
     */
    public Jeu() {
        this.l = new Labyrinthe();
        this.l.jouer();
    }

}
