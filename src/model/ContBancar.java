package model;

public class ContBancar {
    private int id;
    private int clientId;
    private String iban;
    private String swift;
    private double sold;

    public ContBancar(int id, String iban, String swift, double sold) {
        this.id = id;
        this.iban = iban;
        this.swift = swift;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public double getSold() {
        return sold;
    }



    public String generateIBAN() {
        String banca = "BT";
        return "RO06" + banca + "B" + id;
    }

    public String generateSwift() {
        String banca = "BT";
        return "SWIFT" + banca + "B" + id;
    }
}
