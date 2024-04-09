package service;

import model.ContBancar;

public class VizualizareSold extends ContBancar {

    public VizualizareSold(double Sold) {
        super(Sold);
    }

    public void afiseazaSold() {
        System.out.println("Soldul dvs. este: " + VizualizareSold.sold);
    }

    public void actualizeazaSold(double suma) {

        sold += suma;
    }
}
