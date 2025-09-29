public class Produs {
    private int codProdus;
    private String denumire;
    private float pret;

    public Produs(int codProdus, String denumire, float pret) {
        this.codProdus = codProdus;
        this.denumire = denumire;
        this.pret = pret;
    }

    public Produs() {
    }

    public int getCodProdus() {
        return codProdus;
    }

    public void setCodProdus(int codProdus) {
        this.codProdus = codProdus;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "codProdus=" + codProdus +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                '}';
    }
}
