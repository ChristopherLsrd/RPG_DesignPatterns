public class PersonnageConcret extends Personnage{

    public PersonnageConcret(){

        this._EtatMort=new EtatMort(this);
        this._EtatAgonie=new EtatAgonie(this);
        this._EtatVivant=new EtatVivant(this);

        this._Etat=_EtatVivant;

    }

    @Override
    public void attaquer(Personnage personnage) {
        System.out.println("Je ne peux pas attaquer, je ne suis pas un guerrier");
    }

    @Override
    public void lancerSort(Personnage personnage) {
        System.out.println("Je ne peux pas lancer de sorts, je ne suis pas un sorcier");
    }

    @Override
    public void recupererMana() {
        System.out.println("Je ne peux pas récupérer de mana, je ne suis pas un sorcier");
    }

    @Override
    public void seSoigner() {}

    @Override
    public void setArme(Arme arme) {
        System.out.println("Je ne peux pas m'équiper d'une arme, je ne suis pas un guerrier");
    }

    @Override
    public void nouveauTour(){}

    @Override
    public void afficher(){
        System.out.println("Points de vie : "+this.getHp());
        System.out.println("Puissance d'attaque : "+this.getAttaque());
    }
}
