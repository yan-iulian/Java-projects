import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Proiect> proiecte=new ArrayList<>();

        try ( var fisierProiecte=new BufferedReader(new FileReader("P.txt")))
        {
         proiecte=fisierProiecte.lines().map(linie->new Proiect(
                 Long.parseLong(linie.split(",")[0].trim()),
                 linie.split(",")[1].trim(),
                 Integer.parseInt(linie.split(",")[2].trim()),
                 linie.split(",")[3].trim(),
                 Double.parseDouble(linie.split(",")[4].trim()),
                 Integer.parseInt(linie.split(",")[5].trim()),
                 Double.parseDouble(linie.split(",")[6].trim()),
                 linie.split(",")[7].trim()


         )).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (var proiect :proiecte)
            System.out.println(proiect.toString());

        Map<Integer,List<Cheltuiala>> cheltuieli=new HashMap<>();

        try( var fisierCheltuieli=new BufferedReader(new FileReader("cheltuieli.txt")))
        {
            cheltuieli=fisierCheltuieli.lines().map(linie->new Cheltuiala(
                    Integer.parseInt(linie.split(",")[0].trim()),
                    linie.split(",")[1].trim(),
                    Double.parseDouble(linie.split(",")[2].trim())
            )).collect(Collectors.groupingBy(Cheltuiala::getCodProiect));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
