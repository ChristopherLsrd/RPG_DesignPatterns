package main.personnage;

public class Guerrier extends Personnage{

    public Guerrier(CreatePerso cp) {
        super(200, 50, 40, new Spell(20, (float) 0.65, "Lance une hache"), cp);
    }

    public Guerrier(int hp, int attack, int mana, Spell spell) {
        super(hp, attack, mana, spell, new CreateWarrior());
    }

    @Override
    public String toString() {
        return "Guerrier{" +
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
