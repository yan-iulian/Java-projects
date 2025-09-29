import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Map<String,Camera> camere=new HashMap<>();

       try(var fisierCamere=new BufferedReader(new FileReader("src/dataIn/camere.txt"))){
           camere=fisierCamere.lines()
                   .map(linie->new Camera(
                           linie.split(",")[0],
                           Integer.parseInt(linie.split(",")[1]),
                           Float.parseFloat(linie.split(",")[2]),
                           Integer.parseInt(linie.split(",")[3])
                   ))
                   .collect(Collectors.toMap(camera->camera.getCodCamera(), Function.identity()));
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

      /* for (var entry: camere.entrySet())
       {
           System.out.println("Codul camerei :"+entry.getKey()+" --- \n"+entry.getValue());
           if(entry.getValue().getZileOcupate()>4)
               System.out.println("Aceasta camera are un procent mare de zile ocupate pe an!\n");
       }*/

      var camereGrupate=camere.values().stream()
              .collect(Collectors.groupingBy(camera->camera.getNrPaturi()));

      camereGrupate.forEach(
              (nrPaturi,camereg)->
              {
                  int nrCamereCuAcelasiNr=camereg.size();
                  double medie=camereg.stream()
                          .mapToInt(cameragg-> cameragg.getZileOcupate()).average().orElse(0);
                  System.out.print("Camera cu "+nrPaturi+ " -> ");
                  System.out.print(nrCamereCuAcelasiNr);
                  System.out.print(" ,"+ medie+ "\n");

              }
      );



    }

}
