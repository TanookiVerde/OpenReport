package pdfexport;

import com.itextpdf.text.*;
import java.io.IOException;

public class c_Text extends Component {
    public String text;

    public c_Text(String text) {
        this.text = text;
        type = ComponentType.PLAIN_TEXT;
    }
    public void SetText(String txt){
        this.text = txt;
    }
    @Override
    public void print(Document document) throws IOException, DocumentException {
        Font paragraph_font = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.NORMAL);
        Paragraph p = new Paragraph(text, paragraph_font);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        document.add(new Paragraph("\n"));
    }
}
