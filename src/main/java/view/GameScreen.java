package view;

import controller.GameController;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Convertable;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private static ResourcesMenu resourcesMenu = new ResourcesMenu();
    private static VBox vbox = new VBox();
    private static AbstractMenu abstractMenu;

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        // LOOK AT THE BORDER PANE AND HOW IT WORKS
        //DO I NEED getRootNode();
        resourcesMenu = getResources();
        abstractMenu = new StatusMenu();


        this.setTop(resourcesMenu.getRootNode());
        this.setCenter(GridFX.getInstance());
        this.setLeft(abstractMenu.getRootNode());

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
          abstractMenu.getRootNode().getChildren().clear();
          new MilitaryMenu();
        } else if (state == GameController.GameState.WORKER) {
          abstractMenu.getRootNode().getChildren().clear();
          new WorkerMenu();
        } else if (state == GameController.GameState.BUILDING) {
          abstractMenu.getRootNode().getChildren().clear();
          new BuildingMenu();
        } else if (state == GameController.GameState.RECRUITING) {
          abstractMenu.getRootNode().getChildren().clear();
          new RecruitMenu();
        } else {
          abstractMenu.getRootNode().getChildren().clear();
          new StatusMenu();
        }
    }
}
