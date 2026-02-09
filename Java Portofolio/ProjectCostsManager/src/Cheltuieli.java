public class Cheltuieli {
    private int codProiect;
    private String denumireCheltuiala;
    private double suma;

    public Cheltuieli(int codProiect, String denumireCheltuiala, double suma) {
        this.codProiect = codProiect;
        this.denumireCheltuiala = denumireCheltuiala;
        this.suma = suma;

    }

    public int getCodProiect() {
        return codProiect;
    }

    public void setCodProiect(int codProiect) {
        this.codProiect = codProiect;
    }

    public String getDenumireCheltuiala() {
        return denumireCheltuiala;
    }

    public void setDenumireCheltuiala(String denumireCheltuiala) {
        this.denumireCheltuiala = denumireCheltuiala;
    }

    public double getSuma() {
        return this.suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Cheltuieli{" +
                "codProiect=" + codProiect +
                ", denumireCheltuiala='" + denumireCheltuiala + '\'' +
                ", suma=" + suma +
                '}';
    }

}
