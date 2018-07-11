package openreport;

import javafx.application.Application;
import javafx.stage.Stage;
import openreport.database.DatabaseManager;

public class OpenReport extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneController.setStage(stage);
        SceneController.openScene(Screen.MAIN);
    }
    public static void main(String[] args) {
        DatabaseManager.main(args);
        launch(args);
    }
}
