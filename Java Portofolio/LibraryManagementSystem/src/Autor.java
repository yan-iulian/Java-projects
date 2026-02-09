public class Autor {
    private final String numeComplet;
    private final String nationalitate;

    public Autor(String numeComplet, String nationalitate) {
        this.numeComplet = numeComplet;
        this.nationalitate = nationalitate;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "numeComplet='" + numeComplet + '\'' +
                ", nationalitate='" + nationalitate + '\'' +
                '}';
    }



}
