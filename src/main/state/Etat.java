package main.state;

import main.personnage.Personnage;

public abstract class Etat {

    Personnage perso;

    public Etat(Personnage perso) {
        this.perso = perso;
        //vieIni=perso.getHp();
    }

    //Vérifie l'état dans lequel se trouve un personnage après s'être fait attaquer
    public void estAttaque() {
    }

    //Attaque le personnage passé en paramètre avec une probabilité de rater l'attaque
    public void attack(Personnage perso) {
    }

    //Lance un sort au personnage passé en paramètre avec une probabilité de rater le sort
    public void spell(Personnage perso) {
    }

    //Donne du mana en plus au personnage
    public void regenMana() {
    }

    //Soigne le personnage si sa vie n'est pas déjà au maximum
    public void heal() {
    }


    //Vérifie si on a assez de mana pour lancer un sort
    protected boolean checkMana(double mana) {
        if ((this.perso.getMana() - mana) >= 0) {
            return true;
        } else {
            System.out.println("Pas assez de mana");
            return false;
        }
    }
}
