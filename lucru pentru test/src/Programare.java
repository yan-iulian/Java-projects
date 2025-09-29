public final class Programare {
    private final String zi;
    private final String ora;
    private final Profesor profesor;
    private final String materie;
    private final String sala;
    private final Boolean esteCurs;
    private final String formatie;

    public Programare(String zi, String ora, Profesor profesor, String materie, String sala, Boolean esteCurs, String formatie) {
        this.zi = zi;
        this.ora = ora;
        this.profesor = profesor;
        this.materie = materie;
        this.sala = sala;
        this.esteCurs = esteCurs;
        this.formatie = formatie;
    }

    public String getZi() {
        return zi;
    }

    public String getOra() {
        return ora;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getMaterie() {
        return materie;
    }

    public String getSala() {
        return sala;
    }

    public Boolean getEsteCurs() {
        return esteCurs;
    }

    public String getFormatie() {
        return formatie;
    }

    @Override
    public String toString() {
        return "Programare{" +
                "zi='" + zi + '\'' +
                ", ora='" + ora + '\'' +
                ", profesor=" + profesor +
                ", materie='" + materie + '\'' +
                ", sala=" + sala +
                ", esteCurs=" + esteCurs +
                ", formatie='" + formatie + '\'' +
                '}';
    }




}
