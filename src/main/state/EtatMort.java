package main.state;

import main.personnage.Personnage;

public class EtatMort extends Etat{

    public EtatMort(Personnage perso){
        super(perso);
    }

    @Override
    public void attack() {

    }

    @Override
    public void spell() {

    }

    @Override
    public void regenMana() {

    }

    @Override
    public void heal() {

    }
}
