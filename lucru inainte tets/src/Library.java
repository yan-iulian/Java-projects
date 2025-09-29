import java.util.ArrayList;
import java.util.List;

public class Library<T extends Readable> {

    private List<T> carti=new ArrayList<>();

    public Library(List<T> carti) {
        this.carti = carti;
    }

    public List<T> getCarti() {
        return carti;
    }

    public void setCarti(List<T> carti) {
        this.carti = carti;
    }

    public void addItem(T carte)
    {
        this.carti.add( carte);
    }



}
