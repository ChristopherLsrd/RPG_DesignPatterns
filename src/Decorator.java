public abstract class Decorator extends Personnage{

    protected Personnage perso;

    public Decorator(Personnage perso) {
        this.perso=perso;

    }


    @Override
    public void attaquer(Personnage perso){
        perso.attaquer(perso);
    }

    @Override
    public void lancerSort(Personnage perso){
        perso.lancerSort(perso);
    }



}
