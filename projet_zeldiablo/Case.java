/**
 * Interface modelisant une case, qui peut etre traversable ou non
 *
 * @author AGJMX
 */
public abstract class Case {

    /**
     * Attribut representant l'abscisse de la case
     */
    public int x;

    /**
     * Attribut representant l'ordonnee de la case
     */
    public int y;

    /**
     * Constructeur public par defaut a deux parametres
     */
    public Case(int x, int y){
        //TODO PEUT ETRE VERIFICATIONS
        this.x = x;
        this.y = y;
    };

}
