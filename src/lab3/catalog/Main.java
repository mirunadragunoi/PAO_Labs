package lab3.catalog;

public class Main {
    public static void main(String[] args) {

        // creare facultate
        Facultate fmi = new Facultate("FMI");

        // materii
        Materie pao = new Materie("Programare Avansata pe Obiecte");
        Materie bd = new Materie("Baze de Date");
        Materie algo = new Materie("Algoritmica");
        fmi.adaugaMaterie(pao);
        fmi.adaugaMaterie(bd);
        fmi.adaugaMaterie(algo);

        // elevi
        Elev ana = new Elev("Popescu", "Ana");
        Elev ion = new Elev("Ionescu", "Ion");
        fmi.adaugaElev(ana);
        fmi.adaugaElev(ion);

        // profesor
        Profesor prof = new Profesor("Paun", "Andrei");
        fmi.adaugaProfesor(prof);

        System.out.println(fmi);
        System.out.println(prof);
        System.out.println(ana);

        // profesorul adauga note
        prof.adaugaOrEditeazaNota(ana, pao, 9.5);
        prof.adaugaOrEditeazaNota(ion, pao, 7.0);
        prof.adaugaOrEditeazaNota(ana, bd, 8.0);

        // profesul editeaza note
        prof.adaugaOrEditeazaNota(ana, pao, 10.0); // editeaza 9.5 → 10

        // elevul cauta materia si vede nota lui
        fmi.cautaMaterieElev("programare", ana);
        fmi.cautaMaterieElev("baze", ana);

        // profesorul cauta o materie
        fmi.cautaMaterieProfesor("baze");

        // profesorul cauta un student
        fmi.cautaStudent("popescu");
        fmi.cautaStudent("ion"); // gaseste si Ionescu Ion
    }
}
