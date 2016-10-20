package model;

abstract class MilitaryUnit extends Unit {
    // ??? -> instance variables
    private int initialHappinessCost;
    private int damage;


    public MilitaryUnit(int health, Civilization civilization,
        int baseEndurance, int pay, int initialGoldCost,
        int initialFoodCost, int initialResourceCost, int damage) {

        super(health, civilization, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        this.initialHappinessCost = 10;
        this.damage = damage;


    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void tick() {
        super.tick();
        super.setCanAttack(true);
    }

    public abstract void battle(MapObject mapObject);

    public void attack(MapObject mapObject) {
        super.getOwner().getStrategy().battle();
        battle(mapObject);
        super.setCanAttack(false);

    }

    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }


}