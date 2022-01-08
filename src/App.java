import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> nomMonstre=new ArrayList<>();
        nomMonstre.add("Orc");
        nomMonstre.add("Troll");
        nomMonstre.add("Esprit");

        Monstre boss=new Monstre(150,15,"Dragon");

        Personnage personnage=new PersonnageConcret();
        personnage.lancerSort(boss);
        personnage=new Guerrier(personnage);
        personnage.setArme(new Epee());
        SujetConcret sujetConcret=new SujetConcret();
        new observerRPG(sujetConcret);
        sujetConcret.setAffichage(new AffichageRPG(personnage,boss));


        boss.attaquer(personnage);
        personnage.nouveauTour(boss);





        //Choix mode difficulte (facile : 1 monstre + boss, moyen: 2 monstres + boss, difficile : 3 monstres + boss)
        //verif pv monstre (while(pv>0))


    }
}
