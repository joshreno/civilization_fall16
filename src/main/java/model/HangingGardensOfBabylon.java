package model;
import javafx.scene.image.Image;

class HangingGardensOfBabylon extends Landmark{

    public HangingGardensOfBabylon(Civilization owner) {
        super(owner);
    }


    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }

    @Override
    public String toString() {
        return "Hanging Gardens of Babylon" + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/asian_temple.svg.PNG");
        }
}