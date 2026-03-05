package lab2;

import java.util.Scanner;

public class pb1_subsircrescator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nr elemente: ");

        int n = sc.nextInt();
        int[] vector = new int[n];

        for (int i = 0; i < n; i ++)
            vector[i] = sc.nextInt();

        int lgmax = 1, lg = 1;
        for (int i = 1; i < n; i++) {
            if (vector[i] > vector[i - 1]) {
                lg ++;
                lgmax = Math.max(lgmax, lg);
            }
            else {
                lg = 1;
            }
        }
        System.out.println(lgmax);
    }
}
