package lab4.editor_text;

import java.util.ArrayList;
import java.util.List;

public class EditorText {
    private String paragraf;

    // 1. salvare in memorie paragraf ->> constructor
    public EditorText(String paragraf) {
        this.paragraf = paragraf;
    }

    // getter
    public String getParagraf() {
        return paragraf;
    }

    // 2. eliminare spatii in plus
    public void eliminaSpatii() {
        paragraf = paragraf.trim().replaceAll("\\s+", " ");
    }

    // 3. numaram cuvintele din paragraf
    public int numaraCuvinte() {
        if (paragraf.trim().isEmpty()) return 0;
        return paragraf.trim().split("\\s+").length;
    }

    // 4. numara de cate ori apare un cuvant dat in paragraf
    public int numaraAparitii(String cuvant) {
        int count = 0;
        for (String c : paragraf.split("\\s+")) {
            // eliminam punctuatia de la finalul cuvantului in caz ca exista
            if (c.replaceAll("[.!?]+$", "").equalsIgnoreCase(cuvant)) {
                count++;
            }
        }
        return count;
    }

    // 5. extrag propozitiile din paragraf
    public List<String> extragePropozitie() {

        List<String> rezultat = new ArrayList<>();

        // ordinea conteaza -->> ... trebuie verificat inaintea lui .
        String[] parti = paragraf.split("(\\.\\.\\.)|[.!?]");
        for (String p : parti) {
            String trim = p.trim();
            if (!trim.isEmpty()) {
                rezultat.add(trim);
            }
        }

        return rezultat;
    }

    // 6. pt un cuvant sa se inlocuiasca toate aparitiile cu varianta cu lower case
    public void inlocuiesteCuLower(String cuvant) {
        // (?i) = case-insensitive, \\b = word boundary
        paragraf = paragraf.replaceAll("(?i)\\b" + cuvant + "\\b", cuvant.toLowerCase());
    }

    // 7. rezumat ->>> primele 2 cuvinte din fiecare propozitie
    public String rezumat() {
        StringBuilder sb = new StringBuilder();
        List<String> propozitii = extragePropozitie();
        for (String prop : propozitii) {
            String[] cuvinte = prop.trim().split("\\s+");
            if (cuvinte.length >= 1) sb.append(cuvinte[0]);
            if (cuvinte.length >= 2) sb.append(" ").append(cuvinte[1]);
            sb.append(". ");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return " [EditorText] --->>> paragraf= " + paragraf;
    }

    public static void main(String[] args) {
        EditorText editor = new EditorText(
                "Ana  are   mere. Ion  are  pere! Maria   are  prune..."
        );

        System.out.println("Original:      " + editor.getParagraf());

        editor.eliminaSpatii();
        System.out.println("Fara spatii:   " + editor.getParagraf());

        System.out.println("Nr cuvinte:    " + editor.numaraCuvinte());
        System.out.println("Aparitii 'are':" + editor.numaraAparitii("are"));
        System.out.println("Propozitii:    " + editor.extragePropozitie());

        editor.inlocuiesteCuLower("ANA");
        System.out.println("Dupa lower:    " + editor.getParagraf());

        System.out.println("Rezumat:       " + editor.rezumat());
    }
}
