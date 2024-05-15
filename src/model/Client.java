package model;

public class Client {

    private static String nume = "Dobromirescu", prenume = "Mihaela", CNP;
    private static String email = "dobromirecsu3@gmail.com";
    private static String telefon ="0744318808";
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


    public void afiseazaInformatiiClient(Client client1) {
        System.out.println("INFORMATIILE CONTULUI:");
        System.out.println("Nume: " + this.nume);
        System.out.println("Prenume: " + this.prenume);
        System.out.println("Email: " + this.email);
        System.out.println("Telefon: " + this.telefon);
        System.out.println("Data Nasterii: " + this.dataNasterii);
        System.out.println("Adresa: " + this.adresa);
    }
}

