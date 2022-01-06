public class Personnage {

    protected String classe;
    protected int hp;
    protected int attaque;
    protected int mana;
    protected Arme arme;

    protected Etat _Etat;
    protected EtatVivant _EtatVivant;
    protected EtatAgonie _EtatAgonie;
    protected EtatMort _EtatMort;


    public Personnage(int hp, int attaque, int mana,String classe) {
        this.hp = hp;
        this.attaque = attaque;
        this.mana = mana;
        this.classe=classe;

        this._EtatMort=new EtatMort(this);
        this._EtatAgonie=new EtatAgonie(this);
        this._EtatVivant=new EtatVivant(this);

        this._Etat=_EtatVivant;

    }

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

    public void setArme(Arme arme) {
        this.arme = arme;
        arme.attaque(this);
    }

    public String getClasse() {
        return classe;
    }

    public void changerEtatMort(){
        _Etat=_EtatMort;

    }

    public void changerEtatAgonie(){
        _Etat=_EtatAgonie;
        setAttaque((int)(getAttaque()*1.25));
    }

    public void afficher(){
        System.out.println(this.getClasse());
        System.out.println("Points de vie : "+this.getHp());
        System.out.println("Puissance d'attaque : "+this.getAttaque());
        System.out.println("Mana : "+this.getMana());
    }
}
