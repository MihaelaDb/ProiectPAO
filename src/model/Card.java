package model;
import java.util.Random;
public class Card {
    private int cvv;
    private String numarCard;
    private String nume;
    private String prenume;
    private String dataExpirarii;


    public Card(String nume,String prenume, String numarCars, int cvv, String dataExpirarii ) {
        this.nume = nume;
        this.numarCard = this.generateNumarCard();
        this.cvv = this.generateCVV();
        this.prenume=prenume;
        this.dataExpirarii = generateDataExpirarii();
    }


    public int getCVV() {
        return cvv;
    }

    public String getNumarCard() {
        return numarCard;
    }

    public String getNume() {
        return nume;
    }

    public String getDataExpirarii() {
        return dataExpirarii;
    }

    public String getPrenume() {
        return prenume;
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

}


