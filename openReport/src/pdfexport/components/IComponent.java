package pdfexport.components;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public interface IComponent {
    public void print(Document document) throws IOException, DocumentException;
    public void setComponentInformation(VBox slot, int index, List<IComponent> template);
    public void deleteComponent(ActionEvent event);
    public void edit(ActionEvent event);
}
