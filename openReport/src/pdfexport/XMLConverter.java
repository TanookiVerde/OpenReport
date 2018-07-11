package pdfexport;

import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLConverter {
    public static String serializeTemplateToXML(Template t){     
        XStream xstream = new XStream();
        xstream.alias("template", Template.class);
        
        String xml = xstream.toXML(t);
        
        try (PrintWriter out = new PrintWriter("results/objects/template.xml")) {
        out.println(xml);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(XMLConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    return xml;
    } 
    public static Template deserializeTemplateFromXML(String template){
        XStream xstream = new XStream();
        xstream.alias("template", Template.class);
        
        Template t = (Template)xstream.fromXML(template);
        
        return t;
    }
}
