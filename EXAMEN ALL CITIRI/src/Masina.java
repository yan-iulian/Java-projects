public class Masina {
    private int cod;
    private String marca;
    private boolean areAsigurare;
    private Tip tip;

    public Masina() {
    }

    public Masina(int cod, String marca, boolean areAsigurare, Tip tip) {
        this.cod = cod;
        this.marca = marca;
        this.areAsigurare = areAsigurare;
        this.tip = tip;
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

    public boolean isAreAsigurare() {
        return areAsigurare;
    }

    public void setAreAsigurare(boolean areAsigurare) {
        this.areAsigurare = areAsigurare;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "cod=" + cod +
                ", marca='" + marca + '\'' +
                ", areAsigurare=" + areAsigurare +
                ", tip=" + tip +
                '}';
    }


}
