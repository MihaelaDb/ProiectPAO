package model;

import java.util.Scanner;

public class ContBancar {

    private String IBAN;
    private String SWIFT;
    private double sold=76;
    private String nume;
    private String prenume;

    private String nrcontbancar;

    public ContBancar(String nume, String prenume, String nrcontbancar, double sold) {
        this.IBAN = this.getIBAN(nrcontbancar);
        this.SWIFT = this.generateSwift();
        this.sold = this.sold; // This assignment is unnecessary because 'sold' is already initialized above
        this.nume = nume;
        this.prenume = prenume;
        this.nrcontbancar = nrcontbancar;
    }

    private String getIBAN(String nrcontbancar) {
        String banca = "BTRLRONCRT";
        return "RO43" + banca + nrcontbancar;
    }

    private String generateSwift() {
        String banca = "BTRL";

        return "SWIFT" + banca + "22";
    }

    public double getSold() {
        return sold; // Moved the getSold() method inside the class body
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getSWIFT() {
        return SWIFT;
    }
    public void setSold(double sold) {
        this.sold = sold;
    }

    public void retrage(double suma) {
        Scanner scanner = new Scanner(System.in);
        suma = scanner.nextDouble();
        scanner.nextLine();
        if (suma > sold) {
            System.out.println("Nu aveti suficienti bani in cont. Soldul tau curent este: " + sold + " lei.");
        } else {
            sold -= suma;

        }
    } public ContBancar(double sold) {
        this.sold = sold;
    }

}
