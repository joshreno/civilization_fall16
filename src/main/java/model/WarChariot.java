package model;

public class WarChariot extends RangedUnit {

    public WarChariot (Civilization civilization) {
        super(civilization);

    }

    @Override
    public char symbol() {
        return 'W';
    }

    @Override
    public void battle(MapObject mapObject) {

        mapObject.damage(super.getDamage());
        if (!mapObject.isDestroyed()) {
            if (mapObject instanceof MeleeUnit) {
                ((MeleeUnit) mapObject).setCanAttack(true);
            }
        }
    }



    @Override
    public String toString() {
        return "War Chariot. " + super.toString();
    }


}