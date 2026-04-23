package lab7;

import java.io.*;
import java.net.*;
import java.util.*;

public class ex3 {
    public static void main(String[] args) {
        // citire cuvinte din date.txt
        List<String> cuvinte = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("date.txt"));
            while (sc.hasNextLine()) {
                cuvinte.add(sc.nextLine().trim().toLowerCase());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul date.txt nu a fost gasit!");
            return;
        }

        // citire continut site
        String continutSite = "";
        try {
            URL url = new URL("https://www.gsp.ro/");
            InputStream is = url.openStream();
            StringBuffer buffer = new StringBuffer();
            int ptr;
            while ((ptr = is.read()) != -1) {
                buffer.append((char) ptr);
            }
            is.close();
            continutSite = buffer.toString().toLowerCase();
        } catch (IOException e) {
            System.out.println("Eroare la accesarea site-ului: " + e.getMessage());
            return;
        }

        // numara aparitiile fiecarui cuvant
        for (String cuvant : cuvinte) {
            int count = 0;
            int index = 0;
            while ((index = continutSite.indexOf(cuvant, index)) != -1) {
                count++;
                index += cuvant.length();
            }
            System.out.println("'" + cuvant + "' apare de " + count + " ori.");
        }
    }
}
