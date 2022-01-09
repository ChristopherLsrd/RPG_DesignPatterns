package main.observer;

import main.personnage.Personnage;

public class DisplayEtat implements Observer{
    private Personnage personnage;

    public DisplayEtat(Personnage personnage) {
        this.personnage = personnage;
        personnage.enregistrerObserver(this);
    }

    @Override
    public void update(Personnage personnage) {
        switch (personnage.getEtat().getClass().getName()){
            case "EtatAgonie":
                System.out.println("Etat : \uD83E\uDD15");
                break;
            case "EtatMort":
                System.out.println("Etat : \uD83D\uDC80");
                break;
        }
    }
}
