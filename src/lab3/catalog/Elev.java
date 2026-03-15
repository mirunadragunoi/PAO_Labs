package lab3.catalog;

import java.util.ArrayList;
import java.util.List;

public class Elev {
    public String nume;
    public String prenume;
    private static int counter = 0;
    public int id;
    private List<Nota> note = new ArrayList<>();

    public Elev(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.id = ++counter;
    }

    // functie pentru a adauga o nota
    public void adaugaNota(Nota nota) {
        // verific prima oara daca exista deja nota la materia respectiva
        for (Nota n : note) {
            if (n.materieId == nota.materieId) {
                n.valoare = nota.valoare;   // editex efectiv nota existenta
                return;
            }
        }
        note.add(nota);
    }

    // un elev vede doar nota lui la o materie
    public Double getNota(int materieId) {
        for (Nota n : note) {
            if (n.materieId == materieId)
                return n.valoare;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Elev {id = " + id + ", nume = " + nume + " " + prenume + "}";
    }
}
