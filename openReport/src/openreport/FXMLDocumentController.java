package openreport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.io.IOException;



public class FXMLDocumentController {

    
    @FXML
    private Button addTitle;
    
    @FXML
    private VBox titleButtonSlot;
    

    @FXML
    void addTitleComponent(ActionEvent event) throws IOException {
        Node componentToAdd = FXMLLoader.load(getClass().getResource("layouts/Components/component_title.fxml"));
        titleButtonSlot.getChildren().add(componentToAdd);
        System.out.println("Button pressed");
    }

}

