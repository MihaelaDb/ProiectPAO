
package model;

import java.util.Date;

public class PlataFactura {
    private int id;
    private double suma;
    private String beneficiar;
    private Date dataPlatii;

    public PlataFactura(int id, double suma, String beneficiar, Date dataPlatii) {
        this.id = id;
        this.suma = suma;
        this.beneficiar = beneficiar;
        this.dataPlatii = dataPlatii;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getBeneficiar() {
        return beneficiar;
    }

    public void setBeneficiar(String beneficiar) {
        this.beneficiar = beneficiar;
    }

    public Date getDataPlatii() {
        return dataPlatii;
    }

    public void setDataPlatii(Date dataPlatii) {
        this.dataPlatii = dataPlatii;
    }
}
