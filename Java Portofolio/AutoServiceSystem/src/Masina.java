public class Masina {
    private int cod;
    private String marca;
    private String model;
    private int an;
    private float pret;

    public Masina() {
    }

    public Masina(int cod, String marca, String model, int an, float pret) {
        this.cod = cod;
        this.marca = marca;
        this.model = model;
        this.an = an;
        this.pret = pret;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "cod=" + cod +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", an=" + an +
                ", pret=" + pret +
                '}';
    }
}
