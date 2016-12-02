package model;

public class RussianEmpire extends Civilization {
    private Hills hills = new Hills();

    public RussianEmpire() {
        super("Russian Empire");
    }

    @Override
    public String explore() {
        int food = hills.hunt().getHealth();
        hills.replenishGame();
        makeFood(food);
        return "COMRADE! You go hunting and get " + food + " food!";
    }

    public Hills getHills() {
        return hills;
    }


    // This method returns a new Cathedral
    // which is a Landmark featured in the Russian Empire

    @Override
    public Landmark getLandmark() {
        return new SaintBasilsCathedral(this);
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }
}