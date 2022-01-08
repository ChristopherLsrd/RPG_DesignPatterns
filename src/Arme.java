public class Arme {

    int degats;
    String nom;

    public Arme(String nom,int degats) {
        this.nom=nom;
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public String getNom() {
        return nom;
    }

    public void attaque(Personnage perso){
        System.out.println(perso.getAttaque());
        perso.setAttaque(perso.getAttaque()+this.getDegats());
    }
}
