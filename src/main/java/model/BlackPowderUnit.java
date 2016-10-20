package model;

public class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit (Civilization civilization) {
        super(civilization);
        super.setDamage((int) 1.5*(super.getDamage())); // wrong or right?

    }

    @Override
    public char symbol() {
        return 'B';
    }

    @Override
    public void battle(MapObject mapObject) {

        // mapObject.damage(super.getDamage());
        // if (!mapObject.isDestroyed()) {
        //     if (mapObject instanceof MeleeUnit) {
        //         ((MeleeUnit) mapObject).setCanAttack(true);
        //     }
        // }
        // how do i implement being attacked and such
    }



    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }

}