package openreport;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import openreport.Screen;

public class SceneController {
    public static Stage mainStage;
    private static final String TEMPLATE_SCREEN = "layouts/scene_template.fxml";
    private static final String MAIN_SCREEN = "layouts/scene_main-menu.fxml";
    
    public static void setStage(Stage stage){
        mainStage = stage;
    }
    public static void openScene(Screen screen)throws IOException{
        Parent root = FXMLLoader.load(OpenReport.class.getResource(getScreenPathFromType(screen)));
        Scene scene = new Scene(root);
        if(mainStage != null){
            mainStage.setScene(scene);
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

