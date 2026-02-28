package lab1;

import java.util.Scanner;

public class pb5_suplimentar {
    static char[][] tabela;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // citesc n si etc
        System.out.print("Introdu dimensiunea matricei>> ");
        n = sc.nextInt();

        tabela = new char[n][n];

        // initializez tabela
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tabela[i][j] = '_';

        int mutari = 0;
        boolean sfarsitjoc = false;

        while (!sfarsitjoc && mutari < n * n) {
            int jucator = (mutari % 2 == 0) ? 1 : 2;
            char simbol = (jucator == 1) ? 'X' : '0';

            System.out.print("Jucatorul " + jucator + " alege pozitia: ");
            int pozitie = sc.nextInt();

            int rand = (pozitie - 1) / n;
            int coloana = (pozitie - 1) % n;

            if (tabela[rand][coloana] != '_') {
                System.out.println("Pozitie ocupata! Incearca din nou.");
                continue;
            }

            tabela[rand][coloana] = simbol;
            print_tabela();
            mutari++;

            if (verific_casting(simbol)) {
                System.out.println("Jucatorul " + jucator + " a castigat!");
                sfarsitjoc = true;
            }
        }

        if (!sfarsitjoc) System.out.println("Remiza!");
    }

    static void print_tabela() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(tabela[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    static boolean verific_casting(char s) {
        // liniile si coloanele
        for (int i = 0; i < n; i++) {
            boolean linie = true, coloana = true;
            for (int j = 0; j < n; j++) {
                if (tabela[i][j] != s) linie = false;
                if (tabela[j][i] != s) coloana = false;
            }
            if (linie || coloana) return true;
        }
        // diagonalele
        boolean diagonala1 = true, diagonala2 = true;
        for (int i = 0; i < n; i++){
            if (tabela[i][i] != s) diagonala1 = false;
            if (tabela[i][n - 1 - i] != s) diagonala2 = false;
        }
        return diagonala1 || diagonala2;
    }
}