package lab4.sistem_cursuri_digitale;

// deci profesor exista independent de facultate sau de curs
// AGREGARE!!!!!

public class Profesor {
    private String nume;
    private String prenume;
    private String specialitate;
    private static int counter = 0;
    private final int id;

    // constructor
    public Profesor(String nume, String prenume, String specialitate) {
        this.nume = nume;
        this.prenume = prenume;
        this.specialitate = specialitate;
        this.id = ++counter;
    }

    // getteri
    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    @Override
    public String toString() {
        return "[PROFESOR] --->>> id=" + id + " nume=" + nume + " " + prenume
                + " specialitate=" + specialitate;
    }
}
