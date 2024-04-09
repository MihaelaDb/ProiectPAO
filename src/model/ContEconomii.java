package model;

import java.util.Date;

import static java.util.Calendar.getInstance;

public class ContEconomii extends ContBancar {
    private  Date dataInceput = null , dataFinalizare = null;
    private  int dobanda = 0;
    private double suma;

    public ContEconomii(String nume, String prenume ){
        super(nume, prenume);

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


