package main.state;

import main.personnage.Personnage;

public class EtatMort extends Etat{

    public EtatMort(Personnage perso){
        super(perso);
    }

    @Override
    public void heal() {
        double probaReussite = Math.random();

        if (probaReussite <= 0.10) {
            if (checkMana(30)) {
                perso.setHp(40);
            }
        }
    }
}
