package lab1;

import java.util.Scanner;

// palindrom simplu

public class pb1_palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = n, invers = 0;

        while (n > 0) {
            invers = invers * 10 + n % 10;
            n = n / 10;
        }

        if (N == invers) {
            System.out.println("palindrom");
        }
        else {
            System.out.println("nu e palindrom");
        }
    }
}