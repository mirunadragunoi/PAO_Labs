package lab3.catalog;

import java.util.ArrayList;
import java.util.List;

public class Facultate {
    public String nume;
    private static int counter = 0;
    public int id;
    private List<Materie> materii = new ArrayList<>();
    private List<Elev> elevi = new ArrayList<>();
    private List<Profesor> profesori = new ArrayList<>();

    public Facultate(String nume){
        this.nume = nume;
        this.id = ++counter;
    }

    public void adaugaMaterie(Materie m){
        materii.add(m);
    }

    public void adaugaElev(Elev e) {
        elevi.add(e);
    }

    public void adaugaProfesor(Profesor p) {
        profesori.add(p);
    }

    // elev cauta materia dupa cuvant cheie si vede nota lui
    public void cautaMaterieElev(String cuvant, Elev elev) {
        System.out.println("[ELEV] --->> Cauta materie: " + cuvant + "\n");
        for (Materie m : materii) {
            if (m.nume.toLowerCase().contains(cuvant.toLowerCase())) {
                Double nota = elev.getNota(m.id);
                System.out.println("       " + m + " ---->>> NOTA: " + (nota != null ? nota : "fara nota" + "\n"));
            }
        }
    }

    // profesorul cauta materie dupa cuvant cheie
    public List<Materie> cautaMaterieProfesor(String cuvant) {
        System.out.println("[PROFESOR] --->> Cauta materie: " + cuvant + "\n");
        List<Materie> rezultat = new ArrayList<>();
        for (Materie m : materii) {
            if (m.nume.toLowerCase().contains(cuvant.toLowerCase())) {
                System.out.println("    Gasita: " + m);
                rezultat.add(m);
            }
        }
        return rezultat;
    }

    // profesorul cauta studentul dupa nume si sau prenume
    public List<Elev> cautaStudent(String cuvant){
        System.out.println("[PROFESOR] --->> Cautare student: " + cuvant + "\n");
        List<Elev> rezultat = new ArrayList<>();
        for (Elev e : elevi) {
            if (e.nume.toLowerCase().contains(cuvant.toLowerCase())
                    || e.prenume.toLowerCase().contains(cuvant.toLowerCase())) {
                System.out.println("    Gasit: " + e);
                rezultat.add(e);
            }
        }
        return rezultat;
    }

    @Override
    public String toString() {
        return "Facultate {id = " + id + ", nume = " + nume
                + ", materii = " + materii.size()
                + ", elevi = " + elevi.size() + "}";
    }
}
