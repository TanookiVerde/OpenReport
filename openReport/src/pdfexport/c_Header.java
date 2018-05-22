package pdfexport;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import javafx.scene.layout.VBox;
import javafx.scene.*;
import javafx.fxml.*;

public class c_Header implements IComponent {
    public String schoolName;
    public String street;
    public String aptNumber;
    public String cep;
    public String telefone;
    public String webSite;
    public String logoPath;
    
    public VBox vbox; //vbox em que o componente serah armazenado
    public int vboxIndex; //indice do componente nesta vbox
    
    private final String fxmlPath = "fxml/component_header.fxml";

    public c_Header(String schoolName, String street, String aptNumber, String cep, String telefone, String webSite, String logoPath) {
        this.schoolName = schoolName;
        this.street = street;
        this.aptNumber = aptNumber;
        this.cep = cep;
        this.telefone = telefone;
        this.webSite = webSite;
        this.logoPath = logoPath;
    }
    @Override
    public void addComponent(VBox area){
        try{
            Parent comp = FXMLLoader.load(getClass().getResource(fxmlPath));
            area.getChildren().add(comp);
            vboxIndex = area.getChildren().indexOf(comp);
            vbox = area;
        }
        catch(IOException i){
            System.out.println("ERRO "+i.getMessage());
        }
    }
    @Override @FXML
    public void deleteComponent(){
        vbox.getChildren().remove(vboxIndex);
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
}
/*
Button b = new Button("Teste");
b.setOnAction(
        new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                deleteComponent();
            }
        }
);
area.getChildren().add(b);
vboxIndex = area.getChildren().indexOf(b);
*/
