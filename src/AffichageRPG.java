public class AffichageRPG {

    private Personnage perso;
    private Monstre monstre;


    public  AffichageRPG(Personnage perso, Monstre monstre){
        this.monstre=monstre;
        this.perso=perso;
    }

    public void afficher(){
        System.out.println("============");
        perso.afficher();
        System.out.println("============");
        monstre.afficher();
    }
}
