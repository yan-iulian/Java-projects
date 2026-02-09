import java.util.ArrayList;
import java.util.List;

public class Carte implements Readable{

    private String autor;
    private String titlu;
    private Genre gen;
    private int nrPagini;




    public Carte(String autor, String titlu, Genre gen, int nrPagini) {
        this.autor = autor;
        this.titlu = titlu;
        this.gen = gen;
        this.nrPagini = nrPagini;

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Genre getGen() {
        return gen;
    }

    public void setGen(Genre gen) {
        this.gen = gen;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }





    @Override
    public String toString() {
        return "Carte{" +
                "autor='" + autor + '\'' +
                ", titlu='" + titlu + '\'' +
                ", gen=" + gen +
                ", nrPagini=" + nrPagini +

                '}';
    }

    @Override
    public void readSummary(){
        System.out.println("Am afisat rezumatul!");
    }

}
