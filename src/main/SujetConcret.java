package main;

import java.util.ArrayList;
import java.util.List;

public class SujetConcret implements Sujet{
    List<Observer> observerCollection;
    private AffichageRPG affichage ;


    public SujetConcret(){
        observerCollection=new ArrayList<>();
    }

    @Override
    public void enregistrerObserver(Observer obs) {
        observerCollection.add(obs);
    }

    @Override
    public void supprimerObserver(Observer obs) {
        observerCollection.remove(obs);
    }

    @Override
    public void notifierObserver() {
        observerCollection.forEach(obs -> obs.actualiser(affichage));
    }

    public void setAffichage(AffichageRPG affichage) {
        this.affichage = affichage;
        notifierObserver();
    }
}
