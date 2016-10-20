package model;

public class Coliseum extends Landmark {

    public Coliseum(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.getOwner().increaseHappiness(50);
    }
}