/**
 * Classe modelisant un personnage, de type joueur
 */
public class Personnage {

    /**
     * Position du joueur
     */
    private Case position;

    public Personnage(Entree entry) {
        position = entry;
    }


    public Case getCase(){
        return position;
    }

    public void setPositionDepart(Case position) {
        this.position = position;
    }
}
