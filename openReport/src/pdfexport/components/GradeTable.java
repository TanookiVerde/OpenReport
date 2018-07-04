package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class GradeTable implements IComponent{
    public int registry;
    public int columnAmount;
    public int cellPerColumn;
    
    @FXML
    private TextField registryTF;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/GradeTable.fxml";

    public GradeTable(){
        registry = 0;
        columnAmount = 1;
        cellPerColumn = 1;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {          
        //ToDo
    }
    @Override
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
     //INVÁLIDO
    }
    @Override
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
     //INVÁLIDO
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
        this.registry = Integer.parseInt(registryTF.getText());
        System.out.println("Componente GRADETABLE editado com sucesso! Novo conteudo: " + this.registry);
    }
    
    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
