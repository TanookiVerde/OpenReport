package pdfexport;

import pdfexport.components.IComponent;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class Template {
    public List<IComponent> title;
    public List<IComponent> pageheader;
    public List<IComponent> body;
    public List<IComponent> pagefooter;
    public List<IComponent> footer;
    
    public static Template template = new Template();
    
    @FXML
    private VBox slots;
    
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
}
