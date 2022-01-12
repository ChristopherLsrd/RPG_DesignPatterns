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
    public static final String ANSI_ROUGE = "\u001B[31m";
    public static final String ANSI_BLEU = "\u001B[34m";
    public static final String ANSI_JAUNE = "\u001B[33m";

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

        int i = 0;
        int chooseAction;
        while (i < ennemies.size() && !mainPerso.isDead()) {
            Personnage ennemiEnCours = ennemies.get(i);
            while (!ennemiEnCours.isDead() && !mainPerso.isDead()) {
                System.out.println(ANSI_JAUNE + "⚠ NOUVEAU TOUR ⚠" + ANSI_RESET);
                System.out.println("Votre héro : " + ANSI_ROUGE + mainPerso.getHp() + "❤ " + ANSI_BLEU + mainPerso.getMana() + "⭐ " + ANSI_RESET + "\t Ennemi : " + ANSI_ROUGE + ennemiEnCours.getHp() + "❤ " + ANSI_BLEU + ennemiEnCours.getMana() + "⭐" + ANSI_RESET);
                //Actio du mainPersonnage sur un tour
                chooseAction = 0;
                do {
                    System.out.println("Choisissez votre action: ");
                    System.out.println("1. Attaquer ⚔");
                    System.out.println("2. Lancer un sort \uD83D\uDCDC");
                    System.out.println("3. Régénerer votre mana " + ANSI_BLEU + "⭐" + ANSI_RESET);
                    System.out.println("4. Vous soigner " + ANSI_ROUGE + "❤" + ANSI_RESET);
                    chooseAction = sc.nextInt();
                    if (chooseAction != 1 && chooseAction != 2 && chooseAction != 3 && chooseAction != 4) {
                        System.out.println("Ce choix ne correspond à aucune action");
                    }
                } while (chooseAction != 1 && chooseAction != 2 && chooseAction != 3 && chooseAction != 4);
                switch (chooseAction) {
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
                if (!ennemiEnCours.isDead()) {
                    //Action de l'ennemi sur un tour
                    System.out.printf("Tour de l'ennemi :");
                    double action = Math.random();
                    if (action <= 0.5) {
                        ennemiEnCours.attack(mainPerso);
                    } else {
                        ennemiEnCours.spell(mainPerso);
                    }
                } else {
                    ennemiEnCours.changerEtatMort();
                }

            }
            //Gestion de la mort d'un ennemi
            if (ennemiEnCours.isDead()) {
                i++;
                if (i < ennemies.size()) {
                    System.out.println(ennemiEnCours.getClass().getSimpleName() + " est mort ! Un autre ennemi arrive !");
                } else {
                    System.out.println(ennemiEnCours.getClass().getSimpleName() + " est mort !");
                }

            //Fin du jeu
            } else if (mainPerso.isDead()) {
                System.out.println("Votre " + mainPerso.getClass().getSimpleName() + "est mort");
                System.exit(0);
            }

        }

        //Fin du jeu
        if (mainPerso.isDead()) {
            System.out.println("Votre " + mainPerso.getClass().getSimpleName() + " est mort");
            System.exit(0);
        } else {
            System.out.println("Vous avez gagné !");
            System.exit(0);
        }
        System.out.println(mainPerso.toString());
    }

    //Initialisation des ennemis
    private static ArrayList<Personnage> initEnnemies() {
        Spell spellWarriorEnnemie = new Spell(20, (float) 0.45, "Coup de tête");
        Spell spellMageEnnemie = new Spell(55, (float) 0.60, "Trait de feu");

        ArrayList<Personnage> ennemies = new ArrayList<>();
        ennemies.add(new Guerrier(75, 30, 30, spellWarriorEnnemie));
        ennemies.add(new Sorcier(60, 25, 110, spellMageEnnemie));
        ennemies.add(new Guerrier(95, 40, 40, spellWarriorEnnemie));
        return ennemies;
    }

    //initialisation du pattern Observer
    private static void initObserver(Personnage personnage) {
        new DisplayEtat(personnage);
        new DisplayMana(personnage);
        new DisplayHp(personnage);
    }
}
