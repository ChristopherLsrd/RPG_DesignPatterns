package personnage;

import personnage.chest.Chest;
import personnage.hat.Hat;
import personnage.legs.Legs;

public abstract class CreatePerso  {
    public abstract Hat addHat();
    public abstract Chest addChest();
    public abstract Legs addLegs();
}
