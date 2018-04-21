package pdfexport;

import java.util.List;

public class Template {
    public List<Component> title;
    public List<Component> pageheader;
    public List<Component> body;
    public List<Component> pagefooter;
    public List<Component> footer;
    
    public Template(){
        //NOTHING
    }
    public String serializeTemplateToXML(){
        //TODO
        return "this_class_in_xml";
    }
    public void deserializeTemplateFromXML(String template){
        //TODO
    }
}
