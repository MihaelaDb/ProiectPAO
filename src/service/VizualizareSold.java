package service;


import model.ContBancar;

public class VizualizareSold extends ContBancar {

    public VizualizareSold(double sold) {
        super("", "", "", sold);
    }

    public void afiseazaSold(VizualizareSold vizualizareSold) {
        System.out.println("Soldul dvs. este: " + getSold());
    }

    public void actualizeazaSold(double suma) {
        setSold(getSold() + suma);
    }
}
