package lab3.catalog;

public class Materie {
    public String nume;
    private static int counter = 0;
    public int id;

    public Materie(String nume) {
        this.nume = nume;
        this.id = ++counter;
    }

    @Override
    public String toString() {
        return "Materie {id = " + id + ", nume = " + nume + "}";
    }
}
