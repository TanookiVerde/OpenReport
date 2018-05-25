package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import pdfexport.components.IComponent;

public class Sprite {
    public String path;
    
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
    }
    public void edit(ActionEvent event) {
    }
}