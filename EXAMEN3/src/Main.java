import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.json.*;

public class Main {
    public static void main(String[] args) {

        List<Masina> masini=new ArrayList<>();
        List<Revizie> revizii=new ArrayList<>();

        try(var fisierMasini=new BufferedReader(new FileReader("Masini.txt")))
        {

            masini=fisierMasini.lines().map(linie->
                    new Masina(
                            Integer.parseInt(linie.split(",")[0]),
                            linie.split(",")[1],
                            linie.split(",")[2],
                            Integer.parseInt(linie.split(",")[3]),
                            Float.parseFloat(linie.split(",")[4])
                    )).collect(Collectors.toList());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var fisierRevizii=new FileReader("revizii.json"))
        {

            JSONArray jsonArray=new JSONArray(new JSONTokener(fisierRevizii));
            for (int i=0;i<jsonArray.length();i++)
            {
                var jRezivie=jsonArray.getJSONObject(i);
                var revizie=new Revizie(
                        jRezivie.getInt("idMasina"),
                        jRezivie.getString("data"),
                        jRezivie.getDouble("cost"),
                        jRezivie.getString("tip")
                );
                revizii.add(revizie);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //revizii.forEach(System.out::println);

        System.out.println("Cerinta 1: Sunt "+masini.size()+" masini in lista.\n");

        System.out.println("Cerinta 2: \n");

        masini.stream().sorted(Comparator.comparingInt(Masina::getAn).reversed()).forEach(System.out::println);


        System.out.println("Cerinta 3:\n");

        record Revizii(String marca, String model, long nrRevizii, double costTotal){}

        List<Revizii> reviziiSortate=masini.stream().map(
                masina->{
                    long nr=revizii.stream().filter(revizie->revizie.getId()== masina.getCod()).count();
                    double costTotal=revizii.stream().filter(
                            revizie->
                                revizie.getId()==masina.getCod()).mapToDouble(Revizie::getCost).sum();
                    return new Revizii(masina.getMarca(),masina.getModel(),nr,costTotal);
                }
        ).sorted((r1,r2)->Double.compare(r2.costTotal,r1.costTotal)).toList();

        try(var bw=new BufferedWriter(new FileWriter("raport.txt"))){

            bw.write(String.format("%-30s %-20s %-15s %-15s\n\n","Marca","Model","Numar revizii","Cost total"));
            for (var rev:reviziiSortate)
            {
                bw.write(String.format("%-30s %-20s %-15s %-15s\n",rev.marca,rev.model,rev.nrRevizii,rev.costTotal));
            }
            System.out.println("Fisierul a fost creeat cu succces!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Cerinta 4: \n");

        double sumaPreturi=masini.stream().mapToDouble(masina->masina.getPret()).sum();
        double sumaRevizii= revizii.stream().mapToDouble(revizie -> revizie.getCost()).sum();

        System.out.println("Suma totala investita in parc este : "+(sumaPreturi+sumaRevizii) +" lei.");


        System.out.println("Cerinta 5: \n");

        final int port=3333;
        final String host="localhost";


//server
        List<Masina> finalMasini = masini;
        Thread t= new Thread(()-> {
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            ) {
                Masina m=new Masina(0,"-","-",0,0);
                String mesaj = in.readLine();
                int mesajTradus = Integer.parseInt(mesaj);
                String marca = finalMasini.stream().filter(masina -> masina.getCod() == mesajTradus).findFirst().orElse(m).getMarca();
                Revizii r = reviziiSortate.stream().filter(rv -> rv.marca.equalsIgnoreCase(marca)).findFirst().orElse(new Revizii("-","-",0,0));


                out.write(String.format("Marca: %2s\t  Model: %s\t  Nr revizii: %3d\t  Cost total revizii: %6.2f\t",
                        r.marca, r.model, r.nrRevizii, r.costTotal));
                out.newLine();
                out.flush();

                System.out.printf("Server: Am primit codul %d, afisez:\n",mesajTradus);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        t.start();
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //client
        try(Socket socket=new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Introduceti un cod: \n");
            int cod=scanner.nextInt();
            out.write(String.valueOf(cod));
            out.newLine();
            out.flush();

                System.out.printf("Client: Am trimis codul %d...\n",cod);
                String mesaj = in.readLine();
                System.out.println(mesaj);



        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Cerinta 6 (suplimentar serializare si deserializare):\n");

        List<Masina> listaPtrSerializare=masini.stream().filter(masina->masina.getAn()>2020).toList();
        try(var dos= new DataOutputStream(new FileOutputStream("fisierSerializat.bin")))
        {
            for(var masina:listaPtrSerializare)
            {
                dos.writeInt(masina.getCod());
                dos.writeUTF(masina.getMarca());
                dos.writeUTF(masina.getModel());
                dos.writeInt(masina.getAn());
                dos.writeFloat(masina.getPret());
            }
            System.out.println("Serializarea a avut loc cu succes!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Masina> masiniDinFisierBinar=new ArrayList<>();
    try(DataInputStream dis=new DataInputStream(new FileInputStream("fisierSerializat.bin")))
    {

        while(dis.available()>0)
        {
            var Masina=new Masina(
                    dis.readInt(),
                    dis.readUTF(),
                    dis.readUTF(),
                    dis.readInt(),
                    dis.readFloat()
            );
            masiniDinFisierBinar.add(Masina);

        }
        System.out.println("\nDeserializarea s a realizat cu succes!");
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    masiniDinFisierBinar.stream().forEach(System.out::println);
    }


}
