package lab6;

public class Student implements OperatiiContBancar, Comparable<Student>{
    private String nume;
    private double medie;
    private double sold;

    public Student(String nume, double medie, double sold) {
        this.nume = nume;
        this.medie = medie;
        this.sold = sold;
    }

    @Override
    public boolean autentificare() {
        System.out.println("[STUDENT] --->>> " + nume + " autentificat!!!!");
        return true;
    }

    @Override
    public double soldCurent() {
        return sold;
    }

    @Override
    public void plata(double suma) {
        sold -= suma;
        System.out.println("[STUDENT] ----->>> " + nume + " a platit " + suma + ", sold ramas: " + sold);
    }

    // comparare alfabetica dupa nume
    @Override
    public int compareTo(Student student) {
        return this.nume.compareTo(student.nume);
    }

    @Override
    public String toString() {
        return "[STUDENT] --->>> nume = " + nume + " medie = " + medie + " sold = " + sold;
    }
}
