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
    public void attack(Personnage perso,float proba) {
        double probaReussite=Math.random();
        if(probaReussite>proba){
            System.out.println("Attaque ratée");
        }
        else{
            perso.setHp(perso.getHp()-(int)(this.perso.getAttaque()*1.25));
        }
    }

    @Override
    public void spell(Personnage perso) {
        double proba=Math.random();
        if((this.perso.getSpell().getManaCost()*0.75)>this.perso.getMana()){
            System.out.println("Vous n'avez pas assez de mana pour lancer ce sort");
        }
        else{
            if(proba>this.perso.getSpell().getProbability()){
                System.out.println("Sort raté");
            }
            else{
                perso.setHp(perso.getHp()-this.perso.getAttaque());
                this.perso.setMana(this.perso.getMana()-(int)(this.perso.getSpell().getManaCost()*0.75));
            }
        }
    }

    @Override
    public void regenMana() {
        perso.setMana(perso.getMana()+25);
    }

    @Override
    public void heal() {
        perso.setHp(perso.getHp()+25);
        if(perso.getHp()> (perso.getHpIni()*0.15)){
            perso.changerEtatVivant();
        }
    }
}
