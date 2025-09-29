public class Tranzactie {
    private int codProdusT;
    private int cantitate;
    private String tipe;

    public Tranzactie(int codProdusT, int cantitate, String tipe) {
        this.codProdusT = codProdusT;
        this.cantitate = cantitate;
        this.tipe = tipe;
    }

    public int getCodProdusT() {
        return codProdusT;
    }

    public Tranzactie() {

    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "codProdusT=" + codProdusT +
                ", cantitate=" + cantitate +
                ", tipe='" + tipe + '\'' +
                '}';
    }

    public void setCodProdusT(int codProdusT) {
        this.codProdusT = codProdusT;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
