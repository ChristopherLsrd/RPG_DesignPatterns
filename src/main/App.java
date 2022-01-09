package main;

import main.observer.DisplayEtat;
import main.observer.DisplayHp;
import main.observer.DisplayMana;
import main.observer.Observer;
import main.personnage.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

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
        personnage.setHp(100);
        personnage.setMana(20);
    }
}
