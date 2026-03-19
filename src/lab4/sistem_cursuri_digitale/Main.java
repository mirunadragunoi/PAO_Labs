package lab4.sistem_cursuri_digitale;

public class Main {
    public static void main(String[] args) {
        // creare facultate
        Facultate fmi = new Facultate("FMI");

        // profesori (exista independent ->> agregare)
        Profesor p1 = new Profesor("Vasile", "Andrei", "Java");
        Profesor p2 = new Profesor("Popescu", "Ion", "BD");

        // a. adaugare/stergere profesor
        fmi.adaugaProfesor(p1);
        fmi.adaugaProfesor(p2);
        fmi.stergeProfesor(p2.getId());
        fmi.adaugaProfesor(p2); // il adaugam inapoi

        // b. listare profesori
        fmi.listeazaProfesori();

        // creare cursuri
        Curs pao = new Curs("PAO", "Programare avansata pe obiecte in Java", p1);
        Curs bd = new Curs("BD", "Baze de date relationale si SQL", p2);

        // e. adaugare lectii
        pao.adaugaLectie(new LectieCurs("Intro OOP", "Clase si obiecte", 60));
        pao.adaugaLectie(new LectieCurs("Mostenire", "Extends si Override", 90));
        pao.adaugaLectie(new LectieCurs("Interfete", "Interface si abstractizare", 75));
        bd.adaugaLectie(new LectieCurs("SQL Basics", "Select, Insert, Update", 60));

        // c. adaugare cursuri la facultate
        fmi.adaugaCurs(pao);
        fmi.adaugaCurs(bd);

        System.out.println("\n" + fmi);

        // e. stergere lectie din curs
        pao.stergeLectie("Interfete");

        // d. cautare curs
        System.out.println("\nCautare 'java': " + fmi.cautaCurs("java"));
        System.out.println("Cautare 'sql': " + fmi.cautaCurs("sql"));

        // c. stergere curs ->>> sterge si lectiile
        System.out.println();
        fmi.stergeCurs(bd.getId());
        System.out.println("\n" + fmi);

        // un profesor poate colabora cu mai multe facultati (agregare)
        Facultate ase = new Facultate("ASE");
        ase.adaugaProfesor(p1); // acelasi profesor p1 la alta facultate
        System.out.println("\n" + ase);
    }
}