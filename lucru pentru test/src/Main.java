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
        Map<Integer, Profesor> profesori= new HashMap<>();
        List<Programare> programari=new ArrayList<>();

        try(var fisierProfesori=new BufferedReader(new FileReader("profesori.txt")))
        {
            profesori=fisierProfesori.lines()
                    .map(linie->new Profesor(
                          Integer.parseInt(linie.split("\t")[0]),
                            linie.split("\t")[1],
                            linie.split("\t")[2],
                            linie.split("\t")[3]
                    ))
                    .collect(Collectors.toMap(Profesor::getId, Function.identity(),(prof1,prof2)->prof1));



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      /*  for (var entry : profesori.entrySet())
        {
            System.out.println(entry.getValue().toString());
        }*/

        try( var fisierProgramari=new BufferedReader(new FileReader("programari.txt"))){
            Map<Integer,Profesor> finalProfesori= profesori;
            programari=fisierProgramari.lines()
                    .map(linie->new Programare(
                            linie.split("\t")[0],
                            linie.split("\t")[1],
                            finalProfesori.get(Integer.parseInt(linie.split("\t")[2])),
                            linie.split("\t")[3],
                            linie.split("\t")[4],
                            Boolean.parseBoolean(linie.split("\t")[5]),
                            linie.split("\t")[6]

                    ))
                    .collect(Collectors.toList());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       /* for (var programare : programari)
            System.out.println(programare.toString());*/



         List<String> programari1=programari.stream()
                .filter(Programare::getEsteCurs)
                .map(Programare::getMaterie)
                 .distinct()
                .sorted().collect(Collectors.toList());

        /*for ( var materie : programari1)
            System.out.println(materie.toString());*/


       programari.stream().limit(2)
               .collect(Collectors.groupingBy(Programare::getProfesor))
               .forEach((profesor,programariProfesor)->
               {
                  System.out.printf("%35s %2d %2d\n",
                          profesor.getNumeComplet(),
                          programariProfesor.stream().filter(Programare::getEsteCurs).count(),
                          programariProfesor.stream().filter(programare->!programare.getEsteCurs()).count()
                          );

               });

       class Departament{
           private String denumire;
           private long nrActovitati;

           public Departament(String denumire, long nrActovitati) {
               this.denumire = denumire;
               this.nrActovitati = nrActovitati;
           }

           public String getDenumire() {
               return denumire;
           }

           public void setDenumire(String denumire) {
               this.denumire = denumire;
           }

           public long getNrActovitati() {
               return nrActovitati;
           }

           public void setNrActovitati(long nrActovitati) {
               this.nrActovitati = nrActovitati;
           }

           @Override
           public String toString() {
               return "Departament{" +
                       "denumire='" + denumire + '\'' +
                       ", nrActovitati=" + nrActovitati +
                       "}\n";
           }
       }

        List<Programare> finalProgramari = programari;
        List<Programare> finalProgramari1 = programari;
        programari.stream()
               .map(programare -> programare.getProfesor().getDepartament())
               .distinct()
               .map(denumire->
               {
                   long nrActivitati = finalProgramari1.stream().filter(programare ->
                           programare.getProfesor().getDepartament().equalsIgnoreCase(denumire)
                   ).count();
                       return new Departament(denumire,nrActivitati);
               }).sorted((dep1,dep2)->Long.compare(dep1.nrActovitati, dep2.nrActovitati))
                .forEach(
                        System.out::println
                );
    }
}
