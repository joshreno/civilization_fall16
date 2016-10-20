package model;

public class RangedUnit extends MilitaryUnit {

    public RangedUnit(Civilization civilization) {
        super(100, civilization, 10, 10, 14, 5, 0, 30);
    }

    public char symbol() {
        return 'R';
    }

    @Override
    public String toString() {
        return "Ranged Unit. " + super.toString();
    }

    @Override
    public void battle(MapObject mapObject) {
        super.attack(mapObject);
        mapObject.damage(super.getDamage());
        if (!mapObject.isDestroyed()) {
            if (mapObject instanceof RangedUnit
                || mapObject instanceof HybridUnit) {
                ((MilitaryUnit) mapObject).setCanAttack(true);
            }
        }
    }


}