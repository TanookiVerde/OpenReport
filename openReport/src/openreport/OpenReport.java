package openreport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pdfexport.*;
import openreport.database.*;

public class OpenReport extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(OpenReport.class.getResource("layouts/scene_template.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("OpenReport");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        //DatabaseManager.main(args);
        launch(args);
    }
}
