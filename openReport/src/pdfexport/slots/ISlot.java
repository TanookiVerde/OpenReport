package pdfexport.slots;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.IComponent;

public interface ISlot {
    public void addTitle(ActionEvent event);
    public void addHeader(ActionEvent event);
    public void addSprite(ActionEvent event);
    public void addSignature(ActionEvent event);
    public void addText(ActionEvent event);
    public void addGradeTable(ActionEvent event);
    public void addListing(ActionEvent event);
    public List<IComponent> getComponentList();
    public int getMaxComponentNumber();
    public VBox getComponentGrid();
    public static <T extends IComponent> void AddComponent(T component, ISlot slot){
        if(slot.getComponentGrid().getChildren().size() + 1 > slot.getMaxComponentNumber()) {
            Alert window = new Alert(Alert.AlertType.WARNING);
            window.setTitle("Ação Inválida");
            window.setContentText("O número de componentes nesta área já está no limite");
            window.show();
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
            System.out.println("Message " + i.getMessage());
            System.out.println("StackTrace: " + i.getStackTrace());
            System.out.println("Cause: " + i.getCause());
            i.printStackTrace();
        }
    }
}
