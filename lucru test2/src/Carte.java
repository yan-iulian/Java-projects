import java.util.Optional;

public class Carte {
    private String titlu;
    private Autor autor;
    private String gen;
    private int anPublicatie;
    // getteri, setteri, constructori

    public Carte(String titlu, Autor autor, String gen, int anPublicatie) {
        this.titlu = titlu;
        this.autor = autor;
        this.gen = gen;
        this.anPublicatie = anPublicatie;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getAnPublicatie() {
        return anPublicatie;
    }

    public void setAnPublicatie(int anPublicatie) {
        this.anPublicatie = anPublicatie;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor=" + autor +
                ", gen='" + gen + '\'' +
                ", anPublicatie=" + anPublicatie +
                '}';
    }
}
