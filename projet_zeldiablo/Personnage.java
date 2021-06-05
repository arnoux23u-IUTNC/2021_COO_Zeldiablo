/**
 * Classe modelisant un personnage, de type passif (joueur) ou actif (monstre)
 */
public abstract class Personnage {

    /**
     * Position du joueur
     */
    private Case position;

    public Personnage(Case depart) {
        position = depart;
    }


    public Case getCase(){
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }
}
