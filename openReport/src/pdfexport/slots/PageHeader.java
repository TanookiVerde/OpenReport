package pdfexport.slots;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import pdfexport.*;
import pdfexport.components.Header;

public class PageHeader implements ISlot {
    private final int maxComponentNumber = 3;
    
    @FXML
    private VBox componentGrid;
    
    @Override
    public void addTitle(ActionEvent event) {
    }
    @Override
    public void addHeader(ActionEvent event) {
    }
    @Override
    public void addSprite(ActionEvent event) {
    }
    @Override
    public void addSignature(ActionEvent event) {
    }
    @Override
    public void addSimpleTable(ActionEvent event) {
    }
    @Override
    public void addText(ActionEvent event) {
    }  
}
