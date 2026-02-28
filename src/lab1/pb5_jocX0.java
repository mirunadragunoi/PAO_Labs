package lab1;

import java.util.Scanner;

public class pb5_jocX0 {
    static char[][] tabela = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // initializez tabela
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tabela[i][j] = '_';

        int mutari = 0;
        boolean sfarsitjoc = false;

        while (!sfarsitjoc && mutari < 9) {
            int jucator = (mutari % 2 == 0) ? 1 : 2;
            char simbol = (jucator == 1) ? 'X' : '0';

            System.out.print("Jucatorul " + jucator + " alege pozitia: ");
            int pozitie = sc.nextInt();

            int rand = (pozitie - 1) / 3;
            int coloana = (pozitie - 1) % 3;

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(tabela[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    static boolean verific_casting(char s) {
        // liniile si coloanele
        for (int i = 0; i < 3; i++) {
            if (tabela[i][0]==s && tabela[i][1]==s && tabela[i][2]==s) return true;
            if (tabela[0][i]==s && tabela[1][i]==s && tabela[2][i]==s) return true;
        }
        // diagonalele
        if (tabela[0][0]==s && tabela[1][1]==s && tabela[2][2]==s) return true;
        if (tabela[0][2]==s && tabela[1][1]==s && tabela[2][0]==s) return true;
        return false;
    }
}