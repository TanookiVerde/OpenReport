package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class Sprite implements IComponent{
    public String path;
    
    public Sprite(String _path){
        path = _path;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException { 
        Image img = Image.getInstance(path);  
        document.add(img);
    }
    @Override
    public void setComponentInformation(VBox slot, int index, java.util.List<IComponent> template) {
    }
    @Override
    public void deleteComponent(ActionEvent event) {
    }
    @Override
    public void edit(ActionEvent event) {
    }
}
