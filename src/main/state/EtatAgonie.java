package main.state;

import main.personnage.Personnage;

public class EtatAgonie extends Etat {

    public EtatAgonie(Personnage perso) {
        super(perso);
    }

    @Override
    public void estAttaque() {
        if (perso.getHp() <= 0) {
            perso.changerEtatMort();
        }
    }

    @Override
    public void attack(Personnage perso) {
        double probaReussite = Math.random();

        if (probaReussite > this.perso.getProbaAttack()) {
            System.out.println("Attaque ratée\n");
        } else {
            perso.setHp(perso.getHp() - (int) (this.perso.getAttaque() * 1.25));
            perso.estAttaque();
            System.out.printf("Attaque réussie\n");
        }
    }

    @Override
    public void spell(Personnage perso) {
        double probaReussite = Math.random();
        double manaCost = this.perso.getSpell().getManaCost() * 0.75;

        if (checkMana(manaCost)) {
            if (probaReussite > this.perso.getSpell().getProbability()) {
                System.out.println("Sort raté\n");
            } else {

                perso.setHp(perso.getHp() - this.perso.getAttaque());
                this.perso.setMana(this.perso.getMana() - (int) manaCost);
                perso.estAttaque();
                System.out.printf("Sort lancé et réussi\n");
            }
        }
    }

    @Override
    public void regenMana() {
        perso.setMana(perso.getMana() + 25);
    }

    @Override
    public void heal() {
        perso.setHp(perso.getHp() + 25);
        if (perso.getHp() > (perso.getHpIni() * 0.15)) {
            perso.changerEtatVivant();
        }
    }
}
