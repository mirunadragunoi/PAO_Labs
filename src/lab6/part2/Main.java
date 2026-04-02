package lab6.part2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FunctieIntreg identitate = new Identitate();
        FunctieIntreg patrat = new PatratPerfect();

        int n = 5;

        // test cu Identitate f(x)=x
        System.out.println("Identitate (n=5)");
        System.out.println("Suma:      " + Procesari.suma(identitate, n));
        System.out.println("Numara >0: " + Procesari.numara(identitate, n));
        System.out.println("Vector:    " + Arrays.toString(Procesari.transforma(identitate, n)));

        // test cu PatratPerfect f(x)=x*x
        System.out.println("PatratPerfect (n=5)");
        System.out.println("Suma:      " + Procesari.suma(patrat, n));
        System.out.println("Numara >0: " + Procesari.numara(patrat, n));
        System.out.println("Vector:    " + Arrays.toString(Procesari.transforma(patrat, n)));
    }
}