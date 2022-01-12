package main.observer;

import main.personnage.Personnage;

public class DisplayMana implements Observer{
    private Personnage personnage;

    public DisplayMana(Personnage personnage) {
        this.personnage = personnage;
        personnage.enregistrerObserver(this);
    }

    @Override
    public void update(Personnage personnage) {
        System.out.println("\u001B[34m "+personnage.getMana() + "⭐"+"\u001B[0m" );
    }
}
