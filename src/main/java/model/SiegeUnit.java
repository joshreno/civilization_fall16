package model;

public class SiegeUnit extends MilitaryUnit {

    public SiegeUnit(Civilization civilization) {
        super(200, civilization, 5, 10, 14, 5, 10, 60);
    }

    public char symbol() {
        return 'S';
    }

    @Override
    public String toString() {
        return "Sieged Unit. " + super.toString();
    }

    @Override
    public void battle(MapObject mapObject) {
        if (mapObject instanceof Building) {
            mapObject.damage(super.getDamage());
        }
    }

    @Override
    public void attack(MapObject mapObject) {
        super.getOwner().getStrategy().siege();
        battle(mapObject);
        super.setCanAttack(false);
    }
}