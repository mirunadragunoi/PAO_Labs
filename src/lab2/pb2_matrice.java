package lab2;

import java.util.Scanner;

public class pb2_matrice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("m n: ");

        int m = sc.nextInt(), n = sc.nextInt();
        int[][] matrice = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrice[i][j] = sc.nextInt();

        int nr = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrice[i][j] == 1) {
                    boolean ok = true;
                    for (int d = 0; d < 4; d++) {
                        int indexi = i + dx[d];
                        int indexj = j + dy[d];

                        // vecinii care sunt trebuie sa fie zero
                        if (indexi >= 0 && indexi < m && indexj >= 0 && indexj < n) {
                            if (matrice[indexi][indexj] != 0) { ok = false; break; }
                        }
                    }
                    if (ok) nr ++;
                }
            }
        }
        System.out.println(nr);
    }
}
