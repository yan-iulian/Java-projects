public class Carte {
    private int cod;
    private String titlu;
    private String autor;
    private float pret;
    private int anPublicare;

    public Carte(int cod, String titlu, String autor, float pret, int anPublicare) {
        this.cod = cod;
        this.titlu = titlu;
        this.autor = autor;
        this.pret = pret;
        this.anPublicare = anPublicare;
    }

    public Carte() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getAnPublicare() {
        return anPublicare;
    }

    public void setAnPublicare(int anPublicare) {
        this.anPublicare = anPublicare;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "cod=" + cod +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", pret=" + pret +
                ", anPublicare=" + anPublicare +
                '}';
    }

}
