package client;

public class Client {

    private String Nume ="Dobromirescu", Prenume="Mihaela", CNP;
    private String Email = "dobromirecsu3@gmail.com";
    private String Telefon;
    private String DataNasterii = "15.09.2003";
    private String Adresa = "Strada Clea Brailei, nr 6, Cerna, Tulcea";

    private int clientID = 0;

    public Client() {
       
    }


    public String getNume() {
        return Nume;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }

    public String getDataNasterii() {
        return DataNasterii;
    }

    public void setDataNasterii(String DataNasterii) {
        this.DataNasterii = DataNasterii;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    
    public void afiseazaInformatii() {
        System.out.println("INFORMATIILE CONTULUI:");
        System.out.println("Nume: " + Nume);
        System.out.println("Prenume: " + Prenume);
        System.out.println("Email: " + Email);
        System.out.println("Telefon: " + Telefon);
        System.out.println("Data Nasterii: " + DataNasterii);
        System.out.println("Adresa: " + Adresa);
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.afiseazaInformatii();
    }
}
