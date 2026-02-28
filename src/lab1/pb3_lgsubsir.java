package lab1;

import java.util.Scanner;

// lungimea celui mai mare subsir de 1 al scrierii in baza 2 a unui nr
public class pb3_lgsubsir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lgmax = 0, lg = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                lg ++;
                lgmax = Math.max(lgmax, lg);
            }
            else {
                lg = 0;
            }
            n = n / 2;
        }

        System.out.println(lgmax);
    }
}