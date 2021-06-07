package jeu.entites;

import jeu.Labyrinthe;
import jeu.cases.Case;

public class Troll extends Monstre{


    /**
     * booleen qui permet de determiner si le troll a ete tape dans le tour
     */
    public boolean pastapeDansLeTour;
    /**
     * Constructeur public par defaut a deux parametres
     *
     * @param l      labyrinthe
     * @param depart position de depart
     */
    public Troll(Labyrinthe l, Case depart) {
        super(l, depart,3,3);
        pastapeDansLeTour=true;
    }

    /**
     * méthode qui permet de regenerer le troll s'il n'a pas ete tape
     */
    public void seRegenerer(){
        if(pastapeDansLeTour){
            this.setPv(this.getPv()+1);
        }

    }
    public void etreAttaqueDansLeTour(){
        pastapeDansLeTour = false;
    }
}
