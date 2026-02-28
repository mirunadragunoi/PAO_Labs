package lab1;

import java.util.Scanner;

// nr impar de 1 in baza 2
public class pb2_nrimpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nr = 0;

        while (n > 0) {
            if (n % 2 == 1) nr ++;
            n = n / 2;
        }

        if (nr % 2 != 0) {
            System.out.print(true);
        }
        else
        {
            System.out.print(false);
        }
    }
}