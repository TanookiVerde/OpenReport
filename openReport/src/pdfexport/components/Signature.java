package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import pdfexport.*;
import java.util.List;

public class Signature implements IComponent{
    public String name;
    public String role;
     
    public Signature(String _name, String _role){
         name = _name;
         role = _role;
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
    public void setComponentInformation(VBox area, int index, List<IComponent> template) {
    }
    public void deleteComponent(ActionEvent event) {
    }
    public void edit(ActionEvent event) {
    }
}
