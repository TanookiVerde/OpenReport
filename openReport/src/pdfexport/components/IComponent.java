package pdfexport.components;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public interface IComponent {
    public String getFXMLPath();
    public void print(Document document) throws IOException, DocumentException;
    public void setComponentInformation(VBox slot, Parent node, List<IComponent> template);
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException ;
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException ;
    @FXML public void deleteComponent(ActionEvent event);
    @FXML public void editComponent(ActionEvent event);
}
