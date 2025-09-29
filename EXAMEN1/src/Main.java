import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import org.json.*;

public class Main {
    public static void main(String[] args) {

        List<Produs> produse=new ArrayList<>();
        List<Tranzactie> tranzactii=new ArrayList<>();

        try(var fileProduse=new BufferedReader(new FileReader("Produse.txt")))
        {
            produse=fileProduse.lines().map(linie->new Produs(
                   Integer.parseInt(linie.split(",")[0]),
                    linie.split(",")[1],
                    Float.parseFloat(linie.split(",")[2])
            )).collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    produse.forEach(System.out:: println);

        try( var fisierTranzactii=new FileReader("Tranzactii.txt")){

            JSONArray jsonArray=new JSONArray(new JSONTokener(fisierTranzactii));
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                Tranzactie t=new Tranzactie(
                        obj.getInt("codProdus"),
                        obj.getInt("cantitate"),
                        obj.getString("tip")

                );
                tranzactii.add(t);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tranzactii.stream().forEach(System.out:: println);

        System.out.printf("\n\n\n");

        int a= (int) produse.stream().count();
        System.out.println("Sunt "+a+" produse!");

        produse.stream().sorted(Comparator.comparing(Produs::getDenumire)).forEach(System.out::println);

        Map<Integer,List<Tranzactie>> den_produse=tranzactii.stream().collect(Collectors.groupingBy(Tranzactie::getCodProdusT));
        var den_prod2=den_produse.entrySet().stream().collect(Collectors.toMap(
                entry->entry.getKey(),
                entry->entry.getValue().size()
        ));

        Map<Integer,String> idToDen=produse.stream().collect(Collectors.toMap(
                entry->entry.getCodProdus(),
                entry->entry.getDenumire()
        ));

        Map<String, Integer> finalC=den_prod2.entrySet().stream().collect(Collectors.toMap(
                entry->idToDen.get(entry.getKey()),
                entry->entry.getValue()
        ));

        System.out.printf("%-30s %-10s\n", "Denumire","Nr tranzactii");
        for (var entry: finalC.entrySet())
        {
            System.out.printf("%-30s %10d\n", entry.getKey(), entry.getValue());
        }

        try(BufferedWriter writer=new BufferedWriter(new FileWriter("lista2.txt")))
        {
            writer.write("Denumire              Numar tranzactii\n");
            for(var entry: finalC.entrySet())
            {
                writer.write(entry.getKey()+"      "+ entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int s1=tranzactii.stream().filter(tranzactie -> tranzactie.getTipe().equalsIgnoreCase("intrare"))
                        .mapToInt(tranzactie->tranzactie.getCantitate()).sum();
        int s2=tranzactii.stream().filter(tranzactie -> tranzactie.getTipe().equalsIgnoreCase("iesire"))
                .mapToInt(tranzactie->tranzactie.getCantitate()).sum();
        System.out.println("Sunt in total "+ s1+ " stocuri intrare");
        System.out.println("Sunt in total "+ s2+ " stocuri iesire");
        System.out.println("Sunt in total "+ (s1-s2)+ " stocuri existente");




    }
}
