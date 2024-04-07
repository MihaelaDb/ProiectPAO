package card;

import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Card {
    private  int CVV = 0;
    private String IBAN;
    private String NumarCard;
    private String Nume = "Dobromirescu";
    private String Prenume = "Mihaela";
    private String DataExpirarii;
    private String numarcontbancar = "1234567891234567";

    public Card() {

        this.IBAN = getIBAN(numarcontbancar);
        this.Nume = Nume;
        this.NumarCard = this.generateNumarCard();
        this.CVV = this.generateCVV();
        this.Prenume=Prenume;
        this.numarcontbancar = numarcontbancar;
        this.DataExpirarii=generateDataExpirarii();
    }

    public String getIBAN() {
        return IBAN;
    }
    public void setIBAN() {
        this.IBAN = IBAN;
    }

    public int getCVV() {
        return CVV;
    }
    public void setCVV() {
        this.CVV = CVV;
    }
    public String getNumarCard() {
        return NumarCard;
    }
    public void setNumarCard() {
        this.NumarCard = NumarCard;
    }
    public String getNume() {
        return Nume;
    }
    public void setNume() {
        this.Nume = Nume;
    }
    public String getDataExpirarii() {
        return DataExpirarii;
    }
    public void setDataExpirarii() {
        this.DataExpirarii = DataExpirarii;
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
    private String getIBAN(String nrcontbancar) {
        String banca = "BTRLRONCRT";
        return "RO43" + banca + nrcontbancar ;
    }


    public static void main(String[] args) {
        Card card = new Card();


        System.out.println("IBAN: " + card.getIBAN());
        System.out.println("CVV: " + card.getCVV());


        card.displayCardInfo();
    }
    public void displayCardInfo() {
        System.out.println("Nume: " + Nume);
        System.out.println("Prenume: " + Prenume);
        System.out.println("Numar Card: " + NumarCard);
        System.out.println("Data Expirarii: " + DataExpirarii);
    }

}
