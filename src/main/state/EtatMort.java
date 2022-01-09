package main.state;

import main.personnage.Personnage;

public class EtatMort extends Etat{

    public EtatMort(Personnage perso){
        super(perso);
    }

    @Override
    public void attack(Personnage perso,float proba) {

    }

    @Override
    public void spell(Personnage perso) {

    }

    @Override
    public void regenMana() {

    }

    @Override
    public void heal() {

    }
}
