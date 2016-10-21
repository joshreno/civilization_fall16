package model;

public class WarChariot extends RangedUnit {

    public WarChariot(Civilization civilization) {
        super(civilization);

    }

    @Override
    public char symbol() {
        return 'W';
    }

    @Override
    public void battle(MapObject mapObject) {

        mapObject.damage(((MilitaryUnit) mapObject).getDamage());
        if (!mapObject.isDestroyed()) {
            if (mapObject instanceof MeleeUnit) {
                this.damage(((MeleeUnit) mapObject).getDamage());
            }
        }
    }



    @Override
    public String toString() {
        return "War Chariot. " + super.toString();
    }


}