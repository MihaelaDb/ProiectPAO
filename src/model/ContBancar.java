package model;

public class ContBancar {

    private String IBAN;
    private String SWIFT;
    private double sold=76;
    private String nume;
    private String prenume;

    private String nrcontbancar;

    public ContBancar(String nume, String prenume, String nrcontbancar, double sold) {
        this.IBAN = this.getIBAN(nrcontbancar);
        this.SWIFT = this.generateSwift();
        this.sold = sold; // This assignment is unnecessary because 'sold' is already initialized above
        this.nume = nume;
        this.prenume = prenume;
        this.nrcontbancar = nrcontbancar;
    }

    private String getIBAN(String nrcontbancar) {
        String banca = "BTRLRONCRT";
        return "RO43" + banca + nrcontbancar;
    }

    private String generateSwift() {
        String banca = "BTRL";

        return "SWIFT" + banca + "22";
    }

    public double getSold() {
        return sold;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getSWIFT() {
        return SWIFT;
    }
    public void setSold(double sold) {
        this.sold = sold;
    }
     public ContBancar(double sold) {
        this.sold = sold;
    }

}
