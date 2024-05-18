package model;
import java.sql.Date;
import java.util.Random;
public class Card {
    private int id;
    private int cvv;
    private String numarCard;

    private Date dataExpirarii;

private String nume = "";
private String prenume="";
    public Card(int id, String numarCard, String cvv, Date dataExpirarii) {
        this.numarCard = this.generateNumarCard();
        this.id=id;
        this.cvv = this.generateCVV();
        this.dataExpirarii = Date.valueOf(generateDataExpirarii());
    }

    public int getId(){
        return id;
    }


    public int getCVV() {
        return cvv;
    }

    public String getNumarCard() {
        return numarCard;
    }



    public Date getDataExpirarii() {
        return dataExpirarii;
    }
    public String getNume(){
        return nume;}
    public String getPrenume(){
        return prenume;}

    public String generateNumarCard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append(" ");
            }
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }


    public String generateDataExpirarii() {
        int year = 2030;
        int month = (int) (Math.random() * 12) + 1;
        int day = (int) (Math.random() * 28) + 1;
        return String.format("%d-%02d-%02d", year, month, day);
    }



    public int generateCVV(){
        var rand = new Random();
        return 100 + rand.nextInt(899);
    }


    public void setId(int idGenerated){
        this.id=id;
    }
}