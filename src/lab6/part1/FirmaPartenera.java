package lab6.part1;

public class FirmaPartenera implements OperatiiContBancar, Comparable<FirmaPartenera> {
    private String denumire;
    private double buget;
    private double sold;

    public FirmaPartenera(String denumire, double buget, double sold) {
        this.denumire = denumire;
        this.buget = buget;
        this.sold = sold;
    }

    @Override
    public boolean autentificare() {
        System.out.println("[FIRMA] --->>>> " + denumire + " autentificata !!!");
        return true;
    }

    @Override
    public double soldCurent() {
        return sold;
    }

    @Override
    public void plata(double suma) {
        sold -= suma;
        System.out.println("[FIRMA] " + denumire + " a platit " + suma + ", sold ramas: " + sold);
    }

    // comparare descrescatoare dupa buget
    @Override
    public int compareTo(FirmaPartenera other) {
        return Double.compare(other.buget, this.buget);
    }

    @Override
    public String toString() {
        return "[FIRMA PARTENERA] --->>> denumire = " + denumire + " buget = " + buget + " sold = " + sold;
    }
}
