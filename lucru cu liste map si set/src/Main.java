import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        HashMap<String,Float> clienti=new HashMap<>();
        Banca banca=new Banca(clienti);
        clienti.put("Ioana", 3500F);
        clienti.put("Alexandra",3000F);
        clienti.put("Oana",2500F);
        clienti.put("Nicusor",10000F);
       // Banca banca=new Banca(clienti); asa faceam in cazul in care in constructor aveam cu new hashmap(clienti)

        System.out.println(banca.toString());
        System.out.println();





    }
}
