package model;

import java.time.LocalDateTime;

public class CursValutar {

    private  String valutaBaza;
    private  String valutaCotata;
    private  double rataSchimb;
    private LocalDateTime dataActualizare;
    private  String codValutar;

    public CursValutar(String valutaBaza, String valutaCotata, double rataSchimb, LocalDateTime dataActualizare, String codValutar) {
        this.valutaBaza = valutaBaza;
        this.valutaCotata = valutaCotata;
        this.rataSchimb = rataSchimb;
        this.dataActualizare = dataActualizare;
        this.codValutar = codValutar;
    }


    public CursValutar(int id, String valutaBaza, String valutaCotata, double rataSchimb) {
        this.valutaBaza = valutaBaza;
        this.valutaCotata = valutaCotata;
        this.rataSchimb=rataSchimb;
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


    public Object getId() {
        return null;
    }
}
