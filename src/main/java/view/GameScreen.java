package view;

import controller.GameController;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private static ResourcesMenu resourcesMenu = new ResourcesMenu();
    private static VBox vbox = new VBox();
    private static AbstractMenu actionMenu = new AbstractMenu();

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        super.setStyle("-fx-background-color: #f4f142;");
        resourcesMenu = getResources();

        vbox.getChildren().addAll(actionMenu.getRootNode());

        this.setTop(resourcesMenu.getRootNode());
        this.setCenter(GridFX.getInstance());
        this.setLeft(new AbstractMenu().getRootNode());

            //other action menu
            // other stuff - action menu
            // .getRootNode()
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        getResources().update();
        this.setTop(resourcesMenu.getRootNode());
        this.setLeft(vbox);
      // resources update?
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourcesMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        if (state == GameController.GameState.MILITARY) {
          // actionMenu.getRootNode().getChildren().clear();
            vbox.getChildren().clear();
            actionMenu = new MilitaryMenu();
            vbox.getChildren().addAll(actionMenu.getRootNode());

        } else if (state == GameController.GameState.WORKER) {
          // actionMenu.getRootNode().getChildren().clear();
            vbox.getChildren().clear();
            actionMenu = new WorkerMenu();
            vbox.getChildren().addAll(actionMenu.getRootNode());
        } else if (state == GameController.GameState.BUILDING) {
          // actionMenu.getRootNode().getChildren().clear();
            vbox.getChildren().clear();
            actionMenu = new BuildingMenu();
            vbox.getChildren().addAll(actionMenu.getRootNode());
        } else if (state == GameController.GameState.RECRUITING) {
          // actionMenu.getRootNode().getChildren().clear();
            vbox.getChildren().clear();
            actionMenu = new RecruitMenu();
            vbox.getChildren().addAll(actionMenu.getRootNode());
        } else {
          // actionMenu.getRootNode().getChildren().clear();
            vbox.getChildren().clear();
            actionMenu = new StatusMenu();
            vbox.getChildren().addAll(actionMenu.getRootNode());
        }
        getResources().update();
    }
}
