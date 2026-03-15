package lab3.catalog;

public class Profesor {
    public String nume;
    public String prenume;
    private static int counter = 0;
    public int id;

    public Profesor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.id = ++counter;
    }

    // profesorul adauga/editeaza nota unui student la o materie
    public void adaugaOrEditeazaNota(Elev elev, Materie materie, double valoare) {
        Nota nota = new Nota(elev.id, materie.id, valoare);

        elev.adaugaNota(nota);

        System.out.println("Nota " + valoare + " adaugata/editata pentru " + elev + " la " + materie);
    }

    @Override
    public String toString() {
        return "Profesor {id = " + id + ", nume = " + nume + " " + prenume + "}";
    }
}
