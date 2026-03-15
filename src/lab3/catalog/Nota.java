package lab3.catalog;

public class Nota {
    public int elevId;
    public int materieId;
    public double valoare;

    public Nota(int elevId, int materieId, double valoare) {
        this.elevId = elevId;
        this.materieId = materieId;
        this.valoare = valoare;
    }

    @Override
    public String toString() {
        return "Nota {valoare = " + valoare + "}";
    }
}
