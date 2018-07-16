package openreport;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SceneController {
    public static Stage mainStage;
    private static final String TEMPLATE_SCREEN = "Template.fxml";
    private static final String MAIN_SCREEN = "MainMenu.fxml";
    
    public static void setStage(Stage stage){
        mainStage = stage;
    }
    public static void openScene(Screen screen)throws IOException{
        Parent root = FXMLLoader.load(OpenReport.class.getResource(getScreenPathFromType(screen)));
        Scene scene = new Scene(root);
        

        if(mainStage != null){
            mainStage.setScene(scene);
            mainStage.setTitle("OpenReport");
            Image image = new Image(OpenReport.class.getResourceAsStream("/images/logo.png"));
            mainStage.getIcons().add(image);
            mainStage.setResizable(false);
            mainStage.show();
        }
    }
    private static String getScreenPathFromType(Screen screen){
        switch(screen){
            case TEMPLATE:
                return TEMPLATE_SCREEN;
            case MAIN:
                return MAIN_SCREEN;
            default:
                return null;
        }
    }
}

