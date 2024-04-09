package service;

import model.Card;

public class CreareCont {
    private String nume1;
    private String prenume1;
    private String email1;
    private String nrtelefon1;
    private Card card;

    public CreareCont(String nume, String prenume, String email, String nrtelefon) {
        this.nume1 = nume1;
        this.prenume1 = prenume1;
        this.email1 = email1;
        this.nrtelefon1 = nrtelefon1;
        this.card = generateCard();
    }


    public Card generateCard() {
        String numarCard = generateNumarCard();
        int cvv = generateCVV();
        String dataExpirarii = generateDataExpirarii();
        return new Card(nume1, prenume1, numarCard, cvv, dataExpirarii);
    }

    public void displayAccountDetails() {
        System.out.println("Detalii cont:");
        System.out.println("Nume: " + nume1);
        System.out.println("Prenume: " + prenume1);
        System.out.println("Email: " + email1);
        System.out.println("Numar de telefon: " + nrtelefon1);
        System.out.println("Detalii card:");
        System.out.println("Numar card: " + card.getNumarCard());
        System.out.println("CVV: " + card.getCVV());
        System.out.println("Data expirarii: " + card.getDataExpirarii());
    }

    private String generateNumarCard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    private String generateDataExpirarii() {
        int month = (int) (Math.random() * 12) + 1;
        int year = (int) (Math.random() * 10) + 2022;
        return String.format("%02d/%d", month, year);
    }

    private int generateCVV() {
        return (int) (Math.random() * 900) + 100;
    }
}
