public class observerRPG implements Observer{
    private Sujet sujet;

    public observerRPG(Sujet sujet) {
        this.sujet = sujet;
        sujet.enregistrerObserver(this);
    }

    @Override
    public void actualiser(AffichageRPG affichage) {
        affichage.afficher();
    }
}
