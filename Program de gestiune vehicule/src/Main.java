import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> vehicule;

        try (var fisierMasini=new BufferedReader(new FileReader("masini.txt")))
        {
           vehicule=fisierMasini.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       class Fisier{
            private String model;
            private Tip tip;
            private LocalDate data;
            private double distanta;
            private int kmParcursi;

           public Fisier(String model, Tip tip, LocalDate data, double distanta, int kmParcursi) {
               this.model = model;
               this.tip = tip;
               this.data = data;
               this.distanta = distanta;
               this.kmParcursi = kmParcursi;
           }

           public String getModel() {
               return model;
           }

           public void setModel(String model) {
               this.model = model;
           }

           public Tip getTip() {
               return tip;
           }

           public void setTip(Tip tip) {
               this.tip = tip;
           }

           public LocalDate getData() {
               return data;
           }

           public void setData(LocalDate data) {
               this.data = data;
           }

           public double getDistanta() {
               return distanta;
           }

           public void setDistanta(double distanta) {
               this.distanta = distanta;
           }

           public int getKmParcursi() {
               return kmParcursi;
           }

           public void setKmParcursi(int kmParcursi) {
               this.kmParcursi = kmParcursi;
           }

           @Override
           public String toString() {
               return "Fisier{" +
                       "model='" + model + '\'' +
                       ", tip=" + tip +
                       ", data=" + data +
                       ", distanta=" + distanta +
                       ", kmParcursi=" + kmParcursi +
                       '}';
           }


       }

        List<Fisier> continutFisier=new ArrayList<>();

        try(var fisier=new BufferedReader(new FileReader("trasee.txt"))){
            continutFisier=fisier.lines()
                    .map(linie->new Fisier(
                            linie.split(",")[0],
                            Tip.valueOf(linie.split(",")[1]),
                            LocalDate.of(Integer.parseInt(linie.split(",")[2]),Integer.parseInt(linie.split(",")[3]),Integer.parseInt(linie.split(",")[4])),
                            Double.parseDouble(linie.split(",")[5]),
                            Integer.parseInt(linie.split(",")[6])
                    ))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (var intrare: continutFisier)
            System.out.println(intrare.toString());

        Map<String,List<Fisier>> rezultat= new HashMap<>();

        rezultat=continutFisier.stream().collect(Collectors.groupingBy(var->var.model));
        rezultat.forEach(
                (model,listaCoresp)->
                {
                    System.out.println(model+" : " + listaCoresp.size()+"---- :"+ listaCoresp.stream().collect(Collectors.averagingInt(fisier->fisier.kmParcursi)));

                   listaCoresp.stream().forEach(
                           System.out::println

                   );
                 System.out.println(listaCoresp.stream().map(fisier->fisier.data.getMonthValue()).min((e1,e2)->Integer.compare(e1,e2)));

        });
    }
}
