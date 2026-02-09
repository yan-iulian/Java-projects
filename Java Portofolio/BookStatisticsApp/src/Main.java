import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static <T extends Serializable> T citire(String filePath, Carte obj) throws FileNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (T) in.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<Carte> carti=new ArrayList<>();

        try(var fisierCitire=new BufferedReader(new FileReader("carti.txt")))
        {
            carti=fisierCitire.lines()
                    .map(linie-> new Carte(
                            linie.split(",")[0],
                            linie.split(",")[1],
                            Genre.valueOf(linie.split(",")[2]),
                            Integer.parseInt(linie.split(",")[3])
                    )).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for ( var carte : carti )
            System.out.println(carte.toString());
            System.out.println("\n\n");
        carti.stream().filter(carte-> carte.getNrPagini()>400).forEach(System.out:: println);

        carti.stream().map(carte-> carte.getAutor().length()).collect(Collectors.toList()).forEach(System.out::println);

        Map<String , Optional<Carte>> carti1=carti.stream().collect(Collectors.groupingBy(carte-> carte.getAutor(),Collectors.maxBy(Comparator.comparingInt(Carte::getNrPagini))));

        for(var entry : carti1.entrySet()){
            System.out.printf("Autor %s are maximul de nr pe carte de %s",entry.getKey(),entry.getValue().);
        }
    }
}
