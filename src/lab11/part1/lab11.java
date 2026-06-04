package lab11.part1;

import java.util.*;
import java.util.stream.*;

public class lab11 {
    public static void main(String[] args) {
        List<Student> studenti = List.of(
            new Student("Ana", "MI221", 9.5),
            new Student("Bogdan", "MI221", 4.8),
            new Student("Cristina", "MI222", 8.7),
            new Student("Dan", "MI221", 6.2),
            new Student("Elena", "MI222", 10.0),
            new Student("Florin", "MI223", 5.5),
            new Student("George", "MI223", 3.9),
            new Student("Irina", "MI222", 7.8)
        );

        // caut numele studentilor promovati cu litere mari
        List<String> promovati = studenti.stream()
                // doar cei cu media peste 5
                .filter(s -> s.getNota() >= 5)
                // transform numele sa fie toate caracterele cu majuscule
                .map(s -> s.getNume().toUpperCase())
                // pun efectiv rezultatele in lista
                .collect(Collectors.toList());

        System.out.println("STUDENTI PROMOVATIIII!!!: " + promovati);

        // media maxima a unui student
        OptionalDouble medie_maxima = studenti.stream()
                // extrag notele ca double
                .mapToDouble(Student::getNota)
                // gasesc maximul direct cu functia
                .max();

        medie_maxima.ifPresent(max -> System.out.println("NOTA MAXIMA ESTE::" + max));
    }
}
