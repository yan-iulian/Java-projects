public enum Tip {
    SEDAN (1),
    CABRIO (2),
    HATCHBACK(3),
    HYPERCAR (4),
    COMBI(5);

    private int nr;

    Tip(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

}
