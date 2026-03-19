package lab4.sistem_cursuri_digitale;

import java.util.ArrayList;
import java.util.List;

// COMPOZITIE CU LECTIE
// AGREGARE cu PROFESOR

public class Curs {
    private String nume;
    private String descriere;
    private Profesor profesor;         // agregare
    private List<LectieCurs> lectii;       // compozitie
    private static int counter = 0;
    private final int id;

    // constructor
    public Curs(String nume, String descriere, Profesor profesor) {
        this.nume = nume;
        this.descriere = descriere;
        this.profesor = profesor;
        this.lectii = new ArrayList<>();
        this.id = ++counter;
    }

    // e. adaugare lectie la un curs
    public void adaugaLectie(LectieCurs l) {
        lectii.add(l);
        System.out.println("  -->> Lectie adaugata: " + l);
    }

    // e. stergere lectie dupa titlu din curs
    public void stergeLectie(String titlu) {
        boolean gasit = lectii.removeIf(l -> l.getTitlu().equals(titlu));
        System.out.println("  -->> Lectie '" + titlu + "' " + (gasit ? "stearsa." : "negasita."));
    }

    // apelat cand cursul e scos din curricula ->>> sterge lectiile (compozitie)
    public void distruge() {
        lectii.clear();
        System.out.println("  Cursul '" + nume + "' si toate lectiile au fost sterse.");
    }

    // getteri
    public int getId() {
        return id;
    }
    public String getNume() {
        return nume;
    }
    public String getDescriere() {
        return descriere;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public List<LectieCurs> getLectii() {
        return lectii; }

    @Override
    public String toString() {
        return "[CURS] --->>> id=" + id + " nume=" + nume + " profesor="
                + profesor.getNume() + " lectii=" + lectii.size();
    }
}
