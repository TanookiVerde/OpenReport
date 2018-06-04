package pdfexport.slots;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import pdfexport.Template;
import pdfexport.components.*;
import static pdfexport.slots.ISlot.AddComponent;

/**
 * Classe que representa um Slot (lista de components). Nela é possível adicionar
 * components no template.
 */
public class PageHeader implements ISlot {
    
    public final int MAX_COMPONENT_NUMBER           = 1;
    public final static String SLOT_PATH            = "/pdfexport/slots/PageHeader.fxml";
    
    @FXML
    private VBox componentGrid;
    
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Title.
     */
    @Override
    public void addTitle(ActionEvent event) {
        AddComponent(new Title(),this);
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Header.
0     */
    @Override
    public void addHeader(ActionEvent event) {
        AddComponent(new Header(),this);
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Sprite.
     */
    @Override
    public void addSprite(ActionEvent event) {
        AddComponent(new Sprite(),this);
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Signature.
     */
    @Override
    public void addSignature(ActionEvent event) {
        AddComponent(new Signature(),this);
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Table.
     */
    @Override
    public void addSimpleTable(ActionEvent event) {
        AddComponent(new Table(),this);
    }
    /**
     * Método chamado quando o usuário clica no botão de adicionar um component do tipo
     * Text.
     */
    @Override
    public void addText(ActionEvent event) {
        AddComponent(new Text(),this);
    }
    @Override
    public VBox getComponentGrid(){
        return componentGrid;
    }
    @Override
    public List<IComponent> getComponentList(){
        return Template.template.pageHeader;
    }
    @Override
    public int getMaxComponentNumber(){
        return MAX_COMPONENT_NUMBER;
    }
}
