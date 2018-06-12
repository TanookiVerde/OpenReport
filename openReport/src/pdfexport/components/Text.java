package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Text implements IComponent {
    public String text;
    public String componentName;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Text.fxml";
    
    @FXML
    private TextField componentNameTF;
    @FXML
    private TextField contentText;
    
    public Text(String text) {
        this.text = text;
    }
    public Text(){
        this.text = "Coloque seu texto aqui";
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
        this.componentName = componentNameTF.getText();
        this.text = contentText.getText();
        System.out.println("Componente TEXTO editado com sucesso! Novo conteudo: " + this.text + " e " + this.componentName);
    }

    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
