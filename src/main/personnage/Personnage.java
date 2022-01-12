package main.personnage;

import main.observer.Observer;
import main.observer.PersonnageSujet;
import main.personnage.CreatePerso;
import main.personnage.chest.Chest;
import main.personnage.hat.Hat;
import main.personnage.legs.Legs;
import main.state.Etat;
import main.state.EtatAgonie;
import main.state.EtatMort;
import main.state.EtatVivant;

import java.util.ArrayList;
import java.util.List;

public abstract class Personnage implements PersonnageSujet {

    protected int hp;
    protected int attaque;
    protected double mana;
    protected int hpIni;
    protected double probaAttack;
    protected Spell spell;
    protected CreatePerso cp;
    protected Hat hat;
    protected Chest chest;
    protected Legs legs;
    protected Etat etat;
    protected Etat etatMort;
    protected Etat etatVivant;
    protected Etat etatAgonie;
    private List<Observer> observers;

    public Personnage(int hp, int attaque, double mana, double probaAttack, Spell spell, CreatePerso cp) {
        this.hp = hp;
        this.hpIni = this.hp;
        this.attaque = attaque;
        this.mana = mana;
        this.spell = spell;
        this.cp = cp;
        this.probaAttack = probaAttack;

        this.etat = new EtatVivant(this);
        this.etatAgonie = new EtatAgonie(this);
        this.etatVivant = new EtatVivant(this);
        this.etatMort = new EtatMort(this);

        this.observers = new ArrayList<>();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        notifierObserver();
    }

    public int getHpIni() {
        return this.hpIni;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
        notifierObserver();
    }

    public Spell getSpell() {
        return spell;
    }

    public double getProbaAttack() {
        return probaAttack;
    }

    public void setProbaAttack(double probaAttack) {
        this.probaAttack = probaAttack;
    }

    public boolean isDead() {
        return hp <= 0;
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

    public void attack(Personnage perso) {
        etat.attack(perso);
    }

    public void spell(Personnage perso) {
        etat.spell(perso);
    }

    public void regenMana() {
        etat.regenMana();
    }

    public void heal() {
        etat.heal();
    }

    public void changerEtatMort() {
        etat = etatMort;
        notifierObserver();
    }

    public void changerEtatAgonie() {
        etat = etatAgonie;
        notifierObserver();
    }

    public void changerEtatVivant() {
        etat = etatVivant;
        notifierObserver();
    }

    public Etat getEtat() {
        return etat;
    }

    public void enregistrerObserver(Observer obs) {
        observers.add(obs);
    }

    public void supprimerObserver(Observer obs) {
        observers.remove(obs);
    }

    public void notifierObserver() {
        observers.forEach(obs -> obs.update(this));
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
