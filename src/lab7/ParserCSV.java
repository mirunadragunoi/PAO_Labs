package lab7;

import java.io.*;

public class ParserCSV {
    private BufferedReader reader;
    private String[] tokensLinieCurenta;
    private int indexToken;

    // constructor - seteaza fisierul
    public ParserCSV(String numeFisier) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(numeFisier));
        tokensLinieCurenta = new String[0];
        indexToken = 0;
    }

    // muta cursorul pe urmatoarea linie
    public void nextLine() throws IOException {
        String linie = reader.readLine();
        if (linie != null) {
            // split dupa virgula + trim la fiecare token
            tokensLinieCurenta = linie.split(",");
            for (int i = 0; i < tokensLinieCurenta.length; i++) {
                tokensLinieCurenta[i] = tokensLinieCurenta[i].trim();
            }
        } else {
            tokensLinieCurenta = new String[0];
        }
        indexToken = 0;
    }

    // returneaza urmatorul token sau null daca nu mai sunt
    private String nextToken() {
        if (indexToken >= tokensLinieCurenta.length) return null;
        return tokensLinieCurenta[indexToken++];
    }

    // citeste urmatorul token ca int
    public Integer readInt() throws NumberFormatException {
        String token = nextToken();
        if (token == null) return null;
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Nu pot converti '" + token + "' la int!");
        }
    }

    // citeste urmatorul token ca String
    public String readString() {
        return nextToken(); // returneaza null daca nu mai sunt tokens
    }

    public void close() throws IOException {
        reader.close();
    }

    // Main - testare
    public static void main(String[] args) {
        try {
            ParserCSV parser = new ParserCSV("date.csv");

            // --- Linia 1: 12, student, 12x4 ---
            parser.nextLine();

            System.out.println(parser.readInt());    // 12

            System.out.println(parser.readString()); // student

            try {
                System.out.println(parser.readInt()); // arunca exceptie - "12x4"
            } catch (NumberFormatException e) {
                System.out.println("Exceptie: " + e.getMessage());
            }

            // --- Linia 2: 100, facultate, rezultat ---
            parser.nextLine();

            System.out.println(parser.readInt());    // 100

            try {
                System.out.println(parser.readInt()); // arunca exceptie - "facultate"
            } catch (NumberFormatException e) {
                System.out.println("Exceptie: " + e.getMessage());
            }

            System.out.println(parser.readString()); // rezultat

            System.out.println(parser.readString()); // null - nu mai sunt tokens

            parser.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Eroare IO: " + e.getMessage());
        }
    }
}
