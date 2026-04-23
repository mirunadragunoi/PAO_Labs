package lab7;

import java.io.*;
import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("numere.txt"));
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Rezultat: " + (a / b));
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Date invalide in fisier: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Impartire la zero: " + e.getMessage());
        }
    }
}