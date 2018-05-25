package pdfexport.slots;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.*;

/**
 * Classe que representa um Slot (lista de components). Nela é possível adicionar
 * components no template.
 */
public class DocumentHeader implements ISlot {
    
    public final static int MAX_COMPONENT_NUMBER    = 3;
    public final static String SLOT_PATH            = "/pdfexport/slots/DocumentHeader.fxml";
    
    @FXML
    private VBox componentGrid;
    
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Title.
     */
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
                    Template.template.title
            );
            
            Template.template.title.add(component);
        }catch(Exception i){
            System.out.println(i.getMessage());
            System.out.println(i.getStackTrace());
        }
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Header.
     */
    @Override
    public void addHeader(ActionEvent event) {
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Sprite.
     */
    @Override
    public void addSprite(ActionEvent event) {
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Signature.
     */
    @Override
    public void addSignature(ActionEvent event) {
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Table.
     */
    @Override
    public void addSimpleTable(ActionEvent event) {
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Text.
     */
    @Override
    public void addText(ActionEvent event) {
    }
}
