public class EtatVivant extends Etat{

    public EtatVivant(Personnage perso) {
        super(perso);
    }

    @Override
    public void estAttaque() {
        if(perso.getHp()<vieIni*(0.15)){
            perso.changerEtatAgonie();
        }
        else if (perso.getHp()<=0){
            perso.changerEtatMort();

        }

    }
}
