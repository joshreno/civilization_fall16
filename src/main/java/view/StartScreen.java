package view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;



/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Button button = new Button("start");
    private ListView<CivEnum> civList = new ListView<>();
    private ImageView background = new ImageView();

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        Image newImage = new Image(
            "File:./src/main/java/view/ok.png");

        button = new Button("Start", new ImageView(newImage));
        super.setStyle("-fx-background-color: #f4f142;");

        AudioClip cool = new AudioClip(
            "File:./src/main/java/runner/videoplayback-10.mp4");
        cool.play();

        Image image = new Image(
            "File:./src/main/java/view/civ_background.png");
        background.setImage(image);
        background.setOpacity(1);


        this.getChildren().addAll(background,
            getCivList(), getStartButton());
        getStartButton().setTranslateX(-100);
        getCivList().setTranslateX(100);

    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return button;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        ObservableList<CivEnum> list = FXCollections.observableArrayList(
            CivEnum.ANCIENT_EGYPT,
            CivEnum.QIN_DYNASTY,
            CivEnum.ROMAN_EMPIRE,
            CivEnum.MESOPOTAMIA,
            CivEnum.BRITISH_EMPIRE,
            CivEnum.RUSSIAN_EMPIRE);
        civList.setItems(list);
        civList.setMinHeight(100);
        civList.setMaxHeight(100);
        civList.setMaxWidth(200);
        return civList;
    }

    public ImageView getImageView() {
        return background;
    }
}