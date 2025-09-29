import java.util.HashMap;

public class Banca {
     final private int id=1;
     private HashMap<String,Float> client;

    public int getId() {
        return id;
    }



    public HashMap<String, Float> getClient() {
        return client;
    }

    public void setClient(HashMap<String, Float> client) {
        this.client = client;
    }


    public Banca() {
        this.client=new HashMap<>();
    }

    public Banca( HashMap<String, Float> client) {
        //this.client =new HashMap<>(client); asa nu pentru ca se aloca zona separata de memeorie
        //si copiaza ce e in momentul rularii la adresa unde se gaseste clientii, dar invers partajeaza
        //aceeasi zona de memorie si orice operatie facuta asupra clienti va afecta inclusiv banca
        this.client =client;
    }

    public  String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("Banca are id ul final : ");
        builder.append(this.id);
        builder.append(" si urmatorii clienti: \n");
        for (var entry: client.entrySet())
        {
            builder.append("Nume :");
            builder.append(entry.getKey());
            builder.append(" , suma in cont : ");
            builder.append(entry.getValue());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    HashMap<String,Float> modifica_bani(String nume, float suma){
        int gasit=0;
            for(var entry: this.client.entrySet()) {
                if(nume.equalsIgnoreCase(entry.getKey())) {
                    gasit=1;
                    float valoare= entry.getValue();
                    if(suma<0)
                        valoare-=suma;
                             else valoare+=suma;
                    this.client.put(entry.getKey(),valoare);
                }

            }
            if(gasit==0)
             System.out.println("Nu a fost gasit persoana cu acest cont bancar!");
           return this.client;
        }



     }




