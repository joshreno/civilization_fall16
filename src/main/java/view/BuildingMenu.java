package view;

import controller.GameController;
import model.Settlement;
import model.MapObject;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {

    private Button demolishButton = new Button("Demolish");
    private Button investButton = new Button("Invest");
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        demolishButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked()
                    .getTile().getOccupant()
                    .getOwner().getNumSettlements() > 1) {
                    if (GameController.getLastClicked()
                        .getTile().getOccupant() instanceof Settlement) {
                        GameController.getLastClicked()
                        .getTile().getOccupant().getOwner().getSettlement("a")
                            .demolish();
                        GameController.getLastClicked()
                        .getTile().setOccupant(null);

                        AudioClip demolish = new AudioClip(
                            "File:./src/main/java/view/explosion.wav");
                        demolish.setVolume(0.3);
                        demolish.play();
                    } else {
                        Alert alert = new Alert(
                            AlertType.ERROR,
                            "Not an instance of Settlement", ButtonType.CANCEL);

                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CANCEL) {
                            alert.close();
                        }
                    }

                } else {
                    Alert otherAlert = new Alert(
                        AlertType.ERROR,
                        "Need more settlements", ButtonType.CANCEL);

                    otherAlert.showAndWait();
                    if (otherAlert.getResult() == ButtonType.CANCEL) {
                        otherAlert.close();
                    }
                }

            });

        investButton.setOnMousePressed(e -> {
                MapObject o = GameController.getLastClicked()
                    .getTile().getOccupant();

                if (o.getOwner().getTreasury().spend(25)) {
                    o.getOwner().getSettlement("a").invest();

                    AudioClip invest = new AudioClip(
                        "File:./src/main/java/view/money.wav");
                    invest.play();

                } else {
                    Alert investAlert = new Alert(
                        AlertType.ERROR,
                        "Don't have enough money", ButtonType.CANCEL);

                    investAlert.showAndWait();
                    if (investAlert.getResult() == ButtonType.CANCEL) {
                        investAlert.close();
                    }
                }
                GameController.updateResourcesBar();
            });

        super.addMenuItem((Node) demolishButton);
        super.addMenuItem((Node) investButton);

    }
}
