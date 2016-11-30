package view;

import controller.GameController;
import model.Civilization;
import model.Unit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.Node;
import javafx.scene.control.Button;



/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {

    private ListView<String> workerListView = new ListView<>();
    private Button selectButton = new Button("Select");
    private String selected;

    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        ObservableList<String> workerList = FXCollections.observableArrayList(
            "Melee Unit",
            "Ranged Unit",
            "Hybrid Unit",
            "Siege Unit",
            "Settlers",
            "Farmers",
            "Coal Miners",
            "Anglers",
            "Master Builders");

        workerListView.setItems(workerList);


        selectButton.setOnMousePressed(e -> {
            selected = workerListView.getSelectionModel().getSelectedItem();

            switch (selected) {
                case "Melee Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getMeleeUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Ranged Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getRangedUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Hybrid Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getHybridUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Siege Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getSiegeUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Settlers": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getSettlerUnit("a"));
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Farmers": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getFarmerUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Coal Miners": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getCoalMinerUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Anglers": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getAnglerUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Master Builders": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getMasterBuilderUnit());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                default: //alert action box
            }

        });



    }
}
