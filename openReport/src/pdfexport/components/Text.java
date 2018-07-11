package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Text implements IComponent {
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Text.fxml";
    
    @FXML
    private TextField contentText;
    
    public Text(){
    }
    public void SetText(String txt){
        contentText.setText(txt);
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Font paragraph_font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        Paragraph p = new Paragraph(contentText.getText(), paragraph_font);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        document.add(new Paragraph("\n"));
    }
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {      
        Font ffont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);
        Phrase header = new Phrase("", ffont);
        header.add(contentText.getText());
        
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                header,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.top() + 10, 0);
    }
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {      
        Font ffont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);
        Phrase footer = new Phrase("", ffont);
        footer.add(contentText.getText());
        
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
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

    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
