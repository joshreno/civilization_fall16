package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {

    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {


        attackButton.setOnMousePressed(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
                GameController.getError();

                if (GameController.getError()) {
                    //!((MilitaryUnit) GameController.getLastClicked()
                    // .getTile().getOccupant()).getCanAttack()

                    Alert alert = new Alert(
                        AlertType.ERROR, "Cannot attack", ButtonType.CANCEL);

                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CANCEL) {
                        alert.close();
                    }
                } else {
                    AudioClip attack = new AudioClip(
                        "File:./src/main/java/view/attack.wav");
                    attack.setVolume(0.5);
                    attack.play();
                }

            });

        moveButton.setOnMousePressed(e -> {
                GameController.moving();

                if (GameController.getLastClicked()
                    .getTile().getOccupant() == null) {
                    Alert alert = new Alert(
                        AlertType.ERROR, "Cannot move", ButtonType.CANCEL);

                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CANCEL) {
                        alert.close();
                    }
                } else {
                    AudioClip move = new AudioClip(
                        "File:./src/main/java/view/moving.aif");
                    move.setVolume(0.5);
                    move.play();
                }




            });

        super.addMenuItem((Node) attackButton);
        super.addMenuItem((Node) moveButton);
    }
}
