import java.util.Scanner;

public class Guerrier extends Decorator{

    public Guerrier(Personnage personnage) {
       super(personnage);
       this.perso.setAttaque(20);
       this.perso.setMana(0);
       this.perso.setHp(100);
    }


    @Override
    public void attaquer(Personnage personnage){
        personnage.setHp(personnage.getHp()-super.attaque);
        personnage._Etat.estAttaque();

    }

    @Override
    public void setArme(Arme arme) {
        this.arme = arme;
        arme.attaque(this);
    }

    public void seSoigner() {
        this.perso.setHp(this.perso.getHp()+10);
    }

    @Override
    public void nouveauTour() {
        this.perso.setHp(this.perso.getHp()+10);
        Scanner sc=new Scanner(System.in);
        int choix;
        do{
            System.out.println("Choisissez une action :");
            System.out.println("1: Attaquer");
            System.out.println("2: Changer d'arme");
            System.out.println("3: Se soigner");

            choix=sc.nextInt();
            if(choix !=1 && choix !=2 && choix!=3){
                System.out.println("Cela ne correspond à aucune action.");
            }
        }while (choix !=1 && choix !=2 && choix!=3);
        switch (choix){
            case 1:
                perso.attaquer();
                break;
            case 2:
                perso.setAttaque(perso.getAttaque()-perso.getArme().getDegats());
                perso.setArme();
                break;
            case 3:
                perso.seSoigner();
        }
    }

    @Override
    public void afficher(){
        System.out.println("Points de vie : "+this.getHp());
        System.out.println("Puissance d'attaque : "+this.getAttaque());
        System.out.println("Arme : "+this.getArme().getNom());
    }
}
