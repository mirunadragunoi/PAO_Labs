package lab4;

public class pb1_string {
    public static void main(String[] args) {
        String str = "ab3cd2ba1cdef";
        String best = "";

        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char lastLitera = 0;

            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);

                if (Character.isDigit(c)) {
                    // cifra ->> nu includem
                } else {
                    // litera ->>> verificam daca e in ordine alfabetica
                    if (lastLitera == 0 || c >= lastLitera) {
                        sb.append(c);
                        lastLitera = c;
                    } else {
                        break; // ruptura ->> oprim substringul curent
                    }
                }
            }

            if (sb.length() > best.length()) {
                best = sb.toString();
            }
        }

        System.out.println("Substringul maxim: " + best);
    }
}
