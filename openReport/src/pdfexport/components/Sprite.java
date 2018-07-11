package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import openreport.SceneController;

public class Sprite implements IComponent{
    public String path;
    
    @FXML
    private javafx.scene.text.Text lastSelectedPath;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Sprite.fxml";
    
    public Sprite(String _path){
        path = _path;
    }
    public Sprite(){
        path = "Coloque aqui onde está seu arquivo";
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Image img = Image.getInstance(path);  
        document.add(img);
    }
    @Override
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {     
        Font ffont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);
        Phrase header = new Phrase("", ffont);
        Image img = Image.getInstance(path);  
        header.add(img);
        
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,    
                header,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.top() + 10, 0);
    }
    @Override
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {     
        Font ffont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC);
        Phrase footer = new Phrase("", ffont);
        Image img = Image.getInstance(path);  
        footer.add(img);
        
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
    @FXML
    public void activateFileChooser(ActionEvent event){
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(SceneController.mainStage);
        path = f.getPath();
        lastSelectedPath.setText(path);
    }
    
    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
