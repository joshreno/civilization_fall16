package model;
import javafx.scene.image.Image;

class BuckinghamPalace extends Landmark {

    public BuckinghamPalace(Civilization owner) {
        super(owner);
    }


    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(25);
    }

    @Override
    public String toString() {
        return "Buckingham Palace" + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/temple.PNG");
    }
}