package model;

import java.util.Scanner;

public class SchimbValutar {
    private static double rataRONtoEUR;
    private static double sumaSchimbata;
    private static ContBancar contBancar;

    public SchimbValutar(double rataRONtoEUR, ContBancar contBancar) {
        SchimbValutar.rataRONtoEUR = rataRONtoEUR;
        SchimbValutar.contBancar = contBancar;
    }

    public void setRataRONtoEUR(double rataRONtoEUR) {
        SchimbValutar.rataRONtoEUR = rataRONtoEUR;
    }

    public static void convertesteRONtoEUR() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti suma pe care doriti sa o convertiti:");
        double suma = scanner.nextDouble();
        double sold = contBancar.getSold();

        if (suma > sold) {
            System.out.println("Nu aveti suficienti bani in cont. Introduceti alta suma: ");
            double suma2 = scanner.nextDouble();
            sumaSchimbata = suma2 /rataRONtoEUR;
        } else {
            sumaSchimbata = suma / rataRONtoEUR;
            contBancar.setSold(sold - suma);
            System.out.println("Suma schimbata: " + sumaSchimbata + " EUR");
        }
    }

    public double getSumaSchimbata() {
        return sumaSchimbata;
    }
}
