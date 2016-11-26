package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;




/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        primaryStage.setScene(startGame());
        primaryStage.show();

    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {

        Scene s;
        StartScreen startScreen = new StartScreen();
        s = startScreen;
        CivEnum selectedCiv; //
        ListView<CivEnum> civList = startScreen.getCivList();
        civList.setOnMouseClicked(e -> {
                CivilizationGame.this.selectedCiv
                    = civList.getSelectionModel().getSelectedItem();
            });

        Button start = startScreen.getStartButton();
        String civName; //
        start.setOnMouseClicked(e -> {
                TextInputDialog dialog = new TextInputDialog(
                    "You've built a Settlement. Enter a town name.");
                String s = dialog.showAndWait();
                Civilization.this.civName = s;
            })

        Game game;
        Map gameMap = new Map(10, 10);
        Civilization civilization;

        if (selectedCiv == CivEnum.ROMAN_EMPIRE) {
            civilization = new RomanEmpire();
            game = new Game();
            gameMap.putSettlement(civName, civilization, 0, 0);
        } else if (selectedCiv == CivEnum.QIN_DYNASTY) {
            civilization = new QinDynasty();
            game = new Game();
            gameMap.putSettlement(civName, civilization, 0, 0);
        } else {
            civilization = new Egypt();
            game = new Game();
            gameMap.putSettlement(civName, civilization, 0, 0);
        }

        GameScreen gameScreen = new GameScreen();

        start.setOnMouseClicked(e -> {
                CivilizationGame.this.gameMap.addEnemies(new Bandit(), 1);
                CivilizationGame.this.gameScreen.update();
            });

        s = gameScreen;
        gameScreen.update();








    }




}
