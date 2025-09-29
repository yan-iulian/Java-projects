public class Camera implements Comparable<Camera> {

    private String codCamera;
    private int nrPaturi;
    private float tarif;
    private int zileOcupate;

    public String getCodCamera() {
        return codCamera;
    }

    public void setCodCamera(String codCamera) {
        this.codCamera = codCamera;
    }

    public int getNrPaturi() {
        return nrPaturi;
    }

    public void setNrPaturi(int nrPaturi) {
        this.nrPaturi = nrPaturi;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getZileOcupate() {
        return zileOcupate;
    }

    public void setZileOcupate(int zileOcupate) {
        this.zileOcupate = zileOcupate;
    }

    public Camera(String codCamera, int nrPaturi, float tarif, int zileOcupate) {
        this.codCamera = codCamera;
        this.nrPaturi = nrPaturi;
        this.tarif = tarif;
        this.zileOcupate = zileOcupate;
    }

    public Camera() {
    }

    @Override
    public String toString() {
        return "Camera{" +
                "codCamera='" + codCamera + '\'' +
                ", nrPaturi=" + nrPaturi +
                ", tarif=" + tarif +
                ", zileOcupate=" + zileOcupate +
                '}';
    }

    public float tarifPerPar()
    {
        return this.tarif/this.nrPaturi;
    }


    @Override
    public int compareTo(Camera c) {
        return (int) (this.tarifPerPar()-c.tarifPerPar());
    }




}
