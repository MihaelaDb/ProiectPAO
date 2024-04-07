package cont;

import java.time.LocalDateTime;

public class CursValutar {
    public static void main(String[] args) {
        CursValutar curs = new CursValutar("USD", "EUR", 0.85, LocalDateTime.now(), "USD_EUR");

        curs.afiseazaInformatii();
    }

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
    public void afiseazaInformatii() {
        System.out.println("Valuta de baza: " + valutaBaza);
        System.out.println("Valuta cotata: " + valutaCotata);
        System.out.println("Rata de schimb: " + rataSchimb);
        System.out.println("Data actualizarii: " + dataActualizare);
        System.out.println("Cod valutar: " + codValutar);
    }
}
