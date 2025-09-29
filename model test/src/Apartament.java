public class Apartament {
    private int nr;
    private int suprafata;
    private int nrPersoane;

    private final int suprafataCamera=20;

    public Apartament(int nr, int suprafata, int nrPersoane) {
        this.nr = nr;
        this.suprafata = suprafata;
        this.nrPersoane = nrPersoane;


    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "nr=" + nr +
                ", suprafata=" + suprafata +
                ", nrPersoane=" + nrPersoane +
                '}';
    }

    public  int getNrCamere(){
        return this.suprafata/this.suprafataCamera;
    }

}
