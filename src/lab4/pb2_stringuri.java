package lab4;

import java.util.Arrays;

public class pb2_stringuri {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cab";

        System.out.println(estePermutare(str1, str2));
    }

    static boolean estePermutare(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }
}
