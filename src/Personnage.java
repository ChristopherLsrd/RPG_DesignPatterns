public abstract class Personnage {

    protected int hp;
    protected int attaque;
    protected int mana;
    protected Arme arme;

    public abstract int getHp();

    public abstract void setHp(int hp);

    public abstract int getMana();

    public abstract void setMana(int mana);

    public abstract Arme getArme();

    public  abstract void setArme(Arme arme);

    public abstract int getAttaque();

    public abstract void setAttaque(int attaque);

    public abstract void attaquer(Monstre monstre);

    public abstract void attaqueParMonstre(int degats);

    public abstract void lancerSort(Monstre monstre);

    public abstract void recupererMana();

    public abstract void seSoigner();

    public abstract void changerArme();

    public abstract void nouveauTour(Monstre monstre);

    public abstract void afficher();

    public abstract void changerEtatMort();

    public abstract void changerEtatAgonie();

    public abstract Etat getEtat();
}
