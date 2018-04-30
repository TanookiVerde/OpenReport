package openreport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    Button addButton;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Added element");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addButton.setOnAction((ActionEvent event) -> {
            System.out.println("Button pressed");
        });
       
    }  
}
