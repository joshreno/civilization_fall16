package model;

public class BritishEmpire extends Civilization {
    private Hills hills = new Hills();

    public BritishEmpire() {
        super("British Empire");
    }

    @Override
    public String explore() {
        int food = hills.hunt().getHealth();
        hills.replenishGame();
        makeFood(food);
        return "King! You go hunting and get " + food + " food!";
    }

    public Hills getHills() {
        return hills;
    }

    // This method returns a new BuckinghamPalace
    // which is a Landmark featured in the British Empire

    @Override
    public Landmark getLandmark() {
        return new BuckinghamPalace(this);
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }
}