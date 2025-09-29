public class Element implements Comparable<Element> {
    private int indexLinie;
    private int indexColoana;
    private double valoare;

    public Element(int indexLinie, int indexColoana, double valoare) {
        this.indexLinie = indexLinie;
        this.indexColoana = indexColoana;
        this.valoare = valoare;
    }

    public int getIndexLinie() {
        return indexLinie;
    }

    public void setIndexLinie(int indexLinie) {
        this.indexLinie = indexLinie;
    }

    public int getIndexColoana() {
        return indexColoana;
    }

    public void setIndexColoana(int indexColoana) {
        this.indexColoana = indexColoana;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public Element() {
    }

    @Override
    public String toString() {
        return "Elemenul are indexul liniei "+this.indexLinie+" si indexul coloanei :"+this.indexColoana+". Valoarea este :"+this.valoare;
    }

   public boolean eEgalCu(Element e2)
   {
       if(this.indexLinie==e2.indexLinie && this.indexColoana==e2.indexColoana && this.valoare==e2.valoare)
           return true;
       else return false;
   }

    @Override
    public int compareTo(Element o) {
        return Double.compare(this.valoare,o.valoare);
    }









}
