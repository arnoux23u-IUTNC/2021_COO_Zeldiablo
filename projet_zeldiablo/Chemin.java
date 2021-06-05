public class Chemin implements Case {
    private int x;
    private int y;

    public Chemin(int abs, int ord) {
        if (abs < 0) {
            abs -= abs;
        }
        if (ord < 0) {
            ord -= ord;
        }
        this.x = abs;
        this.y = ord;
    }
}
