package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Listing implements IComponent{
    private final ObservableList<String> categoryList = FXCollections.observableArrayList("Alunos", "Professores");
    private final ObservableList<String> alunosFilterList = FXCollections.observableArrayList("Turma","Disciplina","Série");
    private final ObservableList<String> professorFilterList = FXCollections.observableArrayList("Turma","Disciplina");
    
    @FXML private ComboBox<String> categoryCB;
    @FXML private ComboBox<String> filterCB;
    @FXML private TextField inputTF;
    
    private String input;
    
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
        input = inputTF.getText();
        System.out.println("Componente LISTING editado com sucesso! Valor Input: "+input);
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
