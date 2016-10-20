package model;

public class SettlerUnit extends Unit implements Convertable {

    private String townName;

    public SettlerUnit(Civilization owner, String townName) {
        super(owner);
        this.townName = townName;
    }

    public char symbol() {
        return 's';
    }

    public Building convert() {
        super.getOwner().incrementNumSettlements();
        return super.getOwner().getSettlement(townName);
    }

    public boolean canConvert(TileType type) {
        return (type == TileType.PLAINS);

    }

    public String toString() {
        return "Settlers of " + townName + ". " + super.toString();
    }
}