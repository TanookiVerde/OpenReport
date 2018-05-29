package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import pdfexport.components.IComponent;

public class Sprite {
    public String path;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Sprite.fxml";

    
    public Sprite(String _path){
        path = _path;
    }
    public void print(Document document) throws IOException, DocumentException { 
        Image img = Image.getInstance(path);  
        document.add(img);
    }
    public void setComponentInformation(VBox slot, int index, java.util.List<IComponent> template) {
    }
    public void deleteComponent(ActionEvent event) {
        int currentIndex = vbox.getChildren().indexOf(node);
        vbox.getChildren().remove(vbox.getChildren().get(currentIndex));
        list.remove(currentIndex);
        System.out.println(list);
    }
    public void edit(ActionEvent event) {
    }
}
