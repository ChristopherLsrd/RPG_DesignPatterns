package main.observer;

public interface PersonnageSujet {
    public void enregistrerObserver(Observer obs);
    public void supprimerObserver(Observer obs);
    public void notifierObserver();
}
