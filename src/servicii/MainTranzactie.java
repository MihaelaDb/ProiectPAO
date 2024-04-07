package servicii;

import java.util.Scanner;

public class MainTranzactie {
    public static void main(String[] args) {
        VizualizareSold contVizualizare = new VizualizareSold(1000.0);
        Tranzactie tranzactie = new Tranzactie(1000.0, contVizualizare);

        System.out.println("Soldul initial: " + tranzactie.getSold() + " lei");

        while (true) {
            tranzactie.efectueazaTranzactie();
            System.out.println("Soldul curent: " + tranzactie.getSold() + " lei");

            System.out.println("Doriti sa efectuati o alta tranzactie? (da/nu)");
            String response = new Scanner(System.in).nextLine();
            if (!response.equalsIgnoreCase("da")) {
                System.out.println("Va multumim pentru utilizare. O zi buna!");
                break;
            }
        }
    }
}
