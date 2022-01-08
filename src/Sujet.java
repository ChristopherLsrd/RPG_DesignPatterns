public interface Sujet {
    public void enregistrerObserver(Observer obs);
    public void supprimerObserver(Observer obs);
    public void notifierObserver();
}
