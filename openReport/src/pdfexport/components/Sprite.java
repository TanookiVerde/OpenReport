package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class Sprite implements IComponent{
    public String path;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Sprite.fxml";
    
    public Sprite(String _path){
        path = _path;
    }
    public Sprite(){
        path = "Coloque aqui onde está seu arquivo";
    }
    @Override
    public void print(Document document) throws IOException, DocumentException { 
        Image img = Image.getInstance(path);  
        document.add(img);
    }
    @Override
    public void setComponentInformation(VBox slot, Parent node, java.util.List<IComponent> template) {
        this.vbox = slot;
        this.node = node;
        this.list = template;
    }
    @Override @FXML
    public void deleteComponent(ActionEvent event) {
        int currentIndex = vbox.getChildren().indexOf(node);
        vbox.getChildren().remove(vbox.getChildren().get(currentIndex));
        list.remove(currentIndex);
        System.out.println(list);
    }
    @Override @FXML
    public void editComponent(ActionEvent event) {
    }
}
