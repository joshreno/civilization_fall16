package model;

class RomanEmpire extends Civilization {

    private Hills hills = new Hills();

    public RomanEmpire() {
        super("Roman Empire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int amt = hills.mineCoal();
        super.produceResources(amt);
        return "You mine the hills and find " + amt + " resources!";
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }

}
