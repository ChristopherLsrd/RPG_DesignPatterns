public class Monstre {

    protected int hp;
    protected int attaque;
    protected String nom;

    public Monstre(int hp, int attaque, String nom) {
        this.hp = hp;
        this.attaque = attaque;
        this.nom = nom;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void attaquer(Personnage perso){

        perso.attaqueParMonstre(this.getAttaque());
        perso.getEtat().estAttaque();
    }

    public void afficher(){
        System.out.println(getNom()+" : ");
        System.out.println("Points de vie : "+getHp());
        System.out.println("Attaque : "+getAttaque());

    }
}
