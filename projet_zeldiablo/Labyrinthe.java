/**
 * Classe modelisant un labyrinthe
 *
 * @author AGJMX
 */
public class Labyrinthe {

    /**
     * Tableau de cases
     */
    private final Case[][] cases;

    /**
     * Joueur, personnage principal
     */
    private final Joueur joueur;

    /**
     * Porte sur laquelle le joueur apparait
     */
    private Porte entree;

    /**
     * Point de sortie pour le joueur
     */
    private Porte sortie;

    /**
     * Constructeur public par defaut
     */
    public Labyrinthe() {
        cases = new Case[15][15];
        //x = chemin
        //o = obstacle
        String lab =
                "xoooooooooooooo" +
                        "xxoxxxooxxxeoxx" +
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
        int cursor = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                switch (lab.charAt(cursor)) {
                    case 'x':
                        Case c1 = new Chemin(i, j);
                        cases[i][j] = c1;
                        break;
                    case 'o':
                        Case m1 = new Mur(i, j);
                        cases[i][j] = m1;
                        break;
                    case 'e':
                        Porte p = new Porte(i, j);
                        cases[i][j] = p;
                        if (this.entree == null) {
                            this.entree = p;
                        } else {
                            sortie = p;
                        }
                        break;
                }
                cursor++;
            }
        }
        this.joueur = new Joueur(this, entree);
    }

    /**
     * Methode de test pour savoir si un Personnage peut bouger
     * On checrche la case sur laquelle il veut aller puis on verifie si le personnage peut aller dessus
     *
     * @param p   personnage a tester
     * @param dir direction souhaitee
     * @return booleen, a vrai s'il peut bouger
     */
    private boolean peutBouger(Personnage p, Direction dir) {
        Case destination = null;
        try {
            destination = getDestination(p, dir);
        } catch (IndexOutOfBoundsException ignored) {
        }
        if (destination != null) {
            return destination.peutTraverser(p);
        }
        return false;
    }

    public void jouer() {
        //TODO METHODE PRINCIPALE
    }

    /**
     * Methode pour deplacer un Personnage
     * Appelle d'abord peutBouger
     *
     * @param p Personnage a deplacer
     * @param d Direction voulue
     * @return booleen, a vrai si le personnage a bouge
     */
    public boolean deplacerJoueur(Personnage p, Direction d) {
        if (peutBouger(p, d)) {
            p.setPosition(getDestination(p, d));
            return true;
        }
        return false;
    }

    /**
     * Methode getDestination, utilisee pour trouver la case avec une direction
     *
     * @param p personnage
     * @param d direction voulue
     * @return Case correspondant a la destination
     */
    private Case getDestination(Personnage p, Direction d) {
        Case actuel = p.getCase();
        Case destination = null;
        switch (d) {
            case NORTH:
                destination = cases[actuel.x][actuel.y - 1];
                break;
            case SOUTH:
                destination = cases[actuel.x][actuel.y + 1];
                break;
            case EAST:
                destination = cases[actuel.x + 1][actuel.y];
                break;
            case WEST:
                destination = cases[actuel.x - 1][actuel.y];
                break;
        }
        return destination;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
