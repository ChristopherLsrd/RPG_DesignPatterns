package main.personnage;

public class Spell {
    private int manaCost;
    private float probability;
    private String description;

    public Spell(int manaCost, float probability, String description) {
        this.manaCost = manaCost;
        this.probability = probability;
        this.description = description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

