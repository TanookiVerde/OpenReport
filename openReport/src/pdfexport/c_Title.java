package pdfexport;

import com.itextpdf.text.*;
import java.io.IOException;

public class c_Title extends Component{
    public String title;
    public String subtitle;
    
    public c_Title(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }
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
}
