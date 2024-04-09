package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CursValutar {

    private final String valutaBaza;
    private final String valutaCotata;
    private final double rataSchimb;
    private final LocalDateTime dataActualizare;
    private final String codValutar;

    public CursValutar(String valutaBaza, String valutaCotata, double rataSchimb, LocalDateTime dataActualizare, String codValutar) {
        this.valutaBaza = valutaBaza;
        this.valutaCotata = valutaCotata;
        this.rataSchimb = rataSchimb;
        this.dataActualizare = dataActualizare;
        this.codValutar = codValutar;
    }

    public String formatExchangeRate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dataActualizare.format(formatter);
        return String.format("Rata de schimb pentru %s către %s: %.2f (la data de %s)", valutaBaza, valutaCotata, rataSchimb, formattedDate);
    }


    public String getValutaBaza() {
        return valutaBaza;
    }

    public String getValutaCotata() {
        return valutaCotata;
    }

    public double getRataSchimb() {
        return rataSchimb;
    }

    public LocalDateTime getDataActualizare() {
        return dataActualizare;
    }

    public String getCodValutar() {
        return codValutar;
    }

}
