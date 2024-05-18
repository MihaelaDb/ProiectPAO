package model;

public class SchimbValutar {
    private int id;
    private double suma;
    private double sumaSchimbata;

    public SchimbValutar(int id, double suma, String codValutar) {
        this.id = id;
        this.suma = suma;
    }

    public double getSuma() {
        return suma;
    }

    public double getSumaSchimbata() {
        return sumaSchimbata;
    }

    public void setSumaSchimbata(double sumaSchimbata) {
        this.sumaSchimbata = sumaSchimbata;
    }

    public int getId(){
        return id;
    }
}
