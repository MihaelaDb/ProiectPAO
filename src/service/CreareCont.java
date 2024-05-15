package service;

import model.Card;

public class CreareCont {
    private String nume1;
    private String prenume1;
    private String email1;
    private String nrtelefon1;
    private Card card;

    public CreareCont(String nume, String prenume, String email, String nrtelefon) {
        this.nume1 = nume;
        this.prenume1 = prenume;
        this.email1 = email;
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
        System.out.println("Nume: " + this.nume1);
        System.out.println("Prenume: " + this.prenume1);
        System.out.println("Email: " + this.email1);
        System.out.println("Numar de telefon: " + nrtelefon1);
        System.out.println("Detalii card:");
        System.out.println("Numar card: 4140 "+ card.getNumarCard());
        System.out.println("CVV: " + card.getCVV());
        System.out.println("Data expirarii: " + card.getDataExpirarii());
    }

    private String generateNumarCard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append(" ");
            }
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }


    private String generateDataExpirarii() {
        int month = (int) (Math.random() * 12) + 1;
        int year = 2030;
        return String.format("%02d/%d", month, year);
    }

    private int generateCVV() {
        return (int) (Math.random() * 900) + 100;
    }
}
