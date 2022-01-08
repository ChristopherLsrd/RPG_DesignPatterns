import java.sql.SQLOutput;
import java.util.Scanner;

public class Sorcier extends Decorator{

    public Sorcier(Personnage perso) {
        super(perso);
        this.perso.setAttaque(25);
        this.perso.setMana(90);
        this.perso.setHp(100);
    }

    @Override
    public void nouveauTour(Monstre monstre) {
        this.perso.setMana(this.perso.getMana()+10);
        Scanner sc=new Scanner(System.in);
        int choix;
        do{
            System.out.println("Choisissez une action :");
            System.out.println("1: Lancer un sort");
            System.out.println("2: Récupérer du mana");
            System.out.println("3: Se soigner");

            choix=sc.nextInt();
            if(choix !=1 && choix !=2 && choix!=3){
                System.out.println("Cela ne correspond à aucune action.");
            }
        }while (choix !=1 && choix !=2 && choix!=3);
        switch (choix){
            case 1:
                this.lancerSort(monstre);
                break;
            case 2:
                this.recupererMana();
                break;
            case 3:
                if(this.perso.getHp()==100){
                    System.out.println("Votre santé est déjà au maximum");
                    nouveauTour(monstre);
                }
                else{
                    this.seSoigner();
                }
                break;

        }
    }

    @Override
    public void lancerSort(Monstre monstre){
        System.out.println("Vous lancez votre sort");
        monstre.setHp(monstre.getHp()-this.perso.getAttaque());
        this.perso.setMana(this.perso.getMana()-15);
    }

    @Override
    public void recupererMana() {
        System.out.println("Vous récupérez 25 mana");
        this.perso.setMana(this.perso.getMana()+25);
    }

    @Override
    public void seSoigner() {
        if(this.perso.getHp()+25>100){
            System.out.println("Vous récupérez " + (this.perso.getHp()+25-100) + " HP");
            this.perso.setHp(100);
        }
        else{
            System.out.println("Vous récupérez 25 HP");
            this.perso.setHp(this.perso.getHp()+25);
        }

    }

    @Override
    public void afficher(){
        System.out.println("Sorcier :");
        System.out.println("Points de vie : "+perso.getHp());
        System.out.println("Puissance d'attaque : "+perso.getAttaque());
        System.out.println("Mana : "+perso.getMana());
    }

}
