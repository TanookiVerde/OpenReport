package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.*;
import java.util.List;
import javafx.scene.Parent;

public class Header implements IComponent {
    public String schoolName;
    public String street;
    public String aptNumber;
    public String cep;
    public String telefone;
    public String webSite;
    public String logoPath;
    
    @FXML
    public VBox vbox; //vbox em que o componente serah armazenado
    public Parent node;
    
    public List<IComponent> list;
    
    public static String fxmlPath = "components/Header.fxml";

    public Header(String schoolName, String street, String aptNumber, String cep, String telefone, String webSite, String logoPath) {
        this.schoolName = schoolName;
        this.street = street;
        this.aptNumber = aptNumber;
        this.cep = cep;
        this.telefone = telefone;
        this.webSite = webSite;
        this.logoPath = logoPath;
    }
    public Header(){
        this.schoolName = " ";
        this.street = " ";
        this.aptNumber = " ";
        this.cep = " ";
        this.telefone = " ";
        this.webSite = " ";
        this.logoPath = " ";
    }
    @Override
    public void setComponentInformation(VBox slot, Parent node, List<IComponent> template){
        this.vbox = slot;
        this.node = node;
        this.list = template;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Image img = Image.getInstance(logoPath);  
        img.scaleAbsolute(80, 80);
        
        PdfPTable table =  new PdfPTable(2);
        PdfPTable subtable =  new PdfPTable(2);
        PdfPCell imgCell = new PdfPCell();
        imgCell.addElement(img);
        PdfPCell cell = new PdfPCell(subtable);
                
        subtable.addCell("CONTATO: " + telefone);
        subtable.addCell("WEBSITE: " + webSite);
        
        table.addCell(imgCell);
        PdfPCell nameCell = new PdfPCell();
        table.addCell("ESCOLA: " + schoolName);
        table.setWidths(new float[] { 1, 4 });
        table.addCell("ENDEREÇO: " + street + ", " + aptNumber + " - " + cep);
        table.addCell(cell);
        
        document.add(table);
        document.add(new Paragraph("\n"));
    }
    @Override @FXML
    public void deleteComponent(ActionEvent event) {
    }
    @Override @FXML
    public void editComponent(ActionEvent event) {
    }
}