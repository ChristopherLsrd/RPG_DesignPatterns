public abstract class Personnage {

    protected int hp;
    protected int attaque;
    protected int mana;
    protected Arme arme;

    protected Etat _Etat;
    protected EtatVivant _EtatVivant;
    protected EtatAgonie _EtatAgonie;
    protected EtatMort _EtatMort;


   /* public Personnage(int hp, int attaque, int mana) {
        this.hp = hp;
        this.attaque = attaque;
        this.mana = mana;

        this._EtatMort=new EtatMort(this);
        this._EtatAgonie=new EtatAgonie(this);
        this._EtatVivant=new EtatVivant(this);

        this._Etat=_EtatVivant;

    }*/

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Arme getArme() {
        return arme;
    }

    public void changerEtatMort(){
        _Etat=_EtatMort;

    }

    public void changerEtatAgonie(){
        _Etat=_EtatAgonie;
        setAttaque((int)(getAttaque()*1.25));
    }

    public abstract void attaquer(Personnage personnage);

    public abstract void lancerSort(Personnage personnage);
    public abstract void recupererMana();
    public abstract void seSoigner();

    public abstract void setArme(Arme arme);

    public abstract void nouveauTour();

    public abstract void afficher();

}
