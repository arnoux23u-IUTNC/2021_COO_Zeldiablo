import java.util.*;

public class Labyrinthe {
    private List<Case> cases;
    private Entree e;

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
                "ooxxxxooooxxxxx";

        for (int i = 0 ; i < lab.length(); i++){
            String c = lab.charAt(i);
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
        if ()
    }
}
