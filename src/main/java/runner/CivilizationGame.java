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
import view.GridFX;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Map map = GridFX.getMap();
    private CivEnum selectedCiv;
    private String settlementName;
    private StartScreen startScreen = new StartScreen();
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
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */
    public Scene startGame() {
        startScreen.getStartButton().setOnMouseClicked((t) -> {

                TextInputDialog dialog = new TextInputDialog("name");
                dialog.setTitle("Text Input Dialog");
                dialog.setContentText("Enter a name");
                String string = dialog.showAndWait().toString();
                settlementName = string;

                // Button cancel = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
                // cancel.addEventFilter(ActionEvent.ACTION, event ->
                //         System.out.println("Cancel was definitely pressed")
                //     ); // do this

                selectedCiv = startScreen
                .getCivList().getSelectionModel().getSelectedItem();

                if (selectedCiv == CivEnum.ROMAN_EMPIRE) {
                    GameController.setCivilization(new RomanEmpire());
                    System.out.println("Roman Emp");
                } else if (selectedCiv == CivEnum.QIN_DYNASTY) {
                    GameController.setCivilization(new QinDynasty());
                    System.out.println("Civ");
                } else if (selectedCiv == CivEnum.ANCIENT_EGYPT){
                    GameController.setCivilization(new Egypt());
                    System.out.println("civilization");
                } else {
                }

                map.addEnemies(new Bandit(), 1);
                map.putSettlement(settlementName,
                    GameController.getCivilization(), 1, 1);
                GameScreen gameScreen = new GameScreen();
                gameScreen.update();
                s = new Scene(gameScreen);
                stage.setScene(s);
                stage.show();

            });
        s = new Scene(startScreen);
        return s;
    }
}
