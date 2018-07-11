package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.*;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import openreport.SceneController;

public class Header implements IComponent {
    public String path;
    
    @FXML
    private TextField schoolNameTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField websiteTF;
    @FXML
    private TextField telefoneTF;
    @FXML
    private javafx.scene.text.Text lastSelectedPath;
   
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Header.fxml";

    public Header(){
        this.path = " ";
    }
    @Override
    public void setComponentInformation(VBox slot, Parent node, List<IComponent> template){
        this.vbox = slot;
        this.node = node;
        this.list = template;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Image img = Image.getInstance(path);  
        img.scaleAbsolute(80, 80);
        
        PdfPTable table =  new PdfPTable(2);
        PdfPTable subtable =  new PdfPTable(2);
        PdfPCell imgCell = new PdfPCell();
        imgCell.addElement(img);
        PdfPCell cell = new PdfPCell(subtable);
                
        subtable.addCell("CONTATO: " + telefoneTF.getText());
        subtable.addCell("WEBSITE: " + websiteTF.getText());
        
        table.addCell(imgCell);
        table.addCell("ESCOLA: " + schoolNameTF.getText());
        table.setWidths(new float[] { 1, 4 });
        table.addCell("ENDEREÇO: " + addressTF.getText());
        table.addCell(cell);
        
        document.add(table);
        document.add(new Paragraph("\n"));
    }
    @Override
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
        //INVALIDO
    }
    @Override
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
    }
    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
    
    @FXML
    public void activateFileChooser(ActionEvent event){
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(SceneController.mainStage);
        path = f.getPath();
        lastSelectedPath.setText(path);
    }
}
