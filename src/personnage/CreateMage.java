package personnage;

import personnage.chest.Chest;
import personnage.chest.TShirt;
import personnage.hat.AirPods;
import personnage.hat.Hat;
import personnage.legs.Jean;
import personnage.legs.Legs;

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
