public abstract class Decorator extends Arme{

    protected Arme arme;
    protected int degats;

    public Decorator(Arme arme, int degats) {
        this.arme = arme;
        this.degats = degats;
    }

    @Override
    void attaque(Personnage personnage){
        personnage.setAttaque(personnage.getAttaque()+this.degats);
    }


}
