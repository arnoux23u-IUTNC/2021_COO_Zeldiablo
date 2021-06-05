public class Chemin implements Case {
    private int x;
    private int y;

    public Chemin(int abs, int ord) {
        if (abs < 0) {
            abs = (-1) * abs;
        }
        if (ord < 0) {
            ord = (-1) * ord;
        }
        this.x = abs;
        this.y = ord;
    }
}
