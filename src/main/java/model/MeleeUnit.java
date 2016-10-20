package model;

public class MeleeUnit extends MilitaryUnit {

    public MeleeUnit(Civilization civilization) {
        super(100, civilization, 10, 10, 14, 5, 0, 30);
    }

    public char symbol() {
        return 'M';
    }

    @Override
    public String toString() {
        return "Melee Unit. " + super.toString();
    }

    @Override
    public void battle(MapObject mapObject) {

        mapObject.damage(super.getDamage());
        if (!mapObject.isDestroyed()) {
            if (mapObject instanceof MeleeUnit
                || mapObject instanceof HybridUnit) {
                ((MilitaryUnit) mapObject).setCanAttack(true); // caste this first, deal damage to melee unit -> this.damage(mapObject.damage)
            }
        }
    }



}