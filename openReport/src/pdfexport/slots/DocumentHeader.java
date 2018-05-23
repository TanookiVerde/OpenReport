package pdfexport.slots;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.*;

public class DocumentHeader implements ISlot {
    private final int maxComponentNumber = 3;
    
    public static String slotPath = "/pdfexport/slots/DocumentHeader.fxml";
    
    @FXML
    private VBox componentGrid;
    
    @Override
    public void addTitle(ActionEvent event) {
        Title t;
        try{
            FXMLLoader l = new FXMLLoader();
            Parent p = l.load(
                    Template.class.getResource(Title.fxmlPath)
            );
            componentGrid.getChildren().add(p);
            t = l.getController();
            t.setComponentInformation(
                    componentGrid, 
                    componentGrid.getChildren().indexOf(p), 
                    Template.template.title
            );
            Template.template.title.add(t);
        }catch(IOException i){
            System.out.println("ERRO: "+i.getMessage());
        }
    }
    @Override
    public void addHeader(ActionEvent event) {
        Header h;
        try{
            FXMLLoader l = new FXMLLoader();
            Parent p = l.load(
                    Template.class.getResource(Header.fxmlPath)
            );
            componentGrid.getChildren().add(p);
            h = l.getController();
            h.setComponentInformation(
                    componentGrid, 
                    componentGrid.getChildren().indexOf(p), 
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
