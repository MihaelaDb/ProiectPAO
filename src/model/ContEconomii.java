package model;

import java.util.Date;


public class ContEconomii {
    private  Date dataInceput = null , dataFinalizare = null;
    private  int dobanda = 0;
    private double suma;

    private Client client;

    public ContEconomii(Date dataInceput, Date dataFinalizare, int dobanda, double suma, Client client){
        this.dataInceput = dataInceput;
        this.dataFinalizare = dataFinalizare;
        this.dobanda = dobanda;
        this.suma=suma;
        this.client=client;

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



    public void afiseazaInformatiiContEconomii(){
        System.out.println("INFORMATII CONT ECONOMII: ");
        System.out.println("Nume: " + client.getNume());
        System.out.println("Prenume: " + client.getPrenume());
        System.out.println("Data Inceperii: " + getDataInceput());
        System.out.println("Data Finalizare: " + getDataFinalizare());
        System.out.println("Dobanda: " + getDobanda());
        System.out.println("Suma: " + getSuma());



    }


}


