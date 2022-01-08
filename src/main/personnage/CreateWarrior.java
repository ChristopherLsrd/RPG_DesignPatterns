package main.personnage;

import main.personnage.chest.Chest;
import main.personnage.chest.ChestPlate;
import main.personnage.hat.Hat;
import main.personnage.hat.Helmet;
import main.personnage.legs.ArmorLegs;
import main.personnage.legs.Legs;

public class CreateWarrior extends CreatePerso {
    @Override
    public Hat addHat() {
        return new Helmet();
    }

    @Override
    public Chest addChest() {
        return new ChestPlate();
    }

    @Override
    public Legs addLegs() {
        return new ArmorLegs();}


}
