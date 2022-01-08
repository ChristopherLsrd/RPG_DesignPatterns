package main.personnage;

import main.personnage.chest.Chest;
import main.personnage.chest.TShirt;
import main.personnage.hat.AirPods;
import main.personnage.hat.Hat;
import main.personnage.legs.Jean;
import main.personnage.legs.Legs;

public class CreateMage extends CreatePerso{
    @Override
    public Hat addHat() {
        return new AirPods();
    }

    @Override
    public Chest addChest() {
        return new TShirt();
    }

    @Override
    public Legs addLegs() {
        return new Jean();
    }
}
