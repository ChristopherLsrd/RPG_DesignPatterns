public class Guerrier extends Personnage{

    public Guerrier(int hp,int attaque) {
        super(hp,attaque,0,"Guerrier");
    }

    public void attaquer(Personnage personnage){
        personnage.setHp(personnage.getHp()-super.attaque);
        personnage._Etat.estAttaque();

    }


}
