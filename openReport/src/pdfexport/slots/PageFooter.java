package pdfexport.slots;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class PageFooter implements ISlot{
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
