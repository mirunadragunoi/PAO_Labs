package lab4.sistem_cursuri_digitale;

import java.util.ArrayList;
import java.util.List;

public class Facultate {
    private String nume;
    private List<Profesor> profesori;  // agregare
    private List<Curs> cursuri;        // compozitie
    private static int counter = 0;
    private final int id;

    // constructor
    public Facultate(String nume) {
        this.nume = nume;
        this.profesori = new ArrayList<>();
        this.cursuri = new ArrayList<>();
        this.id = ++counter;
    }

    // a. adaugare profesor
    public void adaugaProfesor(Profesor p) {
        if (!profesori.contains(p)) {
            profesori.add(p);
            System.out.println(" -->> Profesor adaugat: " + p);
        } else {
            System.out.println(" -->> Profesorul exista deja.");
        }
    }

    // a. stergere profesor dupa id
    public void stergeProfesor(int id) {
        boolean gasit = profesori.removeIf(p -> p.getId() == id);
        System.out.println(" --->> Profesor id=" + id + (gasit ? " sters." : " negasit."));
    }

    // b. listare profesori
    public void listeazaProfesori() {
        System.out.println(" --->>> Profesorii facultatii " + nume + ":");
        if (profesori.isEmpty()) {
            System.out.println("  (niciun profesor!!!)");
        } else {
            profesori.forEach(p -> System.out.println("  " + p));
        }
    }

    // c. adaugare curs
    public void adaugaCurs(Curs c) {
        cursuri.add(c);
        System.out.println(" --->> Curs adaugat: " + c);
    }

    // c. stergere curs ->> distruge si lectiile (compozitie)
    public void stergeCurs(int id) {
        for (Curs c : cursuri) {
            if (c.getId() == id) {
                c.distruge();
                cursuri.remove(c);
                return;
            }
        }
        System.out.println(" --->> Cursul id=" + id + " negasit.");
    }

    // d. cautare curs dupa nume sau cuvant cheie in descriere
    public List<Curs> cautaCurs(String query) {
        List<Curs> rezultat = new ArrayList<>();
        for (Curs c : cursuri) {
            if (c.getNume().toLowerCase().contains(query.toLowerCase()) ||
                    c.getDescriere().toLowerCase().contains(query.toLowerCase())) {
                rezultat.add(c);
            }
        }
        return rezultat;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "[FACULTATE] --->>> id=" + id + " nume=" + nume
                + " profesori=" + profesori.size()
                + " cursuri=" + cursuri.size();
    }
}
