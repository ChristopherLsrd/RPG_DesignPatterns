package main.observer;

import main.personnage.Personnage;

public class DisplayHp implements Observer{
    private Personnage personnage;

    public DisplayHp(Personnage personnage) {
        this.personnage = personnage;
        personnage.enregistrerObserver(this);
    }

    @Override
    public void update(Personnage personnage) {
        System.out.println(personnage.getHp() + " ❤");
    }
}
