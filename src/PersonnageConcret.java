public class PersonnageConcret extends Personnage{

    protected Etat _Etat;
    protected EtatVivant _EtatVivant;
    protected EtatAgonie _EtatAgonie;
    protected EtatMort _EtatMort;

    public PersonnageConcret(){

        this._EtatMort=new EtatMort(this);
        this._EtatAgonie=new EtatAgonie(this);
        this._EtatVivant=new EtatVivant(this);

        this._Etat=_EtatVivant;

    }

    @Override
    public Etat getEtat() {
        return _Etat;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public Arme getArme() {
        return arme;
    }

    @Override
    public void setArme(Arme arme){
        System.out.println("Vous ne pouvez pas m'équiper d'une arme, vous n'êtes pas un guerrier");
    }


    @Override
    public int getAttaque() {
        return attaque;
    }

    @Override
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    @Override
    public void changerEtatMort(){
        _Etat=_EtatMort;

    }

    @Override
    public void changerEtatAgonie(){
        _Etat=_EtatAgonie;
        setAttaque((int)(getAttaque()*1.25));
    }

    @Override
    public void attaquer(Monstre monstre) {
        System.out.println("Vous ne pouvez pas attaquer, vous n'êtes pas un guerrier");
    }

    @Override
    public void attaqueParMonstre(int degats){
        System.out.println("Vous perdez "+degats+" points de vie");
        this.setHp(this.getHp()-degats);
    }

    @Override
    public void lancerSort(Monstre monstre) {
        System.out.println("Vous ne pouvez pas lancer de sorts, vous n'êtes pas pas un sorcier");
    }

    @Override
    public void recupererMana() {
        System.out.println("Vous ne pouvez pas récupérer de mana, vous n'êtes pas un sorcier");
    }

    @Override
    public void seSoigner() {}


    @Override
    public void changerArme() {
        System.out.println("Vous ne pouvez pas changer d'arme, vous n'êtes pas pas un guerrier");
    }

    @Override
    public void nouveauTour(Monstre monstre){}

    @Override
    public void afficher(){
        System.out.println("Points de vie : "+this.getHp());
        System.out.println("Puissance d'attaque : "+this.getAttaque());
    }
}
