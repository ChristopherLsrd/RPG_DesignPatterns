package main.state;

import main.personnage.Personnage;

public class EtatAgonie extends Etat {

    public EtatAgonie(Personnage perso) {
        super(perso);
    }

    @Override
    public void estAttaque() {
        if(perso.getHp()<=0){
            perso.changerEtatMort();
        }
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
