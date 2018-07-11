package openreport;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

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
        Alert window = new Alert(Alert.AlertType.WARNING);
        window.setTitle("Ação Inválida");
        window.setContentText("DLC disponível por 9.99 na Microsoft App Store");
        window.show();
    }
    @FXML
    private void help(ActionEvent event){
        Alert window = new Alert(Alert.AlertType.WARNING);
        window.setTitle("Ação Inválida");
        window.setContentText("DLC disponível por 9.99 na Microsoft App Store");
        window.show();
    }
}
