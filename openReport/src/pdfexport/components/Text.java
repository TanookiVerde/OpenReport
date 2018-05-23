package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class Text implements IComponent {
    public String text;

    public Text(String text) {
        this.text = text;
    }
    public void SetText(String txt){
        this.text = txt;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Font paragraph_font = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.NORMAL);
        Paragraph p = new Paragraph(text, paragraph_font);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        document.add(new Paragraph("\n"));
    }
    @Override
    public void setComponentInformation(VBox slot, int index, java.util.List<IComponent> template) {
    }
    public void deleteComponent(ActionEvent event) {
    }
    public void edit(ActionEvent event) {
    }
}
