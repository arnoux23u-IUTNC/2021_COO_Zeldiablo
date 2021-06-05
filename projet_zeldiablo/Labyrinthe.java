import java.util.*;

public class Labyrinthe {
    private Case[][] cases;
    private Joueur joueur;
    private Entree entree;

    public Labyrinthe() {
        this.joueur = new Joueur();

        //x = chemin
        //o = obstacle
        String lab =
                "xoooooooooooooo" +
                "xxoxxxooxxxxoxx" +
                "oxxxoxooxooxoxo" +
                "oooooxoxxoxxoxo" +
                "oxxoxxoxxoxooxx" +
                "oxooxooxoxxooox" +
                "oxoxxooxoxoooox" +
                "oxxxoxoxoxxxxox" +
                "oooxoxxxxoooxxx" +
                "xxoxxoooxoooooo" +
                "oxooxoxxxxxxxox" +
                "oxxoxxxoooooxox" +
                "ooxooooxxxxxxox" +
                "ooxooxxxooxooox" +
                "ooxxxxooooxxxex";

        for (int i = 0 ; i < lab.length(); i++){
            char c = lab.charAt(i);
            if (c == 'x'){
                Chemin c1 = new Chemin(i, i);
                cases[i][i]=c1;
            }
            if (c == 'o'){
                Mur m1 = new Mur(i, i);
                cases[i][i]=m1;
            }
            if (c == 'e'){
                entree = new Entree(i, i);
                joueur.getP().setPositionDepart(entree);
                cases[i][i]=entree;
            }
        }
    }

    public boolean peutBouger(Personnage p, Direction d){
        boolean res = false;
        switch (d) {
            case NORTH -> {
                Case nord = cases[p.getCase().x][p.getCase().y - 1];
                if (nord.x >= 0) {
                    if (nord instanceof Chemin) {
                        res = true;
                    }
                }
            }
            case SOUTH -> {
                Case sud = cases[p.getCase().x][p.getCase().y + 1];;
                if (sud.x <= 14) {
                    if (sud instanceof Chemin) {
                        res = true;
                    }
                }
            }
            case EAST -> {
                Case est = cases[p.getCase().x + 1][p.getCase().y];
                if (est.y <= 14) {
                    if (est instanceof Chemin) {
                        res = true;
                    }
                }
            }
            case WEST -> {
                Case ouest = cases[p.getCase().x - 1][p.getCase().y];
                if (ouest.y >= 0) {
                    if (ouest instanceof Chemin) {
                        res = true;
                    }
                }
            }
        }
        return res;
    }
}
