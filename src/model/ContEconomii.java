package model;

import java.util.Date;

public class ContEconomii {
    private Date dataInceput;
    private Date dataFinalizare;
    private int dobanda;
    private double suma;
    private String numeClient;
    private String prenumeClient;

    public ContEconomii(Date dataInceput, Date dataFinalizare, int dobanda, double suma) {
        this.dataInceput = dataInceput;
        this.dataFinalizare = dataFinalizare;
        this.dobanda = dobanda;
        this.suma = suma;
        this.numeClient = numeClient;
        this.prenumeClient = prenumeClient;
    }

    public Date getDataInceput() {
        return dataInceput;
    }

    public Date getDataFinalizare() {
        return dataFinalizare;
    }

    public int getDobanda() {
        return dobanda;
    }

    public double getSuma() {
        return suma;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public String getPrenumeClient() {
        return prenumeClient;
    }
}
