package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.*;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Header implements IComponent {
    public String componentName;
    public String schoolName;
    public String street;
    public String aptNumber;
    public String cep;
    public String telefone;
    public String webSite;
    public String logoPath;
    
    @FXML
    private TextField componentNameTF;
    @FXML
    private TextField schoolNameTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField logoPathTF;
    @FXML
    private TextField websiteTF;
    @FXML
    private TextField telefoneTF;
   
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Header.fxml";

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
        table.addCell("ESCOLA: " + schoolName);
        table.setWidths(new float[] { 1, 4 });
        table.addCell("ENDEREÇO: " + street + ", " + aptNumber + " - " + cep);
        table.addCell(cell);
        
        document.add(table);
        document.add(new Paragraph("\n"));
    }
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
        //INVALIDO
    }
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
        //INVALIDO
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
        this.schoolName = schoolNameTF.getText();
        this.street = addressTF.getText();
        this.logoPath = logoPathTF.getText();
        this.webSite = websiteTF.getText();
        this.telefone = telefoneTF.getText();
        System.out.println("Componente CABEÇALHO editado com sucesso! Novo conteudo: " + this.componentName + ", " + this.schoolName + ", " + this.street + "...");
    }
    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
