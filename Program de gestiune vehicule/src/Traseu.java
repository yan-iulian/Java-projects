import java.time.LocalDate;

public final class Traseu {
    private final Tip tipTraseu;
    private final  LocalDate data;
    private final  double distanta;
    private final int kmParcursi;

    public Tip getTipTraseu() {
        return tipTraseu;
    }

    public LocalDate getData() {
        return data;
    }

    public double getDistanta() {
        return distanta;
    }

    public int getKmParcursi() {
        return kmParcursi;
    }

    public Traseu(Tip tipTraseu, LocalDate data, double distanta, int kmParcursi) {
        this.tipTraseu = tipTraseu;
        this.data = data;
        this.distanta = distanta;
        this.kmParcursi = kmParcursi;
    }

    @Override
    public String toString() {
        return "Traseu{" +
                "tipTraseu=" + tipTraseu +
                ", data=" + data +
                ", distanta=" + distanta +
                ", kmParcursi=" + kmParcursi +
                '}';
    }

}
