package jeu.entites;

public class Bouclier {

    /**
     * attribut eniter correspondant a la resistance
     */
    private int resistance;

    /**
     * constructeur de bouclier
     * @param resi resistance du bouclier
     */
    public Bouclier(int resi){
        this.resistance = resi;
    }

    /**
     * getter de la resistance
     * @return la resistance du bouclier
     */
    public int getResistance() {
        return resistance;
    }

    /**
     * methode qui permets de diminuer la resistance du boucleir
     * @param  degats degats pris dans le bouclier
     * @return les degats restants pris
     */
    public void diminuerResistance(int degats){
        if(degats>0){
            resistance-= degats;
        }
    }

    /**
     * methode qui permets de savoir si le bouclier est casse ou non
     * @return true si resistance est superieur a zero
     */
    public boolean etreCasserBouclier(){
        if(resistance>0){
            return false;
        }else{
            return true;
        }
    }
}
