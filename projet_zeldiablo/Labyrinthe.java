import java.util.*;

public class Labyrinthe {
    private Case[][] cases;
    private Joueur joueur;
    private Entree entree;

    public Labyrinthe() {

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

        for (int i = 0 ; i < 15; i++){
            for(int j = 0; j < 15; j++){
                int cursor = 0;
                char c = lab.charAt(cursor);
                if (c == 'x'){
                    Chemin c1 = new Chemin(i, j);
                    cases[i][j]=c1;
                }
                if (c == 'o'){
                    Mur m1 = new Mur(i, j);
                    cases[i][j]=m1;
                }
                if (c == 'e'){
                    entree = new Entree(i, j);
                    cases[i][j]=entree;
                }
                cursor++;
            }

        }
        this.joueur = new Joueur(entree);
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
