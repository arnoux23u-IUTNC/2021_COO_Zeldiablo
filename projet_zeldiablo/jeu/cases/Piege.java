package jeu.cases;

/**
 * Classe modelisant un Piege
 *
 * @author AGJMX
 */
public class Piege extends Obstacle {

    /**
     * Caractere permettant l'identification sur une map
     */
    private static final char IDENTIFIER = 'P';

    /**
     * Methode getIdentifier
     *
     * @return String, caractere d'identification
     */
    @Override
    public String getIdentifier() {
        return Character.toString(IDENTIFIER);
    }

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Piege(int x, int y) {
        super(x, y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
