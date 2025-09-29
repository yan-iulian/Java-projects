public class Imprumut {
    private int cod;
    private String nume;
    private int nrZile;
    private String data;

    public Imprumut(int cod, String nume, int nrZile, String data) {
        this.cod = cod;
        this.nume = nume;
        this.nrZile = nrZile;
        this.data = data;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrZile() {
        return nrZile;
    }

    public void setNrZile(int nrZile) {
        this.nrZile = nrZile;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Imprumut{" +
                "cod=" + cod +
                ", nume='" + nume + '\'' +
                ", nrZile=" + nrZile +
                ", data='" + data + '\'' +
                '}';
    }

    public Imprumut() {
    }

}
