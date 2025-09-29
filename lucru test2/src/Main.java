import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Autor> autori=new ArrayList<>();
        Map<String, Carte> carti=new HashMap<>();

        try(var fisierAutori=new BufferedReader(new FileReader("src.\\autori.txt"))){
            autori=fisierAutori.lines()
                    .map(linie-> new Autor(
                            linie.split(";")[0],
                            linie.split(";")[1]
                    ))
                    .collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(var autor : autori )
            System.out.println(autor.toString());


        try(var fisierCarti=new BufferedReader(new FileReader("src.//carti.txt")))
        {
            List<Autor> finalAutori = autori;
            carti=fisierCarti.lines()
                    .map(linie->new Carte(
                            linie.split(";")[0],
                            finalAutori.stream()
                                    .filter(autor -> autor.getNumeComplet().equalsIgnoreCase(linie.split(";")[1])) // căutăm autorul
                                    .findFirst() // extragem autorul corespunzător
                                    .orElseThrow(() -> new RuntimeException("Autorul nu a fost găsit: " + linie.split(";")[1])), // aruncăm excepție dacă nu găsim autorul
                            linie.split(";")[2],
                            Integer.parseInt(linie.split(";")[3])
                    )).collect(Collectors.toMap(carte-> carte.getAutor().getNumeComplet(),carte->carte, (carte1,carte2)->carte1));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (var carte: carti.entrySet())
            System.out.println(carte.getValue().toString());

        System.out.printf("%35s  Numar carti"," Nume autor");

        Map<String, List<Carte>> cartiPeAutor=carti.values().stream()
                .collect(Collectors.groupingBy(carte->carte.getAutor().getNumeComplet()));

        cartiPeAutor.entrySet().stream()
                .sorted(
                        (e1,e2)->Integer.compare(e1.getValue().size(),e2.getValue().size()
                        ))
                .forEach(entry->
                   //     System.out.printf("%35s %2d\n" ,entry.getKey(),entry.getValue().size()));
                    System.out.println(entry.getKey()+"    ------    "+entry.getValue().size()));

        List<Imprumut> imprumuturi=new ArrayList<>();
        try (var fisierImprumuturi=new BufferedReader(new FileReader("src.//imprumuturi.txt"))){
            Map<String, Carte> finalCarti = carti;
            imprumuturi=fisierImprumuturi.lines()
                    .map(linie->new Imprumut(
                            finalCarti.entrySet().stream().filter(entry->entry.getValue().getTitlu().equalsIgnoreCase(linie.split(";")[0]))
                                    .findFirst().orElseThrow( ()->new RuntimeException("Exceptie!")),
                            LocalDate.parse(linie.split(";")[1]),
                            LocalDate.parse(linie.split(";")[2])
                    ))
                    .toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (var imprumut : imprumuturi)
            System.out.println(imprumut.toString());
    }
}
