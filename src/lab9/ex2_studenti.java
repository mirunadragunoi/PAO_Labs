package lab9;

import java.io.*;
import java.util.*;

public class ex2_studenti {
    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(new File("examene.csv"));
                PrintWriter pw = new PrintWriter(new File("rezultate_examen.txt"));
                )
        {
            while (sc.hasNextLine()) {
                // iau noua linie
                String linie = sc.nextLine().trim();

                if (linie.isEmpty()) continue;

                try {
                    // impart pe parti cu separatorul ,
                    String[] parti = linie.split(",");

                    // verific sa am exact 4 valori
                    if (parti.length != 4) {
                        throw new IllegalArgumentException("linia '" + linie + "' nu are exact 4 valori!!!!");
                    }

                    // iau prima oara numele studentului
                    String nume = parti[0].trim();

                    // iau notele cu conversie la int!!!
                    int nota1, nota2, nota3;
                    try {
                        nota1 = Integer.parseInt(parti[1].trim());
                        nota2 = Integer.parseInt(parti[2].trim());
                        nota3 = Integer.parseInt(parti[3].trim());
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException("nota invalida pentru studentul '" + nume + "'!!!!");
                    }

                    // trebuie sa verific pt fiecare nota daca e intre 1 si 10
                    if (nota1 < 1 || nota1 > 10 || nota2 < 1 || nota2 > 10 || nota3 < 1 || nota3 > 10) {
                        throw new IllegalArgumentException("nota invalida pentru studentul '" + nume + "'!!!! trebuie sa fie intre 1 si 10!!!");
                    }

                    // calculam media si statusul studentului de promovat respins
                    double medie = (nota1 + nota2 + nota3) / 3.0;
                    String status;
                    if (medie >= 5) status = "PROMOVAT";
                    else status = "RESPINS";

                    // asamblez linia de rezultat
                    String rezultat;
                    rezultat = String.format("%s - media: %.1f - %s", nume, medie, status);

                    pw.println(rezultat);
                    System.out.println(rezultat);
                }
                catch (IllegalArgumentException e) {
                    String eroare = "EROARE ---->>> " + e.getMessage();
                    pw.println(eroare);
                    System.out.println(eroare);
                }
            }
            System.out.println("BRAVOOOOO!!! REZULTATE SCRISE IN FISIER YYYEY");
        }
        catch (FileNotFoundException e) {
            System.out.println("FISIERUL examene.csv nu exista!!!!");
        }
    }
}
