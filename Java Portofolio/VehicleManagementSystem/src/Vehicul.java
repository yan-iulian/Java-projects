import java.util.ArrayList;
import java.util.List;

public class Vehicul  implements Evaluabil{
    public String numeModel;
    List<Traseu> trasee=new ArrayList<>();

    public Vehicul() {
    }

    public String getNumeModel() {
        return numeModel;
    }

    public void setNumeModel(String numeModel) {
        this.numeModel = numeModel;
    }

    public List<Traseu> getTrasee() {
        return trasee;
    }

    public void setTrasee(List<Traseu> trasee) {
        this.trasee = trasee;
    }

    @Override
    public String toString() {
        return "Vehicul{" +
                "numeModel='" + numeModel + '\'' +
                ", trasee=" + trasee +
                '}';
    }

    public List<Traseu> addTraseu(Traseu t)
    {
        this.trasee.add(t);
        return this.trasee;
    }

    public double valoare(){
        return 23;
    }



}

