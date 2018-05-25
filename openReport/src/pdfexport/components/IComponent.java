package pdfexport.components;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public interface IComponent {
    public void print(Document document) throws IOException, DocumentException;
    public void setComponentInformation(VBox slot, Parent node, List<IComponent> template);
    @FXML public void deleteComponent(ActionEvent event);
    @FXML public void editComponent(ActionEvent event);
}
