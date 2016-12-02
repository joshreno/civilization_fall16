package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.BritishEmpire;
import model.RussianEmpire;
import model.Mesopotamia;
import model.Bandit;
import view.GridFX;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Map map = GridFX.getMap();
    private CivEnum selectedCiv;
    private String settlementName;
    private StartScreen startScreen = new StartScreen();
    private static GameScreen gameScreen;
    private Scene s;
    private Stage stage;


    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {

        stage = primaryStage;
        stage.setScene(startGame());
        stage.show();
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static GameScreen getGameScreen() {
        return gameScreen;
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */
    public Scene startGame() {


        startScreen.getStartButton().setOnMouseClicked((t) -> {



                startScreen.getImageView().setOpacity(0.8);

                TextInputDialog dialog = new TextInputDialog("name");
                dialog.setTitle("Text Input Dialog");
                dialog.setContentText("Enter a name");
                String string = dialog.showAndWait().toString();
                settlementName = string;

                Alert alert = new Alert(AlertType.INFORMATION,
                    "Welcom to Civilization. "
                        + "Note: The resource bar updates "
                        + "after you click the next tile. Also,"
                        + "if you convert a tile, the image of the "
                        + "new tile appears after you click the "
                        + "next tile. Thanks for playing!", ButtonType.CANCEL);

                alert.showAndWait();
                if (alert.getResult() == ButtonType.CANCEL) {
                    alert.close();
                }

                selectedCiv = startScreen
                .getCivList().getSelectionModel().getSelectedItem();

                if (selectedCiv == CivEnum.ROMAN_EMPIRE) {
                    GameController.setCivilization(new RomanEmpire());
                } else if (selectedCiv == CivEnum.QIN_DYNASTY) {
                    GameController.setCivilization(new QinDynasty());
                } else if (selectedCiv == CivEnum.ANCIENT_EGYPT) {
                    GameController.setCivilization(new Egypt());
                } else if (selectedCiv == CivEnum.BRITISH_EMPIRE) {
                    GameController.setCivilization(new BritishEmpire());
                } else if (selectedCiv == CivEnum.MESOPOTAMIA) {
                    GameController.setCivilization(new Mesopotamia());
                } else if (selectedCiv == CivEnum.RUSSIAN_EMPIRE) {
                    GameController.setCivilization(new RussianEmpire());
                } else {
                    GameController.setCivilization(new Egypt());
                    // this is if they fail to select a civilization
                }

                map.addEnemies(new Bandit(), 1);
                map.putSettlement(settlementName,
                    GameController.getCivilization(), 0, 9);
                gameScreen = new GameScreen();
                gameScreen.update();
                s = new Scene(gameScreen);
                stage.setScene(s);
                stage.show();

            });
        s = new Scene(startScreen);
        return s;
    }
}
