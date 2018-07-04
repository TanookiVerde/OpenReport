package pdfexport.slots;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.*;
import static pdfexport.slots.ISlot.AddComponent;

public class Body implements ISlot {
    
    public final int MAX_COMPONENT_NUMBER           = 5;
    public final static String SLOT_PATH            = "/pdfexport/slots/Body.fxml";
    
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
        AddComponent(new GradeTable(),this);
    }

    @Override
    public void addListing(ActionEvent event) {
        AddComponent(new GradeTable(),this);
    }
    
    @Override
    public VBox getComponentGrid(){
        return componentGrid;
    }
    
    @Override
    public List<IComponent> getComponentList(){
        return Template.template.body;
    }
    
    @Override
    public int getMaxComponentNumber(){
        return MAX_COMPONENT_NUMBER;
    }

    
}
