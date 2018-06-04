package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Parent;

public class Signature implements IComponent{
    public String name;
    public String role;
    
   // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Signature.fxml";
     
    public Signature(){
         name = " ";
         role = " ";
     }
    @Override
    public void print(Document document) throws IOException, DocumentException {        
        Font lineName_font = FontFactory.getFont(FontFactory.HELVETICA, 12, null);
        Chunk line_chunk = new Chunk("_______________________________________________________", lineName_font);
        Paragraph line_paragraph = new Paragraph(line_chunk);
        line_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(line_paragraph);
        
        Chunk name_chunk = new Chunk(name, lineName_font);
        Paragraph name_paragraph = new Paragraph(name_chunk);
        name_paragraph.setFont(lineName_font);
        name_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(name_paragraph);
        
        Font subtitle_font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC);
        Chunk subtitle_chunk = new Chunk(role, subtitle_font);
        Paragraph subtitle_paragraph = new Paragraph(subtitle_chunk);
        subtitle_paragraph.setFont(subtitle_font);
        subtitle_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(subtitle_paragraph);
    }
    @Override
    public void setComponentInformation(VBox slot, Parent node, List<IComponent> template) {
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

    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
