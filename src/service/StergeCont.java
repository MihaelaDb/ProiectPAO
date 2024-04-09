package service;


public class StergeCont {
    private String nume;
    private String prenume;
    private String email;
    private String nrtelefon;

    public StergeCont(String nume, String prenume, String email, String nrtelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.nrtelefon = nrtelefon;
    }

    public void deleteAccount() {
        System.out.println("Contul pentru " + nume + " " + prenume + " a fost sters cu succes!");
    }


    public void afiseazaInformatiiStergere() {
        System.out.println("Detalii cont sters:");
        System.out.println("Nume: " + nume);
        System.out.println("Prenume: " + prenume);
        System.out.println("Email: " + email);
        System.out.println("Numar de telefon: " + nrtelefon);
    }
}


