package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class Title implements IComponent{
    public String title;
    public String subtitle;
    
    public static String fxmlPath = "components/Title.fxml";
    @FXML
    public VBox vbox; //vbox em que o componente serah armazenado
    public int vboxIndex; //indice do componente nesta vbox
    
    //public java.util.List<IComponent> list;
    
    public Title(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Font title_font = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
        Chunk title_chunk = new Chunk(title, title_font);
        Paragraph title_paragraph = new Paragraph(title_chunk);
        title_paragraph.setFont(title_font);
        title_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(title_paragraph);
        
        if(subtitle != null){
            Font subtitle_font = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.ITALIC);
            Chunk subtitle_chunk = new Chunk(subtitle, subtitle_font);
            Paragraph subtitle_paragraph = new Paragraph(subtitle_chunk);
            subtitle_paragraph.setFont(subtitle_font);
            subtitle_paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle_paragraph);
        }
        document.add(new Paragraph("\n"));
    }
    @Override
    public void setComponentInformation(VBox slot, int index, java.util.List<IComponent> template) {
        this.vbox = slot;
        this.vboxIndex = index;
        //this.list = template;
    }
    @FXML
    private void deleteComponent(ActionEvent event) {
        vbox.getChildren().remove(vbox.getChildren().get(vboxIndex));
    }
    @FXML
    private void edit(ActionEvent event) {
        System.out.println("EDITOU");
    }
}
