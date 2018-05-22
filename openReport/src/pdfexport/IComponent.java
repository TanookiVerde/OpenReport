package pdfexport;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import javafx.scene.layout.VBox;

public interface IComponent {
    public void print(Document document) throws IOException, DocumentException;
    public void addComponent(VBox vbox);
    public void deleteComponent();
}
