package model;


public class ContBancar {

    protected String IBAN;
    protected String SWIFT;
    protected static double sold;
    protected String nume;
    protected String prenume;

    private String nrcontbancar;


    public ContBancar(String nume, String prenume) {
        this.IBAN = this.getIBAN(nrcontbancar);
        this.SWIFT = this.generateSwift();
        this.sold = sold;
        this.nume = this.nume;
        this.prenume = prenume;
        this.nrcontbancar = nrcontbancar;
    }

    public ContBancar(double Sold) {
        this.sold =sold;
    }


    private String getIBAN(String nrcontbancar) {
        String banca = "BTRLRONCRT";
        return "RO43" + banca + nrcontbancar;
    }

    private String generateSwift() {
        String banca = "BTRL";

        return "SWIFT" + banca + "22";
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

    public double getSold() {
        return this.sold;
    }
}


