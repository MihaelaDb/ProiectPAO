package model;


import java.sql.Date;

public class Client {

    private  String nume;
    private  String prenume;

    private String email;
    private String telefon;
    private Date data_nasterii;
    private String adresa;
    private final int id;

    public Client(int id, String nume, String prenume, String email, String telefon, Date data_nasterii, String adresa) {

        this.id=id;
        this.nume=nume;
        this.prenume=prenume;
        this.email=email;
        this.telefon=telefon;
        this.data_nasterii=data_nasterii;
        this.adresa=adresa;

    }

    public String getNume() {
        return nume;
    }



    public String getPrenume() {
        return prenume;
    }



    public String getEmail() {
        return email;
    }


    public String getTelefon() {
        return telefon;
    }


    public Date getDataNasterii() {
        return data_nasterii ;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getId(){
        return id;
    }

    public Client(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

}
