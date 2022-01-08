public abstract class Decorator extends Personnage{

    protected Personnage perso;

    public Decorator(Personnage perso) {
        this.perso=perso;
    }

    public abstract void displayCloth();

    /**
    @Override
    public Etat getEtat(){
        return perso.getEtat();
    }

    @Override
    public void changerEtatAgonie() {
        perso.changerEtatAgonie();
    }

    @Override
    public void changerEtatMort() {
        perso.changerEtatMort();
    }

    @Override
    public void attaqueParMonstre(int degats){
        perso.attaqueParMonstre(degats);
    }


    @Override
    public void attaquer(Monstre monstre){
        perso.attaquer(monstre);
    }

    @Override
    public void lancerSort(Monstre monstre){
        perso.lancerSort(monstre);
    }

    @Override
    public void recupererMana() { perso.recupererMana(); }

    @Override
    public void seSoigner() { perso.seSoigner(); }


    @Override
    public void changerArme(){perso.changerArme();}

    @Override
    public void nouveauTour(Monstre monstre) { perso.nouveauTour(monstre); }

    @Override
    public void afficher(){
        perso.afficher();
    }
    **/

}
