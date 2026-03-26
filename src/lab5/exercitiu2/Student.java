package lab5.exercitiu2;

/* clasa Student trebuie sa fie imutabila
* adica:
* - toate campurile private final
* - fara setteri
* - clasa final ca sa nu poata fi extinsa
* - daca are campuri mutabile (gen Facultate) returnam copii defensive*/


final class Student {
    private final String nume;
    private final Facultate facultate;    // facultate aici e mutabila

    public Student(String nume, Facultate facultate) {
        this.nume = nume;

        // copie defensiva la intrare, nu pastram referinta originala
        this.facultate = new Facultate(facultate);
    }

    public Facultate getFacultate() {
        // copie defensiva la iesire, adica nu dam referinta interna
        return new Facultate(facultate);
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "[STUDENT] --->>> nume = " + nume + " facultate = " + facultate.getNume();
    }
}

//record Student(String nume, Facultate facultate) {}

