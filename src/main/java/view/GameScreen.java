package view;

import controller.GameController;

import javafx.scene.layout.BorderPane;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {


    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        // LOOK AT THE BORDER PANE AND HOW IT WORKS
        //DO I NEED getRootNode();
        this.setTop(getResources().getRootNode());
        this.setCenter(GridFX.getInstance());
        this.setLeft(new StatusMenu().getRootNode());

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
        return new ResourcesMenu();
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        if (state == GameController.GameState.MILITARY) {

        } else if (state == GameController.GameState.WORKER) {

        } else if (state == GameController.GameState.BUILDING) {

        } else if (state == GameController.GameState.RECRUITING) {

        } else if (state == GameController.GameState.ATTACKING) {

        } else if (state == GameController.GameState.MOVING) {

        } else {
        // GameState.NEUTRAL
        }
    }
}
