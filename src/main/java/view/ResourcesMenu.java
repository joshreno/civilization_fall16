package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

import javafx.scene.control.Label;

public class ResourcesMenu {
    private int stratLevel;
    private int resources;
    private int settlements;
    private int money;
    private int food;
    private int happiness;
    HBox hbox = new HBox(15);

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        stratLevel = GameController.getCivilization().getStrategy().getStrategyLevel();
        resources = GameController.getCivilization().getResources();
        settlements = GameController.getCivilization().getNumSettlements();
        money = GameController.getCivilization().getTreasury().getCoins();
        food = GameController.getCivilization().getFood();
        happiness = GameController.getCivilization().getHappiness();

        //TODO
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        stratLevel = GameController.getCivilization().getStrategy().getStrategyLevel();
        resources = GameController.getCivilization().getResources();
        settlements = GameController.getCivilization().getNumSettlements();
        money = GameController.getCivilization().getTreasury().getCoins();
        food = GameController.getCivilization().getFood();
        happiness = GameController.getCivilization().getHappiness();
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        hbox.getChildren().clear();

        Label stratLabel = new Label("Strat Level: " + stratLevel);
        Label resourcesLabel = new Label("Resources: " + resources);
        Label settleLabel = new Label("Settlements: " + settlements);
        Label moneyLabel = new Label("Money: " + money);
        Label foodLabel = new Label("Food: " + food);
        Label happyLabel = new Label("Happiness: " + happiness);

        hbox.getChildren().addAll(stratLabel, resourcesLabel, settleLabel, moneyLabel, foodLabel, happyLabel);
        return hbox;

    }
}