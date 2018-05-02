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
import java.util.ArrayList;



public class FXMLDocumentController {

    private ArrayList<String> paths = new ArrayList<>();
    
    private void setPaths() {  
        paths.add(0, "layouts/Components/component_grade-table.fxml");
        paths.add(1, "layouts/Components/component_header.fxml");
        paths.add(2, "layouts/Components/component_plain-text.fxml");
        paths.add(3, "layouts/Components/component_signature.fxml");
        paths.add(4, "layouts/Components/component_simple-table.fxml");
        paths.add(5, "layouts/Components/component_title.fxml");
    } 

    /////* Variáveis FXML */////
    @FXML
    private Button addTitle;
    
    @FXML
    private Button removeTitleButton;
    
    @FXML
    private Button addPageHeader;

    @FXML
    private Button addBody;

    @FXML
    private Button addPageFooter;

    @FXML
    private Button addFooter;

    @FXML
    private VBox titleButtonSlot;
    
    
    /////* Métodos FXML */////
    @FXML
    void addTitleComponent(ActionEvent event) throws IOException {
        //paths.get(index) dá erro aleatório inteligível ao ser printado ou usado
        String tempPath = "layouts/Components/component_title.fxml";
        Node componentToAdd = FXMLLoader.load(getClass().getResource(tempPath));
        titleButtonSlot.getChildren().add(componentToAdd);
    }
    
    @FXML
    void removeTitleComponent(ActionEvent event) throws IOException {
        //titleButtonSlot.getChildren().remove();
        //titleButtonSlot.getChildren().remove(0);
        //titleButtonSlot.getChildren().clear();
    }
    
    
    @FXML
    void addBodyComponent(ActionEvent event) {
    }

    @FXML
    void addFooterComponent(ActionEvent event) {
    }

    @FXML
    void addPageFooterComponent(ActionEvent event) {

    }

    @FXML
    void addPageHeaderComponent(ActionEvent event) {

    }

}

