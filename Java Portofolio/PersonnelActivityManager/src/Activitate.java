public class Activitate {
    private int idPersoana;
    private String tip;
    private int durata;
    private double cost;

    public Activitate(int idPersoana, String tip, int durata, double cost) {
        this.idPersoana = idPersoana;
        this.tip = tip;
        this.durata = durata;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Activitate{" +
                "idPersoana=" + idPersoana +
                ", tip='" + tip + '\'' +
                ", durata=" + durata +
                ", cost=" + cost +
                '}';
    }

    public Activitate() {
    }

    public int getIdPersoana() {
        return idPersoana;
    }

    public void setIdPersoana(int idPersoana) {
        this.idPersoana = idPersoana;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public  double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
