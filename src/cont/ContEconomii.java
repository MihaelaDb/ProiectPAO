package cont;

import java.util.Calendar;
import java.util.Date;

public class ContEconomii extends ContBancar{
    private  Date dataInceput = null , dataFinalizare = null;
    private  int Dobanda = 0;
    private double Suma;

    public ContEconomii(String Nume, int ClientID, int ClientId) {
        super(Nume, ClientID, getInstance().ClientID);
        this.dataInceput = new Date();
        this.Dobanda = 3;
        this.Suma=0.0;

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        this.dataFinalizare = c.getTime();
    }
    public ContEconomii(String IBAN, String swift, double Suma, String Nume, int ClientID){
        super();

        this.dataInceput = dataInceput;
        this.dataFinalizare = dataFinalizare;
        this.Dobanda = Dobanda;
        this.Suma=Suma;

    }
    public Date getDataInceput() {
        return dataInceput;
    }
    public Date getDataFinalizare(){
        return dataFinalizare;
    }
    public int getDobanda(){
        return Dobanda;
    }
    public double getSuma() {
        return Suma;
    }

    public void setSuma(double suma) {
        this.Suma = Suma;
    }


}

