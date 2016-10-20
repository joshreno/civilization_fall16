package model;

public class MasterBuilderUnit extends Unit implements Convertable {

    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    public char symbol() {
        return 'm';
    }

    public Building convert() {
        return super.getOwner().getLandmark();
    }

    public boolean canConvert(TileType type) {
        return (type == TileType.PLAINS);

    }
}