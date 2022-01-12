package main;

import main.observer.DisplayEtat;
import main.observer.DisplayHp;
import main.observer.DisplayMana;
import main.observer.Observer;
import main.personnage.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personnage> ennemies = initEnnemies();

        // Choose main.personnage
        Personnage mainPerso = null;
        int choosePerso = 0;
        System.out.println("Choississez un personnage : ");
        System.out.println("1. Guerrier");
        System.out.println("2. Sorcier");
        choosePerso = sc.nextInt();
        switch (choosePerso) {
            case 1:
                CreateWarrior cw = new CreateWarrior();
                mainPerso = new Guerrier(cw);
                break;
            case 2:
                CreateMage cm = new CreateMage();
                mainPerso = new Sorcier(cm);
                break;
            default:
                System.exit(1);
                break;
        }
        mainPerso.equipStuff();
        initObserver(mainPerso);

        int i=0;
        int chooseAction;
        while(i<ennemies.size() && !mainPerso.getEtat().getClass().getName().equals("EtatMort")){
            Personnage ennemiEnCours=ennemies.get(i);
            while (ennemiEnCours.getHp()>0 && !mainPerso.getEtat().getClass().getName().equals("EtatMort")){
                System.out.println("\u001B[33m"+"⚠ NOUVEAU TOUR ⚠"+ANSI_RESET);
                System.out.println("Votre héro : "+"\u001B[31m"+mainPerso.getHp()+ "❤ \u001B[34m"+mainPerso.getMana()+"⭐"+ANSI_RESET+"\t Ennemi : \u001B[31m"+ennemiEnCours.getHp()+ " ❤ \u001B[34m"+ennemiEnCours.getMana()+"⭐"+ANSI_RESET);
                chooseAction=0;
                do{
                    System.out.println("Choisissez votre action: ");
                    System.out.println("1. Attaquer ⚔");
                    System.out.println("2. Lancer un sort \uD83D\uDCDC");
                    System.out.println("3. Régénerer votre mana \u001B[34m⭐"+ANSI_RESET);
                    System.out.println("4. Vous soigner \u001B[31m❤"+ANSI_RESET);
                    chooseAction=sc.nextInt();
                    if(chooseAction!=1 && chooseAction!=2 && chooseAction!=3 && chooseAction!=4){
                        System.out.println("Ce choix ne correspond à aucune action");
                    }
                }while(chooseAction!=1 && chooseAction!=2 && chooseAction!=3 && chooseAction!=4);
                switch (chooseAction){
                    case 1:
                        mainPerso.attack(ennemiEnCours);
                        break;
                    case 2:
                        mainPerso.spell(ennemiEnCours);
                        break;
                    case 3:
                        mainPerso.regenMana();
                        break;
                    case 4:
                        mainPerso.heal();
                        break;
                }
                //!ennemiEnCours.getEtat().getClass().getName().equals("EtatMort)"
                if(ennemiEnCours.getHp()>=0){
                    System.out.printf("HP de l'ennemi : "+ennemiEnCours.getHp()+"\n");
                    System.out.printf("Tour de l'ennemi :");
                    double action=Math.random();
                    if(action<=0.5){
                        ennemiEnCours.attack(mainPerso);
                    }
                    else {
                        ennemiEnCours.spell(mainPerso);
                    }
                }
                else{
                    ennemiEnCours.changerEtatMort();
                }

            }
            if(ennemiEnCours.isDead()){
                i++;
                if(i<ennemies.size()){
                    System.out.println(ennemiEnCours.getClass().getSimpleName()+" est mort ! Un autre ennemi arrive !");
                }
                else{
                    System.out.println(ennemiEnCours.getClass().getSimpleName()+" est mort !");
                }


            }
            else if(mainPerso.getEtat().getClass().getName().equals("EtatMort")){
                System.out.println("Votre "+ mainPerso.getClass().getName() +"est mort");
                System.exit(0);
            }

        }

        if(mainPerso.getEtat().getClass().getName().equals("EtatMort")){
            System.out.println("Votre "+ mainPerso.getClass().getName() +"est mort");
            System.exit(0);
        }else{
            System.out.println("Vous avez gagné !");
            System.exit(0);
        }
        System.out.println(mainPerso.toString());
    }

    private static ArrayList<Personnage> initEnnemies() {
        Spell spellWarriorEnnemie = new Spell(20, (float) 0.45, "Coup de tête");
        Spell spellMageEnnemie = new Spell(55, (float) 0.60, "Trait de feu");

        ArrayList<Personnage> ennemies = new ArrayList<>();
        ennemies.add(new Guerrier(75, 25, 30, spellWarriorEnnemie));
        ennemies.add(new Sorcier(50, 15, 110, spellMageEnnemie));
        ennemies.add(new Guerrier(85, 35, 40, spellWarriorEnnemie));
        return ennemies;
    }
    private static void initObserver(Personnage personnage){
        new DisplayEtat(personnage);
        new DisplayMana(personnage);
        new DisplayHp(personnage);
        /*personnage.setHp(100);
        personnage.setMana(20);*/
    }
}
