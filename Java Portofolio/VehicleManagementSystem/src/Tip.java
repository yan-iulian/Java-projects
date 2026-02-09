public enum Tip {
    INTERURBAN("INTERURBAN"),
    LOCAL("LOCAL");

    private final String valoare;

    Tip(String valoare) {
        this.valoare=valoare;

    }

    public String getValoare() {
        return valoare;
    }

    int dificultate(){
        if (this.valoare=="INTERURBAN")
            return 2;
        else return 1;
    }

}
