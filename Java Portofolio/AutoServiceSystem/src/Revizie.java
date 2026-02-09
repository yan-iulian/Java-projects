public class Revizie {
    private int id;
    private String data;
    private double cost;
    private String tip;

    public Revizie() {
    }

    public Revizie(int id, String data, double cost, String tip) {
        this.id = id;
        this.data = data;
        this.cost = cost;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Revizie{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", cost=" + cost +
                ", tip='" + tip + '\'' +
                '}';
    }
}
