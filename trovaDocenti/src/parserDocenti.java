
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mariconti_giacomo
 */
public class parserDocenti {
    
    private List docenti;

    public parserDocenti() {
        docenti = new ArrayList();
    }

    public List parseDocument(String filename)throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        String doc;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "tr"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                doc=getTextvalue((Element) nodelist.item(i),"td");
                docenti.add(doc);
            }
        }
        return docenti;
    }
    
    public Docente getDocente(Element element){
        Docente docente;
        String numero=getTextvalue(element, "tr");
        String nome=getTextvalue(element, "tr");
        String ora=getTextvalue(element, "tr");
        String note=getTextvalue(element, "tr");
        docente=new Docente(numero,nome,ora,note);
        return docente;
    } 
    
    private String getTextvalue(Element element,String tag){
        String tmp= "";
        NodeList nodelist;
        nodelist= element.getElementsByTagName(tag);
        if(nodelist!=null && nodelist.getLength()>0){
        docenti.add(element);
            for(int i=0; i<nodelist.getLength();i++){
                element=(Element)nodelist.item(i);  
                if(element!=null && element.getFirstChild()!=null){
                    tmp+= element.getFirstChild().getNodeValue()+" ";
                }
            }   
        }
        return tmp;
    }
}

