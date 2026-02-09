import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.json.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ParserConfigurationException, SAXException {
        List<Masina> masiniText=new ArrayList<>();
        List<Masina> masiniJson=new ArrayList<>();
        List<Masina> masiniBinar=new ArrayList<>();
        List<Masina> masiniXML=new ArrayList<>();
        List<Masina> masiniBD=new ArrayList<>();

        try(var fisierTXT=new BufferedReader(new FileReader("Masini.txt")))
        {
            masiniText=fisierTXT.lines().map(
                    linie->new Masina(
                            Integer.parseInt(linie.split(",")[0]),
                            linie.split(",")[1],
                            Boolean.parseBoolean(linie.split(",")[2]),
                            Tip.valueOf(linie.split(",")[3])
                    )
            ).toList();
        }
        //masiniText.forEach(System.out::println);

        try(var fisierMasini=new FileReader("Masini.json"))
        {
            JSONArray jsonArray=new JSONArray(new JSONTokener(fisierMasini));
            for(int i=0;i< jsonArray.length();i++)
            {
                var jMasina=jsonArray.getJSONObject(i);
                var m=new Masina(
                        jMasina.getInt("cod"),
                        jMasina.getString("marca"),
                        jMasina.getBoolean("areAsigurare"),
                        Tip.valueOf(jMasina.getString("tip"))
                );
                masiniJson.add(m);
            }
        }

       // masiniJson.forEach(System.out::println);


        try( var dos=new DataOutputStream(new FileOutputStream("Masini.bin")))
        {
            for (var masina: masiniText)
            {
                dos.writeInt(masina.getCod());
                dos.writeUTF(masina.getMarca());
                dos.writeBoolean(masina.isAreAsigurare());
                dos.writeUTF(String.valueOf(masina.getTip()));
            }
        }

        try(var dis=new DataInputStream(new FileInputStream("Masini.bin")))
        {
            while(dis.available()>0)
            {
                var m=new  Masina(
                  dis.readInt(),
                  dis.readUTF(),
                  dis.readBoolean(),
                  Tip.valueOf(dis.readUTF())
                );
                masiniBinar.add(m);
            }
        }
      //  masiniBinar.forEach(System.out::println);

        final String url="jdbc:sqlite:Masini.db";

        try (var conn=DriverManager.getConnection(url);
        var statement=conn.createStatement()){

            String select= """
                    Select * from Masini;
                    """;
            var result=statement.executeQuery(select);
            while(result.next())
            {
                var m=new Masina(
                        result.getInt(1),
                        result.getString(2),
                        result.getBoolean(3),
                        Tip.valueOf(result.getString(4))
                );
                masiniBD.add(m);
            }

        }
        //masiniBD.forEach(System.out::println);

        File fisierMasini=new File("Masini.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(fisierMasini);
        document.getDocumentElement().normalize();

        //te uiti in fisier , tot fisierul e o lista de noduri cu denumirea data
        NodeList listaMasiniXML=document.getElementsByTagName("Masina");
        for(int i=0;i< listaMasiniXML.getLength();i++)
        {
            Node nod=listaMasiniXML.item(i);

            Element element=(Element) nod;  //faci cast la element fiindca nu merge cu Nod
            int cod=Integer.parseInt(element.getElementsByTagName("cod").item(0).getTextContent());
            String marca=element.getElementsByTagName("marca").item(0).getTextContent();
            boolean areAsigurare=Boolean.parseBoolean(element.getElementsByTagName("areAsigurare").item(0).getTextContent());
            Tip tip=Tip.valueOf(element.getElementsByTagName("tip").item(0).getTextContent());
            var m=new Masina(cod,marca,areAsigurare,tip);
            masiniXML.add(m);
        }

        masiniXML.forEach(System.out::println);

        try(ServerSocket serverSocket=new ServerSocket(3333);
            Socket socket=serverSocket.accept();
            var out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            var in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){

        }

        try(var fisierText=new BufferedReader(new FileReader("...")))
        {

        }

        try(var dos=new DataOutputStream(new FileOutputStream("..."))){

        }

        try(var fisierJSON=new FileReader("...")) {
            JSONArray jsonArray = new JSONArray(new JSONTokener(fisierJSON));
            for (int i = 0; i < jsonArray.length(); i++)
            {
                var masinJSON=jsonArray.getJSONObject(i);
                var masina=new Masina();
                //...
            }
        }
        final String url2="jdbc:sqlite:nume.db";
        try(var conn=DriverManager.getConnection(url);
        var statement=conn.createStatement())
        {
            String comanda;
            statement.executeUpdate(comanda);//update , insert,delete, create
            statement.executeQuery(comanda);//select , intoarce un resutSet , pe care il folosesti cu next()
            PreparedStatement ps=conn.prepareStatement(comanda);
            ps.setString(1,"Test");
            ps.executeUpdate();


        }

        File xmlFile=new File("masini.xml");
        DocumentBuilderFactory factoryy=DocumentBuilderFactory.newInstance();
        DocumentBuilder builderr=factory.newDocumentBuilder();
        Document documentt=builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList listaXLM=document.getElementsByTagName("Masina");
        for(int i=0;i<listaXLM.getLength();i++)
        {
            Node nod=listaXLM.item(i);
            Element element=(Element)  nod;

            String denumire=element.getElementsByTagName("denumire").item(0).getTextContent();
            //...

        }

        try(ServerSocket serverSocket=new ServerSocket(3333);
        Socket socket=serverSocket.accept();
        var in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

        }

        try(Socket socket=new Socket("localhost",3333);
        )

            
    }
}
