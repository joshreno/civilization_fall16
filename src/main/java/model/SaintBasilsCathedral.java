package model;
import javafx.scene.image.Image;

class SaintBasilsCathedral extends Landmark {

    public SaintBasilsCathedral(Civilization owner) {
        super(owner);
    }


    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(25);
    }

    @Override
    public String toString() {
        return "Saint Basil's Cathedral" + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/cathedral.PNG");
    }
}