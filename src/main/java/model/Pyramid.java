package model;

public class Pyramid extends Landmark {

    public Pyramid(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.getOwner().getTechnology().philosophize();
    }
}