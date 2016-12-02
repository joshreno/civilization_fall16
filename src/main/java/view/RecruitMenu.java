package view;

import controller.GameController;
import model.Civilization;
import model.Unit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;




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
        workerListView.setMaxHeight(250);
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
                if (GameController.getCivilization().getMeleeUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Ranged Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getRangedUnit());
                if (GameController.getCivilization().getRangedUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Hybrid Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getHybridUnit());
                if (GameController.getCivilization().getHybridUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Siege Unit": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getSiegeUnit());
                if (GameController.getCivilization().getSiegeUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Settlers": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getSettlerUnit("a"));
                if (GameController.getCivilization().getSettlerUnit("a").isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Farmers": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getFarmerUnit());

                if (GameController.getCivilization().getFarmerUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Coal Miners": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getCoalMinerUnit());
                if (GameController.getCivilization().getCoalMinerUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Anglers": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getAnglerUnit());
                if (GameController.getCivilization().getAnglerUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                case "Master Builders": GameController.getLastClicked()
                .getTile().setOccupant(GameController.getCivilization().getMasterBuilderUnit());
                if (GameController.getCivilization().getMasterBuilderUnit().isAffordable()){
                ((Unit) GameController.getLastClicked().getTile().getOccupant()).applyInitialCosts();
                }
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
                break;

                default:
                    Alert alert = new Alert
                    (AlertType.ERROR, "Action cannot occur", ButtonType.CANCEL);

                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CANCEL) {
                        alert.close();
                    }
                    break;
            }

            AudioClip newInvest = new AudioClip("File:./src/main/java/view/money.wav");
            newInvest.play();

        });

        super.addMenuItem((Node) selectButton);
        super.addMenuItem((Node) workerListView);



    }
}
