package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.swing.GroupLayout;
import openreport.database.*;
import openreport.database.Aluno;
import openreport.database.DatabaseManager;
import static openreport.database.DatabaseManager.callStatement;

public class Listing implements IComponent{
    private final ObservableList<String> categoryList = FXCollections.observableArrayList("Alunos", "Professores");
    private final ObservableList<String> alunosFilterList = FXCollections.observableArrayList("Turma","Disciplina","Série");
    private final ObservableList<String> professorFilterList = FXCollections.observableArrayList("Turma","Disciplina");
    
    @FXML private ComboBox<String> categoryCB;
    @FXML private ComboBox<String> filterCB;
    @FXML private TextField inputTF;
    @FXML private TextField schoolCnpjTF;
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Listing.fxml";

    public Listing(){
    }

    @Override
    public void print(Document document) throws IOException, DocumentException {          
        //ToDo
        String category = categoryCB.getValue();
        String filter = filterCB.getValue();
        
        if(category == "Alunos")
        {
            ArrayList<Aluno> array;
            switch(filter)
            {
                case "Turma":
                    array = callStatement(Aluno.class, "ALUNOTURMA", inputTF.getText(), schoolCnpjTF.getText());
                    break;
                case "Disciplina":
                    array = callStatement(Aluno.class, "ALUNODISC", inputTF.getText());
                    break;
                case "Série":
                    array = callStatement(Aluno.class, "ALUNOSERIE", inputTF.getText());
                    break;
                default:
                    array = new ArrayList<Aluno>();
                    break;
            }
            
            if(array == null) return;
            
            PdfPTable table =  new PdfPTable(4);
            Phrase p;
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
            p = new Phrase("Nome", font);
            table.addCell(p);
            p = new Phrase("Matricula", font);
            table.addCell(p);
            p = new Phrase("CPF", font);
            table.addCell(p);
            p = new Phrase("Data de Nascimento", font);  
            table.addCell(p); 
            font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL); 
            for(int i = 0; i < array.size(); i++)
            {
                p = new Phrase(array.get(i).nome, font);  
                table.addCell(p);
                p = new Phrase(array.get(i).matricula);
                table.addCell(p);
                p = new Phrase(array.get(i).cpf, font); 
                table.addCell(p);
                p = new Phrase(array.get(i).nascimento, font);  
                table.addCell(p);          
            }
            font = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD); 
            p = new Phrase("Listagem de " + category + " por " + filter + ": " + inputTF.getText(), font);  
            Paragraph para = new Paragraph(p);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(new Phrase("\n"));
            document.add(table);
        }
        else if(category == "Professores")
        {
            ArrayList<Professor> array;
            switch(filter)
            {
                case "Turma":
                    array = callStatement(Professor.class, "PROFTURMA", inputTF.getText());
                    break;
                case "Disciplina":
                    array = callStatement(Professor.class, "PROFDISC", inputTF.getText());
                    break;
                default:
                    array = new ArrayList<Professor>();
                    break;
            }
            
            if(array == null) return;
            
            PdfPTable table =  new PdfPTable(3);
            Phrase p;
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
            p = new Phrase("Nome", font);
            table.addCell(p);
            p = new Phrase("CPF", font);
            table.addCell(p);
            p = new Phrase("Data de Nascimento", font);  
            table.addCell(p); 
            font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL); 
            for(int i = 0; i < array.size(); i++)
            {
                p = new Phrase(array.get(i).nome, font);  
                table.addCell(p);
                p = new Phrase(array.get(i).cpf, font); 
                table.addCell(p);
                p = new Phrase(array.get(i).nascimento, font);  
                table.addCell(p);          
            }
            document.add(table);
        }
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
    
    @FXML
    public void initialize(){
        categoryCB.setItems(categoryList);
        categoryCB.valueProperty().addListener(
                new ChangeListener<String>() {
                    @Override public void changed(ObservableValue ov, String t, String t1) {
                        if(t1 == "Alunos"){
                            filterCB.setItems(alunosFilterList);
                        }else if(t1 == "Professores"){
                            filterCB.setItems(professorFilterList);
                        }
                    }
                });
    }
}
 