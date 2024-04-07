package cont;


import servicii.Tranzactie;

public class ContBancar{
    public static void main(String[] args){
        ContBancar cont = new ContBancar();
        cont.afiseazaInformatii();
    }
    protected String IBAN;
    protected  String swift;
    protected static double Sold;
    protected String Nume="Dobromirescu";
    protected String Prenume="Mihaela";
    protected int ClientID=123;
    private static ContBancar instance;
    private String nrcontbancar= "1234567891234567" ;
    public ContBancar(){
        this.IBAN = this.getIBAN(nrcontbancar);
        this.swift = this.generateSwift();
        this.Sold = 0;
        this.Nume = Nume;
        this.ClientID = ClientID;
        this.Prenume = Prenume;
        this.nrcontbancar=nrcontbancar;
    }

    public ContBancar(String Nume, int ClientID, int clientID)
    {

        this.IBAN = this.getIBAN(nrcontbancar);
        this.swift = this.generateSwift();
        this.Nume = Nume;
        this.ClientID = ClientID;

    }
    public ContBancar(double Sold){
        this.Sold = 0;
    }
    private String getIBAN(String nrcontbancar) {
        String banca = "BTRLRONCRT";
        return "RO43" + banca + nrcontbancar ;
    }

    private String generateSwift() {
        String banca = "BTRL";

        return "SWIFT" + banca + "22";
    }
    public String getNume(){
        return Nume;
    }
    public int getClientID(){
        return ClientID;
    }
    public String getIBAN(){
        return IBAN;
    }
    public double getSuma(){
        return Sold;
    }
    public String getSwift(){
        return swift;
    }
private void afiseazaInformatii(){
    System.out.println("INFORMATII CONT CLIENT:");
    System.out.println("IBAN: " + IBAN);
    System.out.println("SWIFT: " + swift);
    System.out.println("Nume: " + Nume + " " + Prenume);
    System.out.println("Sold: " + Sold);
    System.out.println("ClientId:" + ClientID);
}

public static ContBancar getInstance(){
        if(instance == null) {
            instance = new ContBancar();
        }
        return (ContBancar) instance;
}
public void setSold(double Sold){
        this.Sold = Sold;
}
public double getSold(){
        return this.Sold;
}
    public String getPrenume() {

        return Prenume;
    }

    public void stergeContul() {
        this.IBAN = null;
        this.swift = null;
        this.Sold = 0;
        this.Nume = null;
        this.Prenume = null;
        this.ClientID = 0;
        this.nrcontbancar = null;
    }
}
