package pdfexport;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;

public class c_Header extends Component {
    public String schoolName;
    public String street;
    public String aptNumber;
    public String cep;
    public String telefone;
    public String webSite;
    public String image;

    public c_Header(String schoolName, String street, String aptNumber, String cep, String telefone, String webSite, String image) {
        this.schoolName = schoolName;
        this.street = street;
        this.aptNumber = aptNumber;
        this.cep = cep;
        this.telefone = telefone;
        this.webSite = webSite;
        this.image = image;
        
        type = ComponentType.HEADER;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        PdfPTable table =  new PdfPTable(1);
        PdfPTable subtable =  new PdfPTable(2);
        PdfPCell cell = new PdfPCell(subtable);
        table.setTotalWidth(510);
        table.setLockedWidth(true);
        
        subtable.addCell("CONTATO: " + telefone);
        subtable.addCell("WEBSITE: " + webSite);
        
        table.addCell("ESCOLA: " + schoolName);
        table.addCell("ENDEREÇO: " + street + ", " + aptNumber + " - " + cep);
        table.addCell(cell);
        document.add(table);
        document.add(new Paragraph("\n"));
    }
}
