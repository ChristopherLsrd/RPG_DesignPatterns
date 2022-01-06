public class EtatAgonie extends Etat{

    public EtatAgonie(Personnage perso) {
        super(perso);
    }

    @Override
    public void estAttaque() {
        if(perso.getHp()<=0){
            perso.changerEtatMort();
        }
    }
}
