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
                "(21) 2441-5312","www.cap.uerj.br","url_imagem");
        
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(DEST));
        
        doc.open();
        tb.print(doc);
        ta.print(doc);
        tc.print(doc);
        doc.close();
        
    }
}