public abstract class Obstacle implements Case {
    private int x;
    private int y;

    public Obstacle(int abs, int ord) {
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