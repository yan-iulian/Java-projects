import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.*;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Persoana> persoane=new ArrayList<>();
        List <Activitate> activitati=new ArrayList<>();

        try(var fisierPersoane=new BufferedReader(new FileReader("Persoane.txt")))
        {
            persoane=fisierPersoane.lines().map(
                    linie->new Persoana(
                            Integer.parseInt(linie.split(",")[0]),
                            linie.split(",")[1],
                            Integer.parseInt(linie.split(",")[2]),
                            Double.parseDouble(linie.split(",")[3])
                    )
            ).toList();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Cerinta 1: \nIn fisier sunt : "+persoane.size()+" persoane.\n");


        System.out.println("Cerinta 2: ");
        persoane.stream().sorted((p1,p2)->Double.compare(p2.getSalariu(),p1.getSalariu())).forEach(System.out::println);

        System.out.println("Cerinta 3:\n\n");

        try(var fisierActivitati=new FileReader("Activitati.json"))
        {
            JSONArray jsonArray=new JSONArray(new JSONTokener(fisierActivitati));
            for(int i=0;i< jsonArray.length();i++)
            {
                var jsonActivitate=jsonArray.getJSONObject(i);
                var activitate=new Activitate(
                        jsonActivitate.getInt("idPersoana"),
                        jsonActivitate.getString("tip"),
                        jsonActivitate.getInt("durata"),
                        jsonActivitate.getDouble("cost")
                );
                activitati.add(activitate);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        record ClasaRec(String nume, long nrActivitati, double  cost){}

       List<ClasaRec> listaDeTiparit = persoane.stream().map(
                persoana->
                {
                    String nume=persoana.getNume();
                    long nrActivitati=activitati.stream().filter(activitate->activitate.getIdPersoana()==persoana.getId()).count();
                    double costTotal=activitati.stream().filter(activitate->activitate.getIdPersoana()==persoana.getId()).mapToDouble(Activitate::getCost).sum();
                    return new ClasaRec(nume,nrActivitati,costTotal);

                }

        ).sorted((c1,c2)->Double.compare(c2.cost,c1.cost)).toList();


        try(var writer=new BufferedWriter(new FileWriter("Raport.txt")))
        {
            writer.write(String.format("%-30s %-10s %-20s\n\n","Nume persoana","Nr activitati","Cost total"));
            for(var raport:listaDeTiparit)
            {
                    writer.write(String.format("%-30s %-10d %-20.2f\n",raport.nume,raport.nrActivitati,raport.cost));
            }
            System.out.println("Fisierul Raport.txt a fost tiparit cu succes.\n");
        }

        System.out.println("Cerinta 4: \n\n");
        double suma=activitati.stream().mapToDouble(Activitate::getCost).sum();
        System.out.println("Suma totala investita in activitati este de : "+suma+" lei.");

        System.out.println("Cerinta 5:\n\n");

        final String host="localhost";
        final int port=3333;

        try(ServerSocket serverSocket=new ServerSocket(port);
            var server=serverSocket.accept();
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
            BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));


                )
        {
         String mesaj= in.readLine();
         int cod=Integer.parseInt(mesaj);
        }


    }
}
