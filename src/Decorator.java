public abstract class Decorator extends Arme{

    protected Arme arme;
    protected int degats;

    public Decorator(Arme arme, int degats) {
        this.arme = arme;
        this.degats = degats;
    }

    @Override
    void attaquer(){
        arme.attaquer();
    }


}
