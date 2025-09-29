import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.json.*;

public class Main {
    public static void main(String[] args) {
        List<Carte> carti = new ArrayList<>();
        List<Imprumut> imprumuturi = new ArrayList<>();

        System.out.println("CERINTA 1: \n");
        try (var fisierCarti = new BufferedReader(new FileReader("Carti.txt"))) {
            carti = fisierCarti.lines().map(linie ->
                    new Carte(
                            Integer.parseInt(linie.split(",")[0]),
                            linie.split(",")[1],
                            linie.split(",")[2],
                            Float.parseFloat(linie.split(",")[3]),
                            Integer.parseInt(linie.split(",")[4])
                    )).collect(Collectors.toList());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var fisierImprumuturi = new FileReader("Imprumuturi.json")) {
            JSONArray jsonArray = new JSONArray(new JSONTokener(fisierImprumuturi));
            for (int i = 0; i < jsonArray.length(); i++) {
                var jCarte = jsonArray.getJSONObject(i);
                var imprumut = new Imprumut(
                        jCarte.getInt("codCarte"),
                        jCarte.getString("numeCititor"),
                        jCarte.getInt("zileImprumut"),
                        jCarte.getString("dataImprumut")
                );
                imprumuturi.add(imprumut);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Nr cartilor este de " + carti.size() + " carti.");
        System.out.println("\nCERINTA 2: \n");

        long a = imprumuturi.stream().filter(imprumut -> imprumut.getData().split("-")[1].equalsIgnoreCase("12"))
                .count();

        System.out.println("Numarul de carti imprumutate in decembrie 2024 este : " + a);

        System.out.println("\nCERINTA 3: \n");

        // carti.stream().sorted(Comparator.comparing(Carte::getAnPublicare)).forEach(System.out::println);

        carti.stream().sorted((c1, c2) -> Integer.compare(c1.getAnPublicare(), c2.getAnPublicare())).forEach(System.out::println);

        System.out.println("\nCERINTA 4: \n");
        carti.stream().sorted(Comparator.comparing(Carte::getTitlu)).forEach(System.out::println);


        System.out.println("\nCERINTA 5: \n");

        double s = carti.stream().collect(Collectors.summingDouble(Carte::getPret));
        System.out.println("Suma totala este " + s);

        double s2 = carti.stream().mapToDouble(Carte::getPret).sum();
        System.out.println("Suma totala este " + s2);

        double s3 = carti.stream().filter(carte -> carte.getAnPublicare() > 2000).mapToDouble(Carte::getPret).sum();
        System.out.println("Suma totala a cartilor cu anul de publicatie peste 2000 este:  " + s3);


        record Raport(String titlu, long nrImprumuturi, int nrZile) implements Serializable {
        }
        List<Raport> raport = carti.stream().map(carte ->
                {
                    String denumire = carte.getTitlu();
                    long nrImprumuturi = imprumuturi.stream().filter(imprumut -> imprumut.getCod() == carte.getCod()).count();
                    int nrZile = imprumuturi.stream().filter(imprumut -> imprumut.getCod() == carte.getCod()).mapToInt(Imprumut::getNrZile).sum();
                    return new Raport(denumire, nrImprumuturi, nrZile);
                }
        ).sorted(Comparator.comparingLong(Raport::nrImprumuturi).reversed()).toList();

//        for (var list:raport)
//            System.out.println(list);

        try (var bw = new BufferedWriter(new FileWriter("raport.txt"))) {
            bw.write(String.format("%-19s %-30s %-30s\n\n", "Nr imprumuturi", "Titlu", "Nr zile imprumut"));
            for (var rec : raport) {
                bw.write(String.format("%-19s %-30s %-30s\n", rec.nrImprumuturi, rec.titlu, rec.nrZile));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\nCERINTA 6: SERIALIZARE SI DESERIALIZARE\n");

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("record.bin")))
        {

            for(var carte:carti)
                if (carte.getAnPublicare()>1950)
                {
                    dos.writeInt(carte.getCod());
                    dos.writeUTF(carte.getTitlu());
                    dos.writeUTF(carte.getAutor());
                    dos.writeFloat(carte.getPret());
                    dos.writeInt(carte.getAnPublicare());
                }
            System.out.println("S a realizat serializarea!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Carte> cartiDinFisierBinar=new ArrayList<>();
        try(DataInputStream dis=new DataInputStream(new FileInputStream("record.bin")))
        {
            while(dis.available()>0)
            {
                Carte c=new Carte(
                        dis.readInt(),
                        dis.readUTF(),
                        dis.readUTF(),
                        dis.readFloat(),
                        dis.readInt()
                );
                cartiDinFisierBinar.add(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Deserializarea fisierului este :");
        cartiDinFisierBinar.stream().forEach(System.out::println);
        System.out.println("ULTIMA CERINTA:\n");

       final int port=3333;
       new Thread(()-> {
           try (
                   ServerSocket serverSocket = new ServerSocket(port);
                   Socket socket = serverSocket.accept();
                   BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                   BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           ) {

               int codPrimit = Integer.parseInt(in.readLine());
               int nr = imprumuturi.stream().filter(imprumut -> imprumut.getCod() == codPrimit).findFirst().orElse(null).getNrZile();
               out.write(String.valueOf(nr));
               out.newLine();
               out.flush();

           } catch (IOException e) {
               throw new RuntimeException(e);
           }


           System.out.println("Serverul a fost creeat cu succes!");

       }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try(
               Socket socket=new Socket("localhost",port);
               BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
               BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
       )
       {
            int codTrimis=2;
            out.write(String.valueOf(codTrimis));
            out.newLine();
            out.flush();
            String raspuns=in.readLine();
            int nrZile=Integer.parseInt(raspuns);
            System.out.println("Cartea cu codul 2 a fost imprumutata "+nrZile +" zile!");
       }
       catch (UnknownHostException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
