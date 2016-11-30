package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import view.TerrainTileFX;
import model.TerrainTile;
import model.MapObject;
import model.Civilization;
import model.Settlement;
import javafx.scene.control.Button;
import javafx.scene.Node;

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
                    .getTile().getOccupant().getOwner().getNumSettlements() > 1) {
                    if (GameController.getLastClicked()
                    .getTile().getOccupant() instanceof Settlement) {
                        GameController.getLastClicked()
                    .getTile().getOccupant().getOwner().getSettlement("a").
                    demolish();
                    }
                }
            });

        investButton.setOnMousePressed(e -> {
                MapObject o = GameController.getLastClicked()
                .getTile().getOccupant();

                if (o.getOwner().getTreasury().spend(25)) {
                    o.getOwner().getSettlement("a").invest();
                }
            });

        super.addMenuItem((Node) demolishButton);
        super.addMenuItem((Node) investButton);

    }
}
