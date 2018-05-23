package pdfexport.slots;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.Header;

public class DocumentHeader implements ISlot {
    private final int maxComponentNumber = 3;
    
    public static String slotPath = "/pdfexport/slots/DocumentHeader.fxml";
    
    @FXML
    private VBox componentGrid;
    
    @Override
    public void addTitle(ActionEvent event) {
    }
    @Override
    public void addHeader(ActionEvent event) {
        Header h;
        try{
            FXMLLoader l = new FXMLLoader();
            l.setController(new Header());
            Node n = l.load(
                    Template.class.getResource(Header.fxmlPath)
            );
            componentGrid.getChildren().add(n);
            h = l.getController();
            h.setComponentInformation(
                    componentGrid, 
                    componentGrid.getChildren().indexOf(n), 
                    Template.template.title
            );
            Template.template.title.add(h);
        }catch(IOException i){
            System.out.println("ERRO: "+i.getMessage());
        }
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
