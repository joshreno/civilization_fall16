package view;

import controller.GameController;
import model.Convertable;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.Node;

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

                ((Convertable) (tile1.getOccupant()))
                .canConvert(tile1.getType());
            });


        moveButton.setOnMousePressed(e -> {
                GameController.moving();
            });

        super.addMenuItem((Node) convertButton);
        super.addMenuItem((Node) moveButton);
    }
}
