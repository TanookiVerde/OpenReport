package pdfexport;

import com.itextpdf.text.*;
import java.io.IOException;

public class Component {
    public String componentName;
    public int id;
    
    public void print(Document document) throws IOException, DocumentException {
        //override
    }
    public void getComponentNode(){
        //override
    }
    public void deleteComponent(){
        //override
    }
}
