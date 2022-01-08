import personnage.CreatePerso;
import personnage.chest.Chest;
import personnage.hat.Hat;
import personnage.legs.Legs;

public abstract class Personnage {

    protected int hp;
    protected int attaque;
    protected int mana;
    protected Arme arme;
    protected CreatePerso cp;
    protected Hat hat;
    protected Chest chest;
    protected Legs legs;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void equipStuff(){
        this.hat = getHat();
        this.chest = getChest();
        this.legs = getLegs();
    }

    public Hat getHat() {
        return cp.addHat();
    }

    public Chest getChest() {
        return cp.addChest();
    }

    public Legs getLegs() {
        return cp.addLegs();
    }


    //public abstract void attaquer(Monstre monstre);

    //public abstract void attaqueParMonstre(int degats);

    //public abstract void lancerSort(Monstre monstre);

    //public abstract void recupererMana();

    //public abstract void seSoigner();

    //public abstract void changerArme();

    //public abstract void nouveauTour(Monstre monstre);

    public abstract void displayCloth();

    //public abstract void changerEtatMort();

    //public abstract void changerEtatAgonie();

    //public abstract Etat getEtat();
}
