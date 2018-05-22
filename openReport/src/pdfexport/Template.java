package pdfexport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import pdfexport.Component;

public class Template {
    public List<IComponent> title;
    public List<IComponent> pageheader;
    public List<IComponent> body;
    public List<IComponent> pagefooter;
    public List<IComponent> footer;
    
    @FXML
    private VBox titleButtonSlot;
    
    public Template(){
        title = new ArrayList<>();
        pageheader = new ArrayList<>();
        body = new ArrayList<>();
        pagefooter = new ArrayList<>();
        footer = new ArrayList<>();
    }
    @FXML
    public void addComponentOnTitle(ActionEvent event){
        c_Header ctrl;
        Parent comp;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(c_Header.fxmlPath));
            comp = loader.load();
            ctrl = loader.getController();
            titleButtonSlot.getChildren().add(comp);
        }
        catch(IOException i){
            System.out.println("ERRO "+i.getMessage()+i.toString());
            return;
        }
        ctrl.setComponentInformation(
                titleButtonSlot,
                titleButtonSlot.getChildren().indexOf(comp),
                this);
    }
    public void removeComponentFromTitle(int index){
        title.remove(index);
    }
}
