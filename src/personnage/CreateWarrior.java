package personnage;

import personnage.chest.Chest;
import personnage.chest.ChestPlate;
import personnage.hat.Hat;
import personnage.hat.Helmet;
import personnage.legs.ArmorLegs;
import personnage.legs.Legs;

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
        return new ArmorLegs();
    }
}
