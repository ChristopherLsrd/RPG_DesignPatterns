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

    @Override
    public void recupererMana() { perso.recupererMana(); }

    @Override
    public void seSoigner() { perso.seSoigner(); }

    public void setArme(Arme arme) {perso.setArme(arme);}

    @Override
    public void nouveauTour() { perso.nouveauTour(); }

    @Override
    public void afficher(){
        perso.afficher();
    }


}
