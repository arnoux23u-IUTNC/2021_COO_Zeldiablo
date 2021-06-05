import javax.swing.text.Position;

public class Personnage {
    private Case position;

    public Personnage() {
    }

    public boolean seDeplacer(Direction d){
        boolean res = true;
        //je sais pas trop quoi faire
        return res;
    }

    public Case getCase(){
        return position;
    }

    public void setPositionDepart(Case position) {
        this.position = position;
    }
}
