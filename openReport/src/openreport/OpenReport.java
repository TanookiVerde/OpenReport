package openreport;

import javafx.application.Application;
import javafx.stage.Stage;

public class OpenReport extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneController.setStage(stage);
        SceneController.openScene(Screen.TEMPLATE);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
