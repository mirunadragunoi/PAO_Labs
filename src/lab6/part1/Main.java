package lab6.part1;

import java.util.Arrays;

public class Main {

    // metoda proceseazaPlati
    public static void proceseazaPlati(OperatiiContBancar[] v, double suma) {
        System.out.println(" procesare plati de " + suma + " ------>>>>>> ");
        for (OperatiiContBancar obj : v) {
            if (obj.autentificare()) {
                if (obj.soldCurent() >= suma) {
                    obj.plata(suma);
                } else {
                    System.out.println("  !!!!!!fonduri insuficiente!!!! sold: " + obj.soldCurent());
                }
            }
        }
    }

    public static void main(String[] args) {

        // creare tablouri
        String[] numeStudenti = {"Zara", "Ana", "Mihai", "Bogdan", "Carla"};
        Student[] studenti = new Student[5];
        for (int i = 0; i < 5; i++) {
            studenti[i] = new Student(numeStudenti[i], 5 + i, 100 + i * 50);
        }

        Profesor[] profesori = new Profesor[5];
        for (int i = 0; i < 5; i++) {
            profesori[i] = new Profesor("Profesor" + i, 3000 + i * 500, 500 + i * 100);
        }

        FirmaPartenera[] firme = new FirmaPartenera[5];
        for (int i = 0; i < 5; i++) {
            firme[i] = new FirmaPartenera("Firma" + i, 10000 + i * 5000, 1000 + i * 200);
        }

        // sortare
        Arrays.sort(studenti);   // alfabetic dupa nume
        Arrays.sort(profesori);  // descrescator dupa salariu
        Arrays.sort(firme);      // descrescator dupa buget

        System.out.println(" Studenti sortati alfabetic:");
        for (Student s : studenti) System.out.println(s);

        System.out.println("Profesori sortati dupa salariu (desc):");
        for (Profesor p : profesori) System.out.println(p);

        System.out.println("Firme sortate dupa buget (desc):");
        for (FirmaPartenera f : firme) System.out.println(f);

        // proceseazaPlati
        OperatiiContBancar[] mixat = {
                studenti[0],
                profesori[0],
                firme[0]
        };

        proceseazaPlati(mixat, 300);
        proceseazaPlati(mixat, 5000);
    }
}
