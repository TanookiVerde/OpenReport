package pdfexport.slots;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.*;

public class PageHeader implements ISlot {
    
    public final static int MAX_COMPONENT_NUMBER    = 3;
    public final static String SLOT_PATH            = "/pdfexport/slots/PageHeader.fxml";
    
    @FXML
    private VBox componentGrid;
    
    @Override
    public void addTitle(ActionEvent event) {
        if(componentGrid.getChildren().size() + 1 > MAX_COMPONENT_NUMBER) {
            return;
        }
        try{
            FXMLLoader loader = new FXMLLoader(Template.class.getResource(Title.FXML_PATH));
            Parent newNode = (Parent) loader.load();
            Title component = loader.getController();
            
            componentGrid.getChildren().add(newNode);
            
            component.setComponentInformation(
                    componentGrid, 
                    newNode, 
                    Template.template.pageheader
            );
            
            Template.template.pageheader.add(component);
        }catch(Exception i){
            System.out.println(i.getMessage());
            System.out.println(i.getStackTrace());
        }
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
