package model;

public class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization civilization) {
        super(civilization);  // wrong or right?

    }

    @Override
    public char symbol() {
        return 'B';
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
        return "Black Powder Unit. " + super.toString();
    }

}