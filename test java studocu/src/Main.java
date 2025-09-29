import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Element> elemente=new ArrayList<>();

        try(var fisierElemente=new BufferedReader(new FileReader("src.//matricerara.txt"))){
            elemente=fisierElemente.lines()
                    .map(linie->new Element(
                            Integer.parseInt(linie.split(",")[0]),
                            Integer.parseInt(linie.split(",")[1]),
                            Double.parseDouble(linie.split(",")[2])

                    )).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int nrElementeNegative=0;
        for (var element : elemente) {
            if(element.getValoare()<0)
                nrElementeNegative++;
            System.out.println(element.toString());
        }
        System.out.println("Matricea contine "+nrElementeNegative+" elemente negative!");

        double sumaColoana1=0;
        double sumaColoana2=0;
        double sumaColoana3=0;
        for(var element :elemente)
        {
           sumaColoana1+=element.getIndexLinie();
           sumaColoana2+=element.getIndexColoana();
           sumaColoana3+=element.getValoare();
        }
      // System.out.println(elemente.size());
        System.out.println("1:"+sumaColoana1/elemente.size());
        System.out.println("2:"+sumaColoana2/elemente.size());
        System.out.println("3:"+sumaColoana3/elemente.size());



    }
}
