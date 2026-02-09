public class Persoana {
    private int id;
    private String nume;
    private int varsta;
    private double salariu;

    public Persoana(int id, String nume, int varsta, double salariu) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
    }

    public Persoana() {
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", salariu=" + salariu +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
}
