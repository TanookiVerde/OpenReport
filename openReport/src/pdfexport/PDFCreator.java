package pdfexport;

import pdfexport.components.IComponent;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFCreator {
    public static final String DEST = "results/objects/test.pdf";
 
    static class FooterHeaderHandler extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 8, Font.ITALIC);
        boolean firstPage = false;
        
        List<IComponent> footer;
        List<IComponent> header;
 
        public void onEndPage(PdfWriter writer, Document document) 
        {
            PdfContentByte cb = writer.getDirectContent();
            if(firstPage)
            {
                PrintHeader(writer, document, cb);
            }
            else
            {
                firstPage = true;
            }
            PrintFooter(writer, document, cb);
            System.out.print("page\n");
        }
        
        public void PrintHeader(PdfWriter writer, Document document, PdfContentByte cb)
        {           
            Phrase header = new Phrase("this is a header", ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    header,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);
        }
        public void PrintFooter(PdfWriter writer, Document document, PdfContentByte cb)
        {        
            Phrase footer = new Phrase("this is a footer", ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
        }
        public void SetComponents(List<IComponent> footer, List<IComponent> header)
        {
            this.footer = footer;
            this.header = header;
        }
    }
    
    public static Document createDocument(String destination) throws IOException, DocumentException{
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(destination));
        return document;
    }
    public static void makeDocumentFromTemplate(Template template){
        try{
            Document document = new Document();
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
            FooterHeaderHandler event = new FooterHeaderHandler();
            writer.setPageEvent(event);
            
                    
            document.open();
            
            //header da primeira pagina do doc inteiro
            for(int i = 0; i < template.documentHeader.size(); i++){
                template.documentHeader.get(i).print(document);
            }
            // header de todos menos primeira
            for(int i = 0; i < template.pageHeader.size(); i++){
                template.pageHeader.get(i).print(document);
            }
            //corpo (for provavelmente)
            for(int i = 0; i < template.body.size(); i++){
                template.body.get(i).print(document);
            }
            //msm do header mas pro footer (os 2)
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
