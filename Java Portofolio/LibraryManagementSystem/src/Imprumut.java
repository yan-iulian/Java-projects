import java.time.LocalDate;

public class Imprumut {
    private Carte carte;
    private LocalDate dataImprumut;
    private LocalDate dataReturnare;
    // getteri, setteri, constructori


    public Imprumut(Carte carte, LocalDate dataImprumut, LocalDate dataReturnare) {
        this.carte = carte;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = dataReturnare;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public LocalDate getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(LocalDate dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public LocalDate getDataReturnare() {
        return dataReturnare;
    }

    public void setDataReturnare(LocalDate dataReturnare) {
        this.dataReturnare = dataReturnare;
    }

    @Override
    public String toString() {
        return "Imprumut{" +
                "carte=" + carte +
                ", dataImprumut=" + dataImprumut +
                ", dataReturnare=" + dataReturnare +
                '}';
    }
}
