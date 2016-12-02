package model;

public class Mesopotamia extends Civilization {
    private Desert desert = new Desert();

    public Mesopotamia() {
        super("Mesopotamia");
    }

    @Override
    public String explore() {
        int gold = desert.findTreasure();
        getTreasury().earn(gold);
        return "You explore the desert and find " + gold + " gold!";
    }

    public Desert getDesert() {
        return desert;
    }


    // This method returns a new HangingGardensOfBabylon
    // which is a Landmark featured in Mesopotamia

    @Override
    public Landmark getLandmark() {
        return new HangingGardensOfBabylon(this);
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

}