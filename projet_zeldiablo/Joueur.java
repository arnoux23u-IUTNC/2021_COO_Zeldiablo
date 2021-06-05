/**
 * Classe modelisant un Joueur
 *
 * @author AGJMX
 */
public class Joueur extends Personnage {

    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l Labyrinthe sur lequel il joue
     * @param e Point d'apparition
     */
    public Joueur(Labyrinthe l, Porte e) {
        super(l, e);
        e.setFerme(true);
    }


}
