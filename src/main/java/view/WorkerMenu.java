package view;

import controller.GameController;
import model.Convertable;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;




/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    private Button convertButton = new Button("Convert");
    private Button moveButton = new Button("Move");

    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        convertButton.setOnMousePressed(e -> {
                TerrainTileFX tile = GameController.getLastClicked();
                TerrainTile tile1 = tile.getTile();



                if (((Convertable) (tile1.getOccupant())).canConvert(tile1.getType())) {
                        tile1.setOccupant(((Convertable) (tile1.getOccupant())).convert());

                        AudioClip convert = new AudioClip("File:./src/main/java/view/convert.wav");
                        convert.setVolume(0.5);
                        convert.play();

                } else {
                    Alert alert = new Alert
                    (AlertType.ERROR, "Cannot convert", ButtonType.CANCEL);

                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CANCEL) {
                        alert.close();
                    }
                }

            });


        moveButton.setOnMousePressed(e -> {
                GameController.moving();

                if (GameController.getLastClicked().getTile().getOccupant() == null) {
                    Alert alert = new Alert
                    (AlertType.ERROR, "Cannot move", ButtonType.CANCEL);

                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CANCEL) {
                        alert.close();
                    }
                } else {
                    AudioClip move = new AudioClip("File:./src/main/java/view/moving.aif");
                    move.setVolume(0.5);
                    move.play();
                }
            });

        GameController.updateResourcesBar();

        super.addMenuItem((Node) convertButton);
        super.addMenuItem((Node) moveButton);
    }
}
