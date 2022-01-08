import java.sql.SQLOutput;
import java.util.Scanner;

public class Sorcier extends Decorator{

    public Sorcier(Personnage perso) {
        super(perso);
        this.perso.setAttaque(25);
        this.perso.setMana(100);
        this.perso.setHp(100);
    }

    @Override
    public void lancerSort(Personnage perso){
        perso.setHp(perso.getHp()-super.attaque);
        perso._Etat.estAttaque();
        this.perso.setMana(this.perso.getMana()-15);
    }

    @Override
    public void nouveauTour() {
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
                perso.lancerSort();
                break;
            case 2:
                perso.recupererMana();
                break;
            case 3:
                perso.seSoigner();
        }
    }

    @Override
    public void recupererMana() {
        this.perso.setMana(this.perso.getMana()+25);
    }

    @Override
    public void seSoigner() {
        this.perso.setHp(this.perso.getHp()+25);
    }

    @Override
    public void afficher(){
        System.out.println("Points de vie : "+this.getHp());
        System.out.println("Puissance d'attaque : "+this.getAttaque());
        System.out.println("Mana : "+this.getMana());
    }

}
