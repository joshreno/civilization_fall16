package model;

class Egypt extends Civilization {


    private Desert desert = new Desert();

    public Egypt() {
        super("Egypt");
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int amt = desert.findTreasure();
        super.getTreasury().earn(amt);
        return "You explore the desert and find " + amt + " gold!";
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }


}
