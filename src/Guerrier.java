public class Guerrier extends Decorator{

    public Guerrier(Personnage personnage) {
       super(personnage);
    }

    @Override
    public void attaquer(Personnage personnage){
        personnage.setHp(personnage.getHp()-super.attaque);
        personnage._Etat.estAttaque();

    }


}
