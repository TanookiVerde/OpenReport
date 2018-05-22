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
import pdfexport.*;

public class CustomizationMenuController {
    /////* Variáveis FXML */////
    @FXML
    private VBox titleButtonSlot;
    
    private Template template = new Template();
    
    /////* Métodos FXML */////
    @FXML
    void addTitleComponent(ActionEvent event) throws IOException {
        c_Header h = new c_Header("a","a","a","a","a","a","a");
        template.title.add(h);
        h.addComponent(titleButtonSlot);
    }
    @FXML
    void removeTitleComponent(ActionEvent event) throws IOException {
        template.title.get(0).deleteComponent();
        template.title.remove(0);
    }
}