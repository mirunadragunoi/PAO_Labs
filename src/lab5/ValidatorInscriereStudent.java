package lab5;

public class ValidatorInscriereStudent {
    // validare cnp 13 cifre
    public static boolean validareCNP(String cnp) {
        if (cnp == null || cnp.length() != 13) return false;
        if (!cnp.matches("\\d{13}")) return false;
        if (cnp.charAt(0) < '1' || cnp.charAt(0) > '8') return false;
        return true;
    }

    // validare nr telefon 10 cifre si tre sa inceapa cu 07
    public static boolean validareTelefon(String telefon) {
        if (telefon == null) return false;
        return telefon.matches("07\\d{8}");
    }

    // validare nume prenume doar litere si minim 2 caractere
    public static boolean validareNume(String nume) {
        if (nume == null || nume.length() < 2) return false;
        return nume.matches("[a-zA-ZăâîșțĂÂÎȘȚ]+");
    }

    // extrage an din MM-DD-YYYY
    public static int extragereAn(String data) {
        // anul e dupa al doilea -
        String[] parti = data.split("-");
        if (parti.length != 3) throw new IllegalArgumentException("format invalid!!!");
        return Integer.parseInt(parti[2]);
    }

    public static void main(String[] args) {
        // test CNP
        System.out.println(validareCNP("1234567890123"));
        System.out.println(validareCNP("9234567890123"));
        System.out.println(validareCNP("12345"));

        // test telefon
        System.out.println(validareTelefon("0712345678"));
        System.out.println(validareTelefon("0812345678"));
        System.out.println(validareTelefon("071234"));

        // test nume
        System.out.println(validareNume("Popescu"));
        System.out.println(validareNume("Pop3scu"));
        System.out.println(validareNume("A"));

        // test extragere an
        System.out.println(extragereAn("10-15-2001"));
        System.out.println(extragereAn("03-22-1999"));
    }
}
