package pdfexport.components;

import com.itextpdf.text.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
* Classe que representa o component Title.
*/
public class Title implements IComponent{
    public String title;
    public String subtitle;
    
    //public final static String FXML_PATH = "/pdfexport/components/Title.fxml";
    
    // Para referenciar em funções de adição, remoção e edição
    public VBox vbox; 
    public Parent node;
    public java.util.List<IComponent> list;
    public static String FXML_PATH = "/pdfexport/components/Title.fxml";

    
    public Title(){
        this.title = " ";
        this.subtitle = " ";
    }
    /**
     * Este método é chamado quando se está percorrendo o vetor de components e 
     * "printando" suas informações em sequência. Ele está vinculado à interface 
     * IComponent.
     */
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Font title_font = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
        Chunk title_chunk = new Chunk(title, title_font);
        Paragraph title_paragraph = new Paragraph(title_chunk);
        title_paragraph.setFont(title_font);
        title_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(title_paragraph);
        
        if(subtitle != null){
            Font subtitle_font = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.ITALIC);
            Chunk subtitle_chunk = new Chunk(subtitle, subtitle_font);
            Paragraph subtitle_paragraph = new Paragraph(subtitle_chunk);
            subtitle_paragraph.setFont(subtitle_font);
            subtitle_paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle_paragraph);
        }
        document.add(new Paragraph("\n"));
    }
    /**
     * Este método é chamado assim que se cria um component. Através dele o component sabe
     * onde está armazenado, qual node o representa e em qual lista da instância template ele
     * está. Dessa maneira ele pode futuramente se deletar ou mudar de ordem.
     */
    @Override
    public void setComponentInformation(VBox slot, Parent node, java.util.List<IComponent> template) {
        this.vbox = slot;
        this.node = node;
        this.list = template;
    }
    /**
     * Este método é chamado quando o usuário clica no botão de deletá-lo. Ele se remove da VBox que
     * representa a lista de componentes e também da lista de components no template. É importante dizer
     * que ele calcula seu indice usando o node que foi passado pelo método setComponentInformation.
     */
    @Override @FXML
    public void deleteComponent(ActionEvent event) {
        int currentIndex = vbox.getChildren().indexOf(node);
        vbox.getChildren().remove(vbox.getChildren().get(currentIndex));
        list.remove(currentIndex);
        System.out.println(list);
    }
    /**
     * Este método é chamado quando o usuário clica no botão de atualizar informações do component
     * (a.k.a. Editar). Ele coleta as informações dos InputFields e as coloca nos campos do component.
     */
    @Override @FXML
    public void editComponent(ActionEvent event) {
        System.out.println("EDITOU");
    }
}
