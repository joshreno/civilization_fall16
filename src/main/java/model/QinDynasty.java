package model;

class QinDynasty extends Civilization {

    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int amt;
        if (hills.replenishGame()) {
            amt = hills.hunt().getHealth();
            super.makeFood(amt);
        } else {
            amt = hills.hunt().getHealth();
            super.makeFood(amt);
        }
        return "You mine the hills and find " + amt + " food for your supply!";
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }

}
