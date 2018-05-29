package pdfexport;

import java.io.IOException;
import pdfexport.components.IComponent;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import pdfexport.slots.*;

/**
 * Classe que representa um Template. Nele podemos encontrar a lista de components
 em cada slot (pageHeader, body, etc).
 <p>
 * Esta Classe também serve como um Controller para a Tela de Customização, por isso
 * podemos encontrar métodos como toPDF e saveToXML que são ativados por clique em
 * botões.
 */
public class Template {
    public List<IComponent> documentHeader;
    public List<IComponent> pageHeader;
    public List<IComponent> body;
    public List<IComponent> pageFooter;
    public List<IComponent> documentFooter;
    
    public static Template template = new Template();
    
    @FXML
    private VBox slotGrid;
    
    public Template(){
        documentHeader = new ArrayList<>();
        pageHeader = new ArrayList<>();
        body = new ArrayList<>();
        pageFooter = new ArrayList<>();
        documentFooter = new ArrayList<>();
    }
    /**
     * Este método é chamado quando o usuário clica no botão de salvar como PDF
     * o documento. Ele simplesmente gera um pdf relatório.
     */
    @FXML
    private void toPDF(ActionEvent event){
        //gera um pdf relatorio a partir dos componentes em cada slot
    }
    /**
     * Este método é chamado quando o usuário clica no botão de exportar template.
     * Ele serializa a instância de classe template em xml e salva em um arquivo 
     * que pode ser lido depois.
     */
    @FXML
    private void saveToXML(ActionEvent event){
    }
    /**
     * Este método deve ser chamado quando o usuário clica no botão de voltar
     * para o menu principal. Sua função é autoexplicativa.
     */
    @FXML
    private void backToMainMenu(ActionEvent event){
    }
    /**
     * Este método é chamado logo no inicio quando se entra na tela de customização.
     * Nele é gerado os Slots, cada um deles representando uma lista de components.
     */
    @FXML
    public void initialize() {
        try{
            Node docHeader = FXMLLoader.load(getClass().getResource(DocumentHeader.SLOT_PATH));
            slotGrid.getChildren().add(docHeader);
            Node pageHeader = FXMLLoader.load(getClass().getResource(PageHeader.SLOT_PATH));
            slotGrid.getChildren().add(pageHeader);
            //ToDo: Add outros Slots
        }catch(IOException i){
            System.out.println(i.getMessage());
        }
    }
}
