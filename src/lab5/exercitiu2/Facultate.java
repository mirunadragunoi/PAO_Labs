package lab5.exercitiu2;

class Facultate {
    private String nume;

    public Facultate(String nume) {
        this.nume = nume;
    }

    // cream o copie defensiva
    public Facultate(Facultate facultate) {
        this.nume = facultate.nume;
    }

    public void setNume(String nume) { this.nume = nume; }
    public String getNume() { return nume; }
}

