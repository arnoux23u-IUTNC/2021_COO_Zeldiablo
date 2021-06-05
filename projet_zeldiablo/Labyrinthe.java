import java.util.*;

public class Labyrinthe {
    private List<Case> cases;
    private Entree e;
    private Joueur joueur;

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
                "ooxxxxooooxxxxx";

        for (int i = 0 ; i < lab.length(); i++){
            char c = lab.charAt(i);
            if (c == "x"){
                Chemin c1 = new Chemin();
                cases.add(c1);
            }
            if (c == "o"){
                Mur m1 = new Mur();
                cases.add(m1);
            }
        }
    }

    public boolean creerEntree(int x, int y) {
        boolean res = false;
        //TODO

    }
    public boolean peutBouger(Personnage p, Direction d){
        switch (d) {
            case NORTH:
                Case nord = new Case((p.getCase().x - 1), p.getCase().y);
                if (nord.x >= 0) {
                    if (nord instanceof Chemin) {
                        res = true;
                    }
                }
                break;
            case SOUTH:
                Case sud = new Case((p.getCase().x + 1), p.getCase().y);
                if (sud.x <= 14){
                    if (sud instanceof Chemin) {
                        res = true;
                    }
                }
                break;
            case EAST:
                Case est = new Case((p.getCase().x),p.getCase().y+1);
                if (est.y <= 14) {
                    if (est instanceof Chemin) {
                        res = true;
                    }
                }
                break;
            case WEST:
                Case ouest = new Case((p.getCase().x),p.getCase().y-1);
                if (ouest.y >= 0) {
                    if (ouest instanceof Chemin) {
                        res = true;
                    }
                }
                break;
        }
        return res;
    }
}
