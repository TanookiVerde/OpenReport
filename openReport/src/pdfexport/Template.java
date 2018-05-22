package pdfexport;

import java.util.ArrayList;
import java.util.List;
import pdfexport.Component;

public class Template {
    public List<IComponent> title;
    public List<IComponent> pageheader;
    public List<IComponent> body;
    public List<IComponent> pagefooter;
    public List<IComponent> footer;
    
    public Template(List<IComponent> _title, List<IComponent> _pageheader, List<IComponent> _body, List<IComponent> _pagefooter, List<IComponent> _footer){
        title = _title;
        pageheader = _pageheader;
        body = _body;
        pagefooter = _pagefooter;
        footer = _footer;
    }
    public Template(){
        title = new ArrayList<>();
        pageheader = new ArrayList<>();
        body = new ArrayList<>();
        pagefooter = new ArrayList<>();
        footer = new ArrayList<>();
    }
}
