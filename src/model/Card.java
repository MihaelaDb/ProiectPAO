package model;

import java.time.LocalDateTime;
import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    private String generateDataExpirarii() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int year = Calendar.getInstance().get(Calendar.YEAR) + random.nextInt(10);
        DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        Date expirationDate = null;
        try {
            expirationDate = dateFormat.parse(String.format("%02d", month) + "/" + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(expirationDate);
    }

    private int generateCVV() {
        var rand = new Random();
        return 100 + rand.nextInt(899);
    }

}


