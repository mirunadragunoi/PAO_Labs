package lab11.part1;

public class Student {
    private String nume;
    private String grupa;
    private double nota;

    public Student(String nume, String grupa, double nota) {
        this.nume = nume;
        this.grupa = grupa;
        this.nota = nota;
    }

    public String getNume() { return nume; }
    public String getGrupa() { return grupa; }
    public double getNota() { return nota; }

    @Override
    public String toString() {
        return nume + " (" + grupa + ") - " + nota;
    }
}
