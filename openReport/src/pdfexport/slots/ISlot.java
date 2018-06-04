package pdfexport.slots;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.IComponent;

public interface ISlot {
    public void addTitle(ActionEvent event);
    public void addHeader(ActionEvent event);
    public void addSprite(ActionEvent event);
    public void addSignature(ActionEvent event);
    public void addSimpleTable(ActionEvent event);
    public void addText(ActionEvent event);
    public List<IComponent> getComponentList();
    public int getMaxComponentNumber();
    public VBox getComponentGrid();
    public static <T extends IComponent> void AddComponent(T component, ISlot slot){
        if(slot.getComponentGrid().getChildren().size() + 1 > slot.getMaxComponentNumber()) {
            return;
        }
        try{
            FXMLLoader loader = new FXMLLoader(Template.class.getResource( component.getFXMLPath() ));
            Parent newNode = (Parent) loader.load();
            T newComponent = loader.getController();
            
            slot.getComponentGrid().getChildren().add(newNode);
            
            newComponent.setComponentInformation(slot.getComponentGrid(), 
                    newNode, 
                    slot.getComponentList()
            );
            
            slot.getComponentList().add(newComponent);
        }catch(Exception i){
            System.out.println(i.getMessage());
            System.out.println(i.getStackTrace());
        }
    }
}
