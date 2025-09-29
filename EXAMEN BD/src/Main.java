import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;




public class Main {
    public static void main(String[] args) throws Exception{

        List<Persoana> persoane = new ArrayList<>();

        File xmlFile=new File("Persoane.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        var builder=factory.newDocumentBuilder();
        var document=builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList listaPersoane= document.getElementsByTagName("Persoana");
        for(int i=0;i<listaPersoane.getLength();i++)
        {
            Node node= listaPersoane.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element elem=(Element) node;
                String nume=elem.getElementsByTagName("nume").item(0).getTextContent();
                int varsta = Integer.parseInt(elem.getElementsByTagName("varsta").item(0).getTextContent());
                float salariu = Float.parseFloat(elem.getElementsByTagName("salariu").item(0).getTextContent());

                var p=new Persoana(nume,varsta,salariu);
                persoane.add(p);
            }
        }


       persoane.forEach(System.out::println);
    }
}