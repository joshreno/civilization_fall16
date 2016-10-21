package model;

public class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization civilization) {
        super(civilization);
        super.setDamage((int) 1.5 * (super.getDamage()));

    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public void battle(MapObject mapObject) {

        mapObject.damage(((MilitaryUnit) mapObject).getDamage());
        super.setCanAttack(false);
        if (!mapObject.isDestroyed()) {
            if (mapObject instanceof MeleeUnit) {

                this.damage(((MilitaryUnit) mapObject).getDamage());

            }
        }

    }



    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }



}