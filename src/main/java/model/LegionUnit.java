package model;

public class LegionUnit extends MeleeUnit {

    public LegionUnit (Civilization civilization) {
        super(civilization);
        super.setDamage((int) 1.5*(super.getDamage()));

    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public void battle(MapObject mapObject) {

        mapObject.damage(super.getDamage());
        super.setCanAttack(false);
        if (!mapObject.isDestroyed()) {
            if (mapObject instanceof MeleeUnit) {

                //(super.damage(((MilitaryUnit) mapObject).getDamage()));
                mapObject.damage(super.getDamage());

            }
        }

    }



    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }



}