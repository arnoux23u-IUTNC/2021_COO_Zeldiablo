package jeu.entites;

public class Arme {

    /**
     * attribut entier correspondant au degats de l'arme
     */
    private int degats;

    /**
     * Constructeur d Arme qui construit une arme en fonction du parametre
     * @param d degats de l'arme
     */
    public Arme(int d){
        this.degats = d;
    }

    /**
     * Getter des degats de l'arme
     * @return degats de l'arme
     */
    public int getDegats(){
        return this.degats;
    }
}
