package main.state;

import main.personnage.Personnage;

public abstract class Etat {

    Personnage perso;

    public Etat(Personnage perso) {
        this.perso = perso;
        //vieIni=perso.getHp();
    }

    public void estAttaque(){}

    public void attack(Personnage perso,float proba){}

    public void spell(Personnage perso){}

    public void regenMana(){}

    public void heal(){}

    public void esquive(){}

    //public abstract void attaqueParMonstre(int degats);

    //public abstract void nouveauTour(Monstre monstre);


}
