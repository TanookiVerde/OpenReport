package pdfexport.components;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class Table implements IComponent{
    public ArrayList<String> content;
    public int columnAmount;
    public int cellPerColumn;
     
    public Table(int _columnAmount, int _cellPerColumn, String... _content){
        content = new ArrayList<String>();
        for(String c : _content){
             content.add(c);
        }
        columnAmount = _columnAmount;
        cellPerColumn = _cellPerColumn;
     }
    @Override
    public void print(Document document) throws IOException, DocumentException {        
        
        PdfPTable table =  new PdfPTable(columnAmount);
        table.getDefaultCell().setBorder(PdfPCell.BOTTOM | PdfPCell.TOP | PdfPCell.RIGHT | PdfPCell.LEFT);
        table.getDefaultCell().setPadding(0);
        
        PdfPTable subtable;
        int count = 0;
        for(int i = 0; i < columnAmount; i++){
            subtable =  new PdfPTable(1);
            subtable.getDefaultCell().setBorder(PdfPCell.BOTTOM);
            for(int j = 0; j < cellPerColumn; j++){
                if(count < content.size())
                    subtable.addCell(content.get(count));
                count++;
            }
            table.addCell((subtable));
        }
        
        document.add(table);
        document.add(new Paragraph("\n"));
    }
    @Override
    public void setComponentInformation(VBox slot, int index, java.util.List<IComponent> template) {
    }
    @Override
    public void deleteComponent(ActionEvent event) {
    }
    @Override
    public void edit(ActionEvent event) {
    }
}
