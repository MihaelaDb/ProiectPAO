package model;

import java.util.Date;


public class ContEconomii extends ContBancar {
    private  Date dataInceput = null , dataFinalizare = null;
    private  int dobanda = 0;
    private double suma;

    public ContEconomii(String nume, String prenume, String nrcontbancar, double sold){
        super(nume, prenume, nrcontbancar, sold);

        this.dataInceput = dataInceput;
        this.dataFinalizare = dataFinalizare;
        this.dobanda = dobanda;
        this.suma=suma;

    }
    public Date getDataInceput() {
        return dataInceput;
    }
    public Date getDataFinalizare(){
        return dataFinalizare;
    }
    public int getDobanda(){
        return dobanda;
    }
    public double getSuma() {
        return suma;
    }



}


