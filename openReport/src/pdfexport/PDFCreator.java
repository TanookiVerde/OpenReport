package pdfexport;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFCreator {
    public static final String DEST = "results/objects/chapter_title.pdf";
 
    public static Document createDocument(String destination) throws IOException, DocumentException{
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(destination));
        return document;
    }
    public static void makeDocumentFromTemplate(Template template){
        try{
            Document document = createDocument(DEST);
            document.open();
            
            for(int i = 0; i < template.documentHeader.size(); i++){
                template.documentHeader.get(i).print(document);
            }
            for(int i = 0; i < template.pageHeader.size(); i++){
                template.pageHeader.get(i).print(document);
            }
            for(int i = 0; i < template.body.size(); i++){
                template.body.get(i).print(document);
            }
            for(int i = 0; i < template.pageFooter.size(); i++){
                template.pageFooter.get(i).print(document);
            }
            for(int i = 0; i < template.documentFooter.size(); i++){
                template.documentFooter.get(i).print(document);
            }
            
            document.close();
            System.out.println("FINISHED DOCUMENT PRINTING");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
