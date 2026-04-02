package lab6.part1;

public class Profesor implements OperatiiContBancar, Comparable<Profesor> {
    private String nume;
    private double salariu;
    private double sold;

    public Profesor(String nume, double salariu, double sold) {
        this.nume = nume;
        this.salariu = salariu;
        this.sold = sold;
    }

    @Override
    public boolean autentificare() {
        System.out.println("[PROFESOR] ---->>> " + nume + " autentificat!!!!!!");
        return true;
    }

    @Override
    public double soldCurent() {
        return sold;
    }

    @Override
    public void plata(double suma) {
        sold -= suma;
        System.out.println("[PROFESOR] ---->>> " + nume + " a platit " + suma + ", sold ramas: " + sold);
    }

    // comparare descrescatoare dupa salariu
    @Override
    public int compareTo(Profesor other) {
        return Double.compare(other.salariu, this.salariu);
    }

    @Override
    public String toString() {
        return "[PROFESOR] --->>> nume = " + nume + " salariu = " + salariu + " sold = " + sold;
    }
}
