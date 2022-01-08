package main.personnage;

import main.personnage.chest.Chest;
import main.personnage.legs.Legs;
import main.personnage.hat.Hat;

public abstract class CreatePerso  {
    public abstract Hat addHat();
    public abstract Chest addChest();
    public abstract Legs addLegs();
}
