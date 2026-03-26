package lab5.exercitiu2;

public class Main {
    public static void main(String[] args) {
        Facultate fmi = new Facultate("FMI");

        // student imutabil clasic
        Student s1 = new Student("Ana", fmi);
        System.out.println(s1);
        System.out.println(s1.getFacultate().getNume());

        /*
        // student Record
        // getter ul se numeste nume() nu getNume()
        Student s2 = new Student("Ion", fmi);
        System.out.println(s2.nume());
        System.out.println(s2.facultate().getNume());
        System.out.println(s2);
        */
    }
}
