package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

public class Troll extends Monstre{


    /**
     * booleen qui permet de determiner si le troll a ete tape dans le tour
     */
    private boolean tapeDansLeTour;

    private final int pv = 3;
    private final int degats = 3;



    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Troll(Labyrinthe l, Case depart) {
        super(l, depart,pv,depart);
        tapeDansLeTour=false;
    }

    /**
     * méthode qui permet de regenerer le troll s'il n'a pas ete tape
     */
    public void seRegenerer(){
        if(!tapeDansLeTour){
            this.setPv(this.getPv()+1);
        }

    }

    public void trollSeFaitAttaquer(){
        tapeDansLeTour = true;
    }
}
