package lab7;

import java.io.*;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            sc = new Scanner(new File("numere.txt"));
            pw = new PrintWriter(new File("rezultat.txt"));

            int a = sc.nextInt();
            int b = sc.nextInt();
            int rezultat = a / b;

            pw.println("Rezultat impartire: " + a + " / " + b + " = " + rezultat);
            System.out.println("Rezultat scris in rezultat.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Date invalide in fisier: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Impartire la zero: " + e.getMessage());
            if (pw != null) pw.println("Eroare: impartire la zero!");
        } finally {
            if (sc != null) sc.close();
            if (pw != null) pw.close();
        }
    }
}
