package pdfexport;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;

public class c_Image extends Component{
    public String path;
    
    public c_Image(String _path){
        path = _path;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException { 
        Image img = Image.getInstance(path);  
        document.add(img);
    }
}
