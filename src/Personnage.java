public class Personnage {

    protected int hp;
    protected int attaque;
    protected int mana;
    protected Arme arme;

    public Personnage(int hp, int attaque, int mana) {
        this.hp = hp;
        this.attaque = attaque;
        this.mana = mana;
    }

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
}
