package model;

public class Landmark extends Building {

    public Landmark(Civilization owner) {
        super(200, owner, 0, 0, 0, 10, 0, 10);
    }

    @Override
    public void invest() {
        super.setTechPointGeneration(super.getTechPointGeneration() + 5);
    }

    @Override
    public char symbol() {
        return '!';
    }

    @Override
    public String toString() {
        return "Farm. " + super.toString();
    }
}