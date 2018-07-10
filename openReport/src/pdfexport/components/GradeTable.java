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
    public String registry;
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
        registry = "0";
        columnAmount = 1;
        cellPerColumn = 1;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {          
        Historico historico = new Historico();
        if(registry == null) return;
        historico = DatabaseManager.callStatement(historico, "HISTORICO", registry);
        
        PdfPTable raiz = new PdfPTable(1);
        PdfPTable alunoInfo1 = new PdfPTable(2);
        PdfPTable alunoInfo2 = new PdfPTable(2);
        PdfPTable notas = new PdfPTable(4);
        
        Phrase p;
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
             
        p = new Phrase(historico.aluno.nome, font);
        System.out.println(historico.aluno.nome);
        alunoInfo1.addCell(p);
        p = new Phrase(historico.aluno.cpf, font);
        alunoInfo1.addCell(p);
        p = new Phrase(historico.aluno.matricula, font); 
        alunoInfo2.addCell(p);
        p = new Phrase(historico.aluno.nascimento, font);  
        alunoInfo2.addCell(p);    
        
        p = new Phrase("Série", font);
        notas.addCell(p);
        p = new Phrase("Disciplina", font);
        notas.addCell(p);
        p = new Phrase("Nota", font);
        notas.addCell(p);
        p = new Phrase("Frequência (%)", font);
        notas.addCell(p);
        font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL); 
        for(int i = 0; i < historico.notas.size(); i++)
        {
            p = new Phrase(historico.notas.get(i).serie, font);  
            notas.addCell(p);
            p = new Phrase(historico.notas.get(i).disciplina, font);  
            notas.addCell(p);
            p = new Phrase(Float.toString(historico.notas.get(i).media), font);  
            notas.addCell(p);
            p = new Phrase(Float.toString(historico.notas.get(i).frequencia), font);  
            notas.addCell(p);
        }
        
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
        registry = registryTF.getText();
        System.out.println("Componente GRADETABLE editado com sucesso! Novo conteudo: " + this.registry);
    }
    
    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }
}
