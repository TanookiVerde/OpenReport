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
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;
import openreport.SceneController;

public class PDFCreator {
    public static final String DEST = "results/objects/test.pdf";
    
    //Margins
    private static float left = 30;
    private static float right = 30;
    private static float top = 30;
    private static float bottom = 50;
 
    static class FooterHeaderHandler extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 8, Font.ITALIC);
        boolean firstPage = false;
        boolean printFooter = true;
        
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
            if(printFooter)
                PrintFooter(writer, document, cb);
            System.out.print("page\n");
        }
        
        public void PrintHeader(PdfWriter writer, Document document, PdfContentByte cb)
        {           
            try
            {
                for(int i = 0; i < header.size(); i++){
                    header.get(i).printAsPageHeader(writer, document, cb);
                }
            }
            catch(Exception e)
            {
            e.printStackTrace();
            }
        }
        public void PrintFooter(PdfWriter writer, Document document, PdfContentByte cb)
        {        
            try
            {
                for(int i = 0; i < footer.size(); i++){
                    footer.get(i).printAsPageFooter(writer, document, cb);
                }
            }
            catch(Exception e)
            {
            e.printStackTrace();
            }
        }
        public void SetComponents(List<IComponent> footer, List<IComponent> header)
        {
            this.footer = footer;
            this.header = header;
        }
        public void SetPrintFooter(boolean value)
        {
            printFooter = value;
        }
    }
    
    public static Document createDocument(String destination) throws IOException, DocumentException{
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(destination));
        return document;
    }
    public static void makeDocumentFromTemplate(Template template, String dest){
        try{
            Document document = new Document();
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            FooterHeaderHandler event = new FooterHeaderHandler();
            
            if(template.pageFooter != null && template.pageHeader != null)
            {
                event.SetComponents(template.pageFooter, template.pageHeader);
                writer.setPageEvent(event);
            }
            document.setMargins(left, right, top, bottom);
            document.open();
            
            //header da primeira pagina do doc inteiro
            if(template.documentHeader != null)
            {
                for(int i = 0; i < template.documentHeader.size(); i++)
                {
                    template.documentHeader.get(i).print(document);
                }
            }
            for(int i = 0; i < template.body.size(); i++){
                template.body.get(i).print(document);
            }
            for(int i = 0; i < template.documentFooter.size(); i++){
                template.documentFooter.get(i).print(document);
            }
            document.close();
            
            Alert window = new Alert(Alert.AlertType.CONFIRMATION);
            window.initOwner(SceneController.mainStage);
            window.setHeaderText("Sucesso");
            window.setTitle("Finalizado");
            window.setContentText("Documento PDF gerado com sucesso. Deseja abrir o arquivo?");           
            
            ButtonType openBtn = new ButtonType("Abrir", ButtonData.OK_DONE);
            ButtonType cancelBtn = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
            
            window.getButtonTypes().setAll(openBtn, cancelBtn);
            Optional<ButtonType> result = window.showAndWait();
            
            if (result.get() == openBtn){
                Desktop.getDesktop().open(new File(dest));
            }
            
        } catch(Exception e){
            Alert window = new Alert(Alert.AlertType.WARNING);
            window.initOwner(SceneController.mainStage);
            window.setTitle("Erro");
            window.setHeaderText("Falha");
            window.setContentText("Documento PDF não foi gerado. Veja se todos os componentes possuem informações não nulas e se possui acesso para salvar na pasta selecionada.");
            window.show();
            e.printStackTrace();
        }
    }
}
