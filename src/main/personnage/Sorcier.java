package main.personnage;

public class Sorcier extends Personnage {

    public Sorcier(CreatePerso cp) {
        super(100, 30, 150, 0.45, new Spell(30, (float) 0.70, "Boule de feu"), cp);
    }

    public Sorcier(int hp, int attack, int mana, Spell spell) {
        super(hp, attack, mana, 0.3,  spell,  new CreateMage());
    }

    @Override
    public String toString() {
        return "Mage{" +
                "hp=" + hp +
                ", attaque=" + attaque +
                ", mana=" + mana +
                ", spell=" + spell.getDescription() +
                ", hat=" + hat.getDescription() +
                ", chest=" + chest.getDescription() +
                ", legs=" + legs.getDescription() +
                '}';
    }
}
