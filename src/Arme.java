public class Arme {

    int degats;

    public Arme(int degats) {
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public void attaque(Personnage perso){
        perso.setAttaque(perso.getAttaque()+this.getDegats());
    }
}
