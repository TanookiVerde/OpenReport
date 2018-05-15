package openreport;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import pdfexport.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class PDFtest {
    public static final String DEST = "results/test.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        c_Text ta = new c_Text("Texto de exemplo.");
        c_Title tb = new c_Title("HISTÓRICO ESCOLAR DE TRANSFERÊNCIA", null);
        c_Header tc = new c_Header("INSTITUTO DE APLICAÇÃO FERNANDO RODRIGUES",
                "RUA SANTA ALEXANDRINA","50","2278-600",
                "(21) 2441-5312","www.cap.uerj.br","resources/images/sample.png");
        c_Signature td = new c_Signature("Jorge da Silva Bastos", "Coordenador Adjunto");
        C_Table te = new C_Table(3,3,"a","b","c","d","e","f","g","h","i");
        
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(DEST));
        
        doc.open();       
        tc.print(doc);
        tb.print(doc);
        te.print(doc);
        ta.print(doc);
        td.print(doc);
        doc.close();
        
    }
}