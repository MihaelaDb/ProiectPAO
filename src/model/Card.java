package model;
import java.util.Random;
public class Card {
    private int cvv;
    private String numarCard;

    private String dataExpirarii;

    private Client client;


    public Card( String numarCard, int cvv, String dataExpirarii, Client client ) {
        this.numarCard = this.generateNumarCard();
        this.cvv = this.generateCVV();
        this.dataExpirarii = generateDataExpirarii();
        this.client=client;
    }


    public int getCVV() {
        return cvv;
    }

    public String getNumarCard() {
        return numarCard;
    }



    public String getDataExpirarii() {
        return dataExpirarii;
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
        var rand = new Random();
        return 100 + rand.nextInt(899);
    }
    public void afiseazaInformatiiCard() {
        System.out.println("INFORMATIILE CARDULUI:");
        System.out.println("Card Number: 4140 " + getNumarCard());
        System.out.println("Expiration Date: " + getDataExpirarii());
        System.out.println("CVV: " + getCVV());
        System.out.println("Client Nume: " + client.getNume());
        System.out.println("Client Prenume: " + client.getPrenume());
    }

}


