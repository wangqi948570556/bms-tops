import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomTest {
    public static void main(String[] args)  throws ParserConfigurationException,SAXException, IOException{
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(new File("books.xml"));
    }
}
