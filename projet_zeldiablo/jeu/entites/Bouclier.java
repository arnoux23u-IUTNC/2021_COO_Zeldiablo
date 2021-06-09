package jeu.entites;

/**
 * Classe modelisant un bouclier
 *
 * @author AGJMX
 */
public class Bouclier {

    /**
     * attribut eniter correspondant a la resistance du bouclier
     */
    private int resistance;

    /**
     * constructeur de bouclier
     *
     * @param resi resistance du bouclier
     */
    public Bouclier(int resi) {
        this.resistance = resi;
    }

    /**
     * getter de la resistance
     *
     * @return la resistance du bouclier
     */
    public int getResistance() {
        return resistance;
    }

    /**
     * methode qui permets de diminuer la resistance du boucleir
     *
     * @param degats degats pris dans le bouclier
     */
    public int diminuerResistance(int degats) {
        int degatsjoueur = 0;
        if (degats > 0) {
            if(resistance-degats>0){
                resistance -= degats;
            }else{
                degatsjoueur=degats-resistance;
            }
        }
        return degatsjoueur;
    }

    /**
     * methode qui permets de savoir si le bouclier est casse ou non
     *
     * @return true si resistance est superieur a zero
     */
    public boolean etreCasserBouclier() {
        return resistance <= 0;
    }


    //TODO DESSIN
}
