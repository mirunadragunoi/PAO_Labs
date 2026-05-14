package lab9;

import java.io.*;
import java.util.*;

public class ex1_parole {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("parole.txt"))) {

            while (sc.hasNextLine()) {
                // iau efectiv cate o linie
                String linie = sc.nextLine().trim();

                if (linie.isEmpty()) continue;

                try {
                    // iau despartitorul adica virgula sa le impart
                    String[] parti = linie.split(",");

                    // daca nu respecta formatul
                    if (parti.length != 2) {
                        throw new IllegalArgumentException("linia '" + linie + "' nu are formatul username,parola!!!!");
                    }

                    // iau efectiv username ul si parola
                    String username = parti[0].trim();
                    String parola = parti[1].trim();

                    // vf lungime de 8 caractere pt parola
                    if (parola.length() < 8) {
                        throw new IllegalArgumentException("parola userului '" + username + "' este prea scurta!! minim 8 caractere!!!");
                    }

                    // vf ca parola sa contina cel putin o cifra
                    boolean okCifra = false;
                    for (char c : parola.toCharArray()) {
                        if (Character.isDigit(c)) {
                            okCifra = true;
                            break;
                        }
                    }

                    // exceptie
                    if (!okCifra) {
                        throw new IllegalArgumentException("parola userului '" + username + "' nu contine cifre!! minim o cifra!!!");
                    }

                    System.out.println("parola valida pentru userul: " + username);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("!!!!EROAREEE ---- " + e.getMessage());
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FISIERUL parole.txt NU EXISTA!!!!");
        }
    }
}
