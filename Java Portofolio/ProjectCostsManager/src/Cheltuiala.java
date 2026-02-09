public class Cheltuiala {
    private int codProiect;
    private String denumireCheltuiala;
    private double suma;

    public Cheltuiala(int codProiect, String denumireCheltuiala, double suma) {
        this.codProiect = codProiect;
        this.denumireCheltuiala = denumireCheltuiala;
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Cheltuiala{" +
                "codProiect=" + codProiect +
                ", denumireCheltuiala='" + denumireCheltuiala + '\'' +
                ", suma=" + suma +
                '}';
    }

    public int getCodProiect() {
        return codProiect;
    }

    public String getDenumireCheltuiala() {
        return denumireCheltuiala;
    }

    public double getSuma() {
        return suma;
    }
}
