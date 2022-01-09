package main.state;

import main.personnage.Personnage;

public class EtatVivant extends Etat{

    public EtatVivant(Personnage perso) {
        super(perso);
    }

    @Override
    public void estAttaque() {
        if(perso.getHp()<(perso.getHpIni()*0.15)){
            perso.changerEtatAgonie();
        }
        else if (perso.getHp()<=0){
            perso.changerEtatMort();

        }
    }

    @Override
    public void attack(Personnage perso,float proba) {
        double probaReussite=Math.random();
        if(probaReussite>proba){
            System.out.println("Attaque ratée");
        }
        else{
            perso.setHp(perso.getHp()-this.perso.getAttaque());
        }

    }

    @Override
    public void spell(Personnage perso) {
        double proba=Math.random();
        if(this.perso.getSpell().getManaCost()>this.perso.getMana()){
            System.out.println("Vous n'avez pas assez de mana pour lancer ce sort");
        }
        else{
            if(proba>this.perso.getSpell().getProbability()){
                System.out.println("Sort raté");
            }
            else{
                perso.setHp(perso.getHp()-this.perso.getAttaque());
                this.perso.setMana(this.perso.getMana()-this.perso.getSpell().getManaCost());
            }
        }
    }

    @Override
    public void regenMana() {
        this.perso.setMana(this.perso.getMana()+20);
    }

    @Override
    public void heal() {
        if(this.perso.getHp()==100){
            System.out.println("Votre santé est déjà au maximum");
        }
        else {
            perso.setHp(perso.getHp()+20);
        }
    }
}
