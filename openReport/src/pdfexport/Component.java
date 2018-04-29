package pdfexport;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Component {
    public String componentName;
    public int id;
    
    public ComponentType type;
    
    public void print(Document document) throws IOException, DocumentException {
        //override
    }
}
