package openreport;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenu {
    @FXML
    private void newReport(ActionEvent event){
        try{
            SceneController.openScene(Screen.TEMPLATE);
        }catch(IOException i){
        }
    }
    @FXML
    private void loadReport(ActionEvent event){
        try{
            SceneController.openScene(Screen.TEMPLATE);
        }catch(IOException i){
        }
    }
    @FXML
    private void help(ActionEvent event){
        System.out.println("HELP");
    }
}
