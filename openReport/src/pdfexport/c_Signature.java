package pdfexport;

import com.itextpdf.text.*;
import java.io.IOException;

public class c_Signature extends Component{
    public String name;
    public String role;
     
    public c_Signature(String _name, String _role){
         name = _name;
         role = _role;
     }
    @Override
    public void print(Document document) throws IOException, DocumentException {        
        Font lineName_font = FontFactory.getFont(FontFactory.HELVETICA, 12, null);
        Chunk line_chunk = new Chunk("_______________________________________________________", lineName_font);
        Paragraph line_paragraph = new Paragraph(line_chunk);
        line_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(line_paragraph);
        
        Chunk name_chunk = new Chunk(name, lineName_font);
        Paragraph name_paragraph = new Paragraph(name_chunk);
        name_paragraph.setFont(lineName_font);
        name_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(name_paragraph);
        
        Font subtitle_font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC);
        Chunk subtitle_chunk = new Chunk(role, subtitle_font);
        Paragraph subtitle_paragraph = new Paragraph(subtitle_chunk);
        subtitle_paragraph.setFont(subtitle_font);
        subtitle_paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(subtitle_paragraph);
    }
}
