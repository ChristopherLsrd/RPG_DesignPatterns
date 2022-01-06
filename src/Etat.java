public abstract class Etat {

    Personnage perso;
    int vieIni;

    public Etat(Personnage perso) {
        this.perso = perso;
        vieIni=perso.getHp();
    }

    public void estAttaque(){

    }


}
