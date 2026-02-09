import java.util.ArrayList;
import java.util.List;

public  class FlotaGenerics<T> {

    private List<T> flota=new ArrayList<>();

    public FlotaGenerics(List<T> flota) {
        this.flota = flota;
    }

    public List<T> getFlota() {
        return flota;
    }

    public void setFlota(List<T> flota) {
        this.flota = flota;
    }

    public List<T> adaugaVehicul(T t){
        this.flota.add(t);
        return flota;
    }

    public T getVehicul(int index){
        if(index>=0&&index<this.flota.size())
        {
            return flota.get(index);

        }
        else throw new RuntimeException("Indexul nu este valid!");
    }


}
