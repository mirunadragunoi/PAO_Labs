package lab4.sistem_cursuri_digitale;

// o sa existe in compozitie cu Curs

public class LectieCurs {
    private String titlu;
    private String continut;
    private int durata;

    // constructor
    public LectieCurs(String titlu, String continut, int durata) {
        this.titlu = titlu;
        this.continut = continut;
        this.durata = durata;
    }

    // constructor copiere
    public LectieCurs(LectieCurs l) {
        this.titlu = l.titlu;
        this.continut = l.continut;
        this.durata = l.durata;
    }

    // getteri
    public String getTitlu() {
        return titlu;
    }

    public String getContinut() {
        return continut;
    }

    public int getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        return "[LECTIE] --->> titlu: " + titlu + " continut: " + continut + " durata: " + durata + " min ";
    }
}
