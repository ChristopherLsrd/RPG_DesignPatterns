package main.state;

import main.personnage.Personnage;

public class EtatVivant extends Etat{

    public EtatVivant(Personnage perso) {
        super(perso);
    }

    @Override
    public void estAttaque() {
        if (perso.getHp()<=0){
            perso.changerEtatMort();
        }
        else if(perso.getHp() < (perso.getHpIni()*0.15)){
            perso.changerEtatAgonie();
        }

    }

    @Override
    public void attack(Personnage perso) {
        double probaReussite = Math.random();
        if(probaReussite >= this.perso.getProbaAttack()){
            System.out.println("Attaque ratée");
        }
        else{
            perso.setHp(perso.getHp() - this.perso.getAttaque());
            perso.estAttaque();
            System.out.printf("Attaque réussie\n");
        }
    }

    @Override
    public void spell(Personnage perso) {
        double probaReussite = Math.random();

        if(checkMana(this.perso.getSpell().getManaCost())){
            if(probaReussite >= this.perso.getSpell().getProbability()){
                System.out.println("Sort raté");
            }
            else{
                perso.setHp(perso.getHp() - this.perso.getAttaque());
                System.out.printf("Sort lancé et réussi\n");
                this.perso.setMana(this.perso.getMana() - this.perso.getSpell().getManaCost());
                perso.estAttaque();
            }
        }
    }

    @Override
    public void regenMana() {
        this.perso.setMana(this.perso.getMana()+20);
    }

    @Override
    public void heal() {
        if(this.perso.getHp() >= this.perso.getHpIni()){
            System.out.println("Votre santé est déjà au maximum");
        }
        else {
            if (checkMana(30)){
                if(perso.getHp()+40> perso.getHpIni()){
                    perso.setHp(perso.getHpIni());
                }
                else{
                    perso.setHp(perso.getHp()+40);
                }

            }
        }
    }
}
