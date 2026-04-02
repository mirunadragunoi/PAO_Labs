package lab6.part2;

public class Procesari {

    // constructor privat ca sa nu poata fi instantiata
    private Procesari() {}

    // a. suma f(i)
    public static int suma(FunctieIntreg f, int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += f.valoare(i);
        }
        return total;
    }

    // b. numara de cate ori f(i) > 0
    public static int numara(FunctieIntreg f, int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (f.valoare(i) > 0) count++;
        }
        return count;
    }

    // c. construieste vectorul {f(1), f(2), ..., f(n)}
    public static int[] transforma(FunctieIntreg f, int n) {
        int[] rezultat = new int[n];
        for (int i = 1; i <= n; i++) {
            rezultat[i - 1] = f.valoare(i);
        }
        return rezultat;
    }
}
