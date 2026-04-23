package lab7;

import java.io.*;
import java.util.*;

public class ex4 {
    public static void main(String[] args) {
        // citire cuvinte din fisier
        List<String> cuvinte = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("cuvinte.txt"));
            while (sc.hasNextLine()) {
                String linie = sc.nextLine().trim();
                if (!linie.isEmpty()) cuvinte.add(linie);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul cuvinte.txt nu a fost gasit!");
            return;
        }

        if (cuvinte.isEmpty()) {
            System.out.println("Fisierul e gol!");
            return;
        }

        // alege un cuvant aleator
        Random rand = new Random();
        String cuvant = cuvinte.get(rand.nextInt(cuvinte.size()));

        // afiseaza cuvantul fara prima si ultima litera
        System.out.print("Cuvantul: ");
        for (int i = 0; i < cuvant.length(); i++) {
            if (i == 0 || i == cuvant.length() - 1) {
                System.out.print("_ ");
            } else {
                System.out.print(cuvant.charAt(i) + " ");
            }
        }
        System.out.println();

        Scanner consolă = new Scanner(System.in);

        // citire prima litera
        char primaLitera = citesteLitera(consolă, "Introduceți prima litera: ");
        // citire ultima litera
        char ultimaLitera = citesteLitera(consolă, "Introduceți ultima litera: ");

        // verificare
        boolean primaOk = Character.toLowerCase(primaLitera) == Character.toLowerCase(cuvant.charAt(0));
        boolean ultimaOk = Character.toLowerCase(ultimaLitera) == Character.toLowerCase(cuvant.charAt(cuvant.length() - 1));

        if (primaOk && ultimaOk) {
            System.out.println("Felicitari! Cuvantul era: " + cuvant);
        } else {
            System.out.println("Gresit! Cuvantul era: " + cuvant);
        }
    }

    static char citesteLitera(Scanner sc, String mesaj) {
        while (true) {
            try {
                System.out.print(mesaj);
                String input = sc.nextLine().trim();
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    throw new IllegalArgumentException("Trebuie sa introduci exact o litera!");
                }
                return input.charAt(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Input invalid: " + e.getMessage());
            }
        }
    }
}