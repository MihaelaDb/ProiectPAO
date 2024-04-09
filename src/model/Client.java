package model;

public class Client {

    private static  String nume ="Dobromirescu", prenume="Mihaela", CNP;
    private static String email = "dobromirecsu3@gmail.com";
    private static String telefon;
    private static String dataNasterii = "15.09.2003";
    private static String adresa = "Strada Clea Brailei, nr 6, Cerna, Tulcea";

    private static int clientID = 0;

    public Client(String nume, String prenume, String CNP, String email, String telefon, String dataNasterii, String adresa, int clientID) {
       
    }


    public String getNume() {
        return nume;
    }



    public String getPrenume() {
        return prenume;
    }


    public String getCNP() {
        return CNP;
    }



    public String getEmail() {
        return email;
    }



    public String getTelefon() {
        return telefon;
    }



    public String getDataNasterii() {
        return dataNasterii;
    }



    public String getAdresa() {
        return adresa;
    }



    
    public void afiseazaInformatii() {
        System.out.println("INFORMATIILE CONTULUI:");
        System.out.println("Nume: " + nume);
        System.out.println("Prenume: " + prenume);
        System.out.println("Email: " + email);
        System.out.println("Telefon: " + telefon);
        System.out.println("Data Nasterii: " + dataNasterii);
        System.out.println("Adresa: " + adresa);
    }


    public static void main(String[] args) {
        Client client = new Client(nume, prenume, CNP, email, telefon, dataNasterii, adresa, clientID);
        client.afiseazaInformatii();
    }

    public void afiseazaInformatiiClient(Client client1) {
    }
}
