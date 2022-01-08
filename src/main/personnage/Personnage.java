package main.personnage;

import main.personnage.CreatePerso;
import main.personnage.chest.Chest;
import main.personnage.hat.Hat;
import main.personnage.legs.Legs;
import main.state.Etat;
import main.state.EtatAgonie;
import main.state.EtatMort;
import main.state.EtatVivant;

public abstract class Personnage {

    protected int hp;
    protected int attaque;
    protected int mana;
    protected Spell spell;
    protected CreatePerso cp;
    protected Hat hat;
    protected Chest chest;
    protected Legs legs;
    protected Etat etat;
    protected Etat etatMort;
    protected Etat etatVivant;
    protected Etat etatAgonie;

    public Personnage(int hp, int attaque, int mana, Spell spell, CreatePerso cp) {
        this.hp = hp;
        this.attaque = attaque;
        this.mana = mana;
        this.spell = spell;
        this.cp = cp;

        this.etat = new EtatVivant(this);
        this.etatAgonie = new EtatAgonie(this);
        this.etatVivant = new EtatVivant(this);
        this.etatMort = new EtatMort(this);
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

    public Spell getSpell() {
        return spell;
    }

    public void equipStuff() {
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

    public void estAttaque() {
        etat.estAttaque();
    }

    public void attack() {
        etat.attack();
    }

    public void spell() {
        etat.spell();
    }

    public void regenMana() {
        etat.regenMana();
    }

    public void heal() {
        etat.heal();
    }

    public void esquive() {
        etat.esquive();
    }

    public void changerEtatMort() {
        etat = etatMort;
    }

    public void changerEtatAgonie() {
        etat = etatAgonie;
    }

    public void changerEtatVivant() {
        etat = etatVivant;
    }

    public Etat getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "hp=" + hp +
                ", attaque=" + attaque +
                ", mana=" + mana +
                ", spell=" + spell.getDescription() +
                ", hat=" + hat.getDescription() +
                ", chest=" + chest.getDescription() +
                ", legs=" + legs.getDescription() +
                ", etat=" + etat +
                '}';
    }
}
