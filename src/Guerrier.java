import java.sql.SQLOutput;
import java.util.Scanner;

public class Guerrier extends Decorator{

    public Guerrier(Personnage personnage) {
       super(personnage);
       this.perso.setAttaque(20);
       this.perso.setMana(0);
       this.perso.setHp(100);
        System.out.println("Choisissez votre arme :");

    }


    @Override
    public void attaquer(Monstre monstre){
        monstre.setHp(monstre.getHp()-this.perso.getAttaque());

    }

    @Override
    public void setArme(Arme arme) {
        this.perso.arme = arme;
        arme.attaque(this);
    }

    public void changerArme(){
        Scanner sc =new Scanner(System.in);
        int choix;
        do{
            System.out.println("Choissiez votre arme :");
            System.out.println("1: Epée");
            System.out.println("2: Hache");
            choix=sc.nextInt();
        }while (choix!=1 && choix !=2);
        if(choix==1){
            Arme arme=new Epee();
            if(perso.getArme().getNom().equals(arme.getNom())){
                System.out.println("Vous êtes déja équipé de cette arme");
            }
            else{
                perso.setAttaque(perso.getAttaque()-perso.getArme().getDegats());
                setArme(arme);
            }

        }
        else{
            Arme arme= new Hache();
            if(perso.getArme().getNom().equals(arme.getNom())){
                System.out.println("Vous êtes déja équipé de cette arme");
            }
            else{
                perso.setAttaque(perso.getAttaque()-perso.getArme().getDegats());
                setArme(arme);
            }
        }

    }



    public void seSoigner() {
        if(this.perso.getHp()+10>100){
            this.perso.setHp(100);
        }
        else{
            this.perso.setHp(this.perso.getHp()+10);
        }

    }

    @Override
    public void nouveauTour(Monstre monstre) {

        this.perso.seSoigner();
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
                this.attaquer(monstre);
                break;
            case 2:

                this.changerArme();
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
    public void afficher(){
        System.out.println("Guerrier :");
        System.out.println("Points de vie : "+this.perso.getHp());
        System.out.println("Puissance d'attaque : "+this.perso.getAttaque());
        System.out.println("Arme : "+this.perso.getArme().getNom());
    }
}
