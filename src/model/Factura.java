package model;

import java.util.Date;

public class Factura {
    private String tipFactura;
    private double suma;
    private Date dataScadenta;
    private Date dataPlatii;
    private ContBancar contBancar;

    public Factura(String tipFactura, double suma, Date dataScadenta, ContBancar contBancar) {
        this.tipFactura = tipFactura;
        this.suma = suma;
        this.dataScadenta = dataScadenta;
        this.contBancar=contBancar;
    }

    public String getTipFactura() {
        return tipFactura;
    }

    public void setTipFactura(String tipFactura) {
        this.tipFactura = tipFactura;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Date getDataScadenta() {
        return dataScadenta;
    }

    public void setDataScadenta(Date dataScadenta) {
        this.dataScadenta = dataScadenta;
    }

    public Date getDataPlatii() {
        return dataPlatii;
    }

    public void setDataPlatii(Date dataPlatii) {
        this.dataPlatii = dataPlatii;
    }

    public ContBancar getContBancar() {
        return contBancar;
    }

    public void setContBancar(ContBancar cont) {
        this.contBancar = contBancar;
    }

    public void proceseazaPlata() {
        if (contBancar.getSold() >= suma) {
            contBancar.setSold(contBancar.getSold() - suma);
            this.dataPlatii = new Date();
            System.out.println("Factura de tip " + tipFactura + " în valoare de " + suma + " a fost plătită cu succes pe data de " + dataPlatii);
        } else {
            System.out.println("Fonduri insuficiente pentru a plăti factura de tip " + tipFactura);
        }
    }

    public void afiseazaInformatiiPlata() {
        System.out.println("Tip Factura: " + getTipFactura());
        System.out.println("Suma: " + suma);
        System.out.println("Data Scadenta: " + getDataScadenta());
        System.out.println("Data Plății: " + (getDataPlatii() != null ? dataPlatii : "Neplătită"));
        System.out.println("Client: " + contBancar.getNume() + " " + contBancar.getPrenume());
    }
}
