package pdfexport;

import java.io.IOException;
import pdfexport.components.IComponent;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import pdfexport.components.Title;
import pdfexport.slots.DocumentHeader;

public class Template {
    public List<IComponent> title;
    public List<IComponent> pageheader;
    public List<IComponent> body;
    public List<IComponent> pagefooter;
    public List<IComponent> footer;
    
    public static Template template = new Template();
    
    @FXML
    private HBox slotGrid;
    
    public Template(){
        title = new ArrayList<>();
        pageheader = new ArrayList<>();
        body = new ArrayList<>();
        pagefooter = new ArrayList<>();
        footer = new ArrayList<>();
    }
    @FXML
    private void toPDF(ActionEvent event){
    }
    @FXML
    private void saveToXML(ActionEvent event){
    }
    @FXML
    private void backToMainMenu(ActionEvent event){
    }
    @FXML
    public void initialize() {
        try{
            Node root = FXMLLoader.load(getClass().getResource(DocumentHeader.slotPath));
            slotGrid.getChildren().add(root);
        }catch(IOException i){
        System.out.println(i.getMessage());
        }
    }
}
