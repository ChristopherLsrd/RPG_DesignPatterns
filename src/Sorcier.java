public class Sorcier extends Decorator{

    public Sorcier(Personnage perso) {
        super(perso);
    }

    @Override
    public void lancerSort(Personnage perso){
        perso.setHp(perso.getHp()-super.attaque);
        perso._Etat.estAttaque();
        this.perso.setMana(this.perso.getMana()-15);
    }


}
