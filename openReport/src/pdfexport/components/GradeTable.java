package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import openreport.database.DatabaseManager;
import openreport.database.Historico;

public class GradeTable implements IComponent{
    public int columnAmount;
    public int cellPerColumn;
    
    @FXML
    private TextField registryTF;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/GradeTable.fxml";

    public GradeTable(){
        columnAmount = 1;
        cellPerColumn = 1;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {          
        Historico historico = new Historico();
        if(registryTF.getText() == null) return;
        historico = DatabaseManager.callStatement(historico, "HISTORICO", registryTF.getText());
        
        PdfPTable raiz = new PdfPTable(1);
        PdfPTable alunoInfo1 = new PdfPTable(2);
        PdfPTable alunoInfo2 = new PdfPTable(2);
        PdfPTable notas = new PdfPTable(4);
        
        Phrase p;
        Phrase subP;
        Paragraph para;
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.ITALIC);
        
        subP = new Phrase("Nome: ", subtitleFont);     
        p = new Phrase(historico.aluno.nome, font);
        para = new Paragraph();
        para.add(subP);
        para.add(p);
        alunoInfo1.addCell(para);
        subP = new Phrase("CPF: ", subtitleFont);     
        p = new Phrase(historico.aluno.cpf, font);
        para = new Paragraph();
        para.add(subP);
        para.add(p);
        alunoInfo1.addCell(para);
        subP = new Phrase("Matricula: ", subtitleFont);
        p = new Phrase(historico.aluno.matricula, font); 
        para = new Paragraph();
        para.add(subP);
        para.add(p);
        alunoInfo2.addCell(para);
        subP = new Phrase("Data de Nascimento: ", subtitleFont);
        p = new Phrase(historico.aluno.nascimento, font);  
        para = new Paragraph();
        para.add(subP);
        para.add(p);
        alunoInfo2.addCell(para);
        
        p = new Phrase("Série", font);
        notas.addCell(p);
        p = new Phrase("Disciplina", font);
        notas.addCell(p);
        p = new Phrase("Nota", font);
        notas.addCell(p);
        p = new Phrase("Frequência (%)", font);
        notas.addCell(p);
        font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL); 
        
        PdfPTable serie, disc, media, freq;
        serie = new PdfPTable(1);
        serie.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        disc = new PdfPTable(1);
        disc.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        media = new PdfPTable(1);
        media.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        freq = new PdfPTable(1);
        freq.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        //serie.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        serie.getDefaultCell().setPaddingLeft(5);
        serie.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        serie.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        
        String ser ="0";
        String previousSerie = "-1";
        for(int i = 0; i < historico.notas.size(); i++)
        {
            //if(i == 0 ){serie.getDefaultCell().setBorder(PdfPCell.TOP | PdfPCell.RIGHT | PdfPCell.LEFT);}
            //else if(i == historico.notas.size() - 1){serie.getDefaultCell().setBorder(PdfPCell.BOTTOM | PdfPCell.RIGHT | PdfPCell.LEFT);}
            //else{serie.getDefaultCell().setBorder(PdfPCell.RIGHT | PdfPCell.LEFT);}
                
            ser = historico.notas.get(i).serie;
            
            if(!ser.equals(previousSerie)){
                p = new Phrase(ser + "ª", font); 
                //serie.getDefaultCell().setBorder(PdfPCell.TOP | PdfPCell.RIGHT | PdfPCell.LEFT);
            }
            else
                p = new Phrase("", font); 
            serie.addCell(p);
            p = new Phrase(historico.notas.get(i).disciplina, font);  
            disc.addCell(p);
            p = new Phrase(Float.toString(historico.notas.get(i).media), font);  
            media.addCell(p);
            p = new Phrase(Float.toString(historico.notas.get(i).frequencia), font);  
            freq.addCell(p);
            
            previousSerie = ser;
        }
        notas.addCell(serie);
        notas.addCell(disc);
        notas.addCell(media);
        notas.addCell(freq);
        
        raiz.addCell(alunoInfo1);
        raiz.addCell(alunoInfo2);
        raiz.addCell(notas);
        
        document.add(raiz);
    }
    @Override
    public void printAsPageHeader(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
     //INVÁLIDO
    }
    @Override
    public void printAsPageFooter(PdfWriter writer, Document document, PdfContentByte cb) throws IOException, DocumentException 
    {
     //INVÁLIDO
    }
    @Override
    public void setComponentInformation(VBox slot, Parent node, java.util.List<IComponent> template) {
        this.vbox = slot;
        this.node = node;
        this.list = template;
    }
    @Override @FXML
    public void deleteComponent(ActionEvent event) {
        int currentIndex = vbox.getChildren().indexOf(node);
        vbox.getChildren().remove(vbox.getChildren().get(currentIndex));
        list.remove(currentIndex);
        System.out.println(list);
    }
    @Override @FXML
    public void editComponent(ActionEvent event) {
    }
    
    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
