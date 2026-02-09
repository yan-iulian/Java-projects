public class Proiect {
    private long codProiect;
    private String denumire;
    private int anLansare;
    private String departament;
    private double buget;
    private int durata;
    private double totalCheltuieli;
    private String numeDirector;
    private double totalCheltuielicsv;

    public long getCodProiect() {
        return codProiect;
    }

    public void setCodProiect(long codProiect) {
        this.codProiect = codProiect;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getBuget() {
        return buget;
    }

    public void setBuget(double buget) {
        this.buget = buget;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public double getTotalCheltuieli() {
        return totalCheltuieli;
    }

    public void setTotalCheltuieli(double totalCheltuieli) {
        this.totalCheltuieli = totalCheltuieli;
    }

    public String getNumeDirector() {
        return numeDirector;
    }

    public void setNumeDirector(String numeDirector) {
        this.numeDirector = numeDirector;
    }

    public Proiect(long codProiect, String denumire, int anLansare, String departament, double buget, int durata, double totalCheltuieli, String numeDirector) {
        this.codProiect = codProiect;
        this.denumire = denumire;
        this.anLansare = anLansare;
        this.departament = departament;
        this.buget = buget;
        this.durata = durata;
        this.totalCheltuieli = totalCheltuieli;
        this.numeDirector = numeDirector;
        this.totalCheltuielicsv=0.0;
    }

    public double getTotalCheltuielicsv() {
        return totalCheltuielicsv;
    }

    public void setTotalCheltuielicsv(double totalCheltuielicsv) {
        this.totalCheltuielicsv = totalCheltuielicsv;
    }

    @Override
    public String toString() {
        return "Proiect{" +
                "codProiect=" + codProiect +
                ", denumire='" + denumire + '\'' +
                ", anLansare=" + anLansare +
                ", departament='" + departament + '\'' +
                ", buget=" + buget +
                ", durata=" + durata +
                ", totalCheltuieli=" + totalCheltuieli +
                ", numeDirector='" + numeDirector + '\'' +
                ", totalCheltuielicsv=" + totalCheltuielicsv +
                '}';
    }
}
