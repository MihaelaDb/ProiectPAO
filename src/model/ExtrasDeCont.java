package model;

import java.util.Date;

public class ExtrasDeCont {
    private String descriere;
    private double amount;
    private Date data;
    private ExtrasDeCont tip;
    private Client client;

    public ExtrasDeCont(String descriere, double amount, Date data, ExtrasDeCont tip, Client client) {
        this.descriere = descriere;
        this.amount = amount;
        this.data = data;
        this.tip = tip;
        this.client = client;
    }

    public ExtrasDeCont(String descriere, double amount, ExtrasDeCont tip, Client client) {
        this.descriere = descriere;
        this.amount = amount;
        this.data = new Date();
        this.tip = tip;
        this.client = client;
    }


    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date timestamp) {
        this.data = data;
    }

    public ExtrasDeCont getTip() {
        return tip;
    }

    public void setTip(ExtrasDeCont tip) {
        this.tip = tip;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public enum Tip {
        TRANSACTION,
        PAYMENT,
        WITHDRAWAL,
        DEPOSIT,
    }

    public void afiseazaInformatiiExtras() {
        System.out.println("INFORMATII EXTRAS DE CONT:");
        System.out.println("Descriere: " + getDescriere());
        System.out.println("Suma: " + getAmount());
        System.out.println("Data: " + getData());
    }

}
