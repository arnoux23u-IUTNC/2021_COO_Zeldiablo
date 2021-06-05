/**
 * Classe modelisant un Mur
 *
 * @author AGJMX
 */
public class Mur extends Obstacle {

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Mur(int x, int y) {
        super(x, y);
    }

    /**
     * Methode pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si "p" peut passer dessus
     */
    @Override
    public boolean peutTraverser(Personnage p) {
        return false;
    }
}