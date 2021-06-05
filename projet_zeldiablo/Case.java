/**
 * Interface modelisant une case dans le labyrinthe
 *
 * @author AGJMX
 */
public abstract class Case {

    /**
     * Attribut representant l'abscisse de la case
     */
    public final int x;

    /**
     * Attribut representant l'ordonnee de la case
     */
    public final int y;

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Case(int x, int y) {
        //TODO PEUT ETRE VERIFICATIONS
        this.x = x;
        this.y = y;
    }

    /**
     * Methode abstraite pour verifier si un personnage peut passer sur cette classe
     *
     * @return booleen, a vrai si "p" peut passer dessus
     */
    public abstract boolean peutTraverser(Personnage p);

}
