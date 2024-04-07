package servicii;

import cont.ContBancar;

public class VizualizareSold extends ContBancar {

    public VizualizareSold(double Sold) {
        super(Sold);
    }

    public void actualizeazaSold(double Sold) {
        setSold(Sold);
    }

    public void afiseazaSold() {
        System.out.println("Soldul contului bancar este: " + getSold() + " lei.");
    }

    public static void main(String[] args) {
        ContBancar cont = ContBancar.getInstance();
        VizualizareSold vizualizareSold = new VizualizareSold(cont.getSold());
        vizualizareSold.afiseazaSold();


        Tranzactie tranzactie = new Tranzactie(cont.getSold());
        tranzactie.efectueazaTranzactie();


        vizualizareSold.actualizeazaSold(cont.getSold());
        vizualizareSold.afiseazaSold();
    }
}
