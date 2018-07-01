package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Signature implements IComponent{
    public String componentName;
    public String name;
    public String role;
    
   // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Signature.fxml";
    
    @FXML
    public TextField componentNameTF;
    public TextField nameTF;
    public TextField roleTF;
     
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
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    { 
        Font ffont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);
        Phrase header = new Phrase("", ffont);     
        Chunk line_chunk = new Chunk("_______________________________________________________", ffont);
        header.add(line_chunk + "\n");
               
        Chunk name_chunk = new Chunk(name, ffont);
        header.add(name_chunk + ", ");
        
        Chunk subtitle_chunk = new Chunk(role, ffont);
        header.add(subtitle_chunk);
        
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                header,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.top() + 10, 0);
    }
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {        
        Font ffont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);
        //Phrase footer = new Phrase("", ffont);     
        Chunk line_chunk = new Chunk("_______________________________________________________", ffont);
        //footer.add(line_chunk + "\n");
               
        Chunk name_chunk = new Chunk(name, ffont);
        //footer.add(name_chunk + ", ");
        
        Chunk subtitle_chunk = new Chunk(role, ffont);
        //footer.add(subtitle_chunk);
        Phrase footer = new Phrase(name + "\n" + role, ffont);   
        
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
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
        this.componentName = componentNameTF.getText();
        this.name = nameTF.getText();
        this.role = roleTF.getText();
        System.out.println("Componente ASSINATURA editado com sucesso! Novo conteudo: " + this.name + ", " + this.componentName + " e " + this.role);
    }

    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
