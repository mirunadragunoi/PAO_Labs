package lab1;

import java.util.Scanner;

// aplic and pe toti bitii
// aplic or pe toti bitii
// obtin acelasi bit
public class pb4_AndOrBiti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int AND = 1, OR = 0;

        while (n > 0) {
            int bit = n % 2;
            AND &= bit;
            OR |= bit;
            n = n / 2;
        }

        System.out.println(AND == OR);
    }
}