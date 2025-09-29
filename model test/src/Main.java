import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Apartament> apartamente=new ArrayList<>();

        try ( var fisierImobil=new BufferedReader(new FileReader("imobil.txt")))
        {
            apartamente=fisierImobil.lines().map(linie->new Apartament(
                    Integer.parseInt(linie.split(",")[0]),
                    Integer.parseInt(linie.split(",")[1]),
                    Integer.parseInt(linie.split(",")[2])
            )).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int suprafata=0;
        int nrLocatari=0;
       for (var apartament: apartamente)
       {
           suprafata+=apartament.getSuprafata();
           nrLocatari+=apartament.getNrPersoane();
       }
       System.out.println("Imobilul are "+suprafata+" metrii patrati si "+nrLocatari +" locuitori");


        Map<Integer,Double> medii=apartamente.stream().collect(Collectors.groupingBy(Apartament::getNrCamere,Collectors.averagingInt(Apartament::getNrPersoane)));

        medii.forEach((i,d)->
        {
            System.out.println(i+"camere :"+ d +" persoane");

        });
    }


}
