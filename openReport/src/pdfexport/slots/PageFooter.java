package pdfexport.slots;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.*;
import static pdfexport.slots.ISlot.AddComponent;

public class PageFooter implements ISlot {
    
    public final int MAX_COMPONENT_NUMBER           = 1;
    public final static String SLOT_PATH            = "/pdfexport/slots/PageFooter.fxml";
    
    @FXML
    private VBox componentGrid;
    
    @Override
    public void addTitle(ActionEvent event) {
        AddComponent(new Title(),this);
    }

    @Override
    public void addHeader(ActionEvent event) {
    }

    @Override
    public void addSprite(ActionEvent event) {
        AddComponent(new Sprite(),this);
    }

    @Override
    public void addSignature(ActionEvent event) {
        AddComponent(new Signature(),this);
    }

    @Override
    public void addText(ActionEvent event) {
        AddComponent(new Text(),this);
    }
    
    @Override
    public void addGradeTable(ActionEvent event) {
    }

    @Override
    public void addListing(ActionEvent event) {
    }
    
    @Override
    public VBox getComponentGrid(){
        return componentGrid;
    }
    
    @Override
    public List<IComponent> getComponentList(){
        return Template.template.pageFooter;
    }
    
    @Override
    public int getMaxComponentNumber(){
        return MAX_COMPONENT_NUMBER;
    }
}
