package model;

import java.util.Date;

public class ExtrasDeCont {
    private int id;
    private int contId;
    private String actiune;
    private double suma;
    private Date data;

    public ExtrasDeCont(int id, int contId, String actiune, double suma, Date data) {
        this.id = id;
        this.contId = contId;
        this.actiune = actiune;
        this.suma = suma;
        this.data = data;
    }


}
