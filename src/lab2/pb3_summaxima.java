package lab2;

import java.util.Scanner;

public class pb3_summaxima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // suma maxima in O(n) - la fiecare pas decid daca e mai bine
        // sa extind sirul curent sau sa incep unul nou

        System.out.print("nr elemente: ");
        int n = sc.nextInt();

        int[] vector = new int[n];
        for (int i = 0; i < n; i++)
            vector[i] = sc.nextInt();

        int suma_maxima = vector[0];
        int suma_curenta = vector[0];

        for (int i = 1; i < n; i++) {
            suma_curenta = Math.max(vector[i], suma_curenta + vector[i]);
            suma_maxima = Math.max(suma_maxima, suma_curenta);
        }

        System.out.println(suma_maxima);
    }
}
