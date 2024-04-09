package service;

import java.util.Scanner;

public class Tranzactie {
    private double sold;
    private VizualizareSold contVizualizare;

    public Tranzactie(double soldInitial, VizualizareSold contVizualizare) {
        this.sold = soldInitial;
        this.contVizualizare =contVizualizare;
    }

    public Tranzactie(double sold) {
    }

    public double getSold() {
        return sold;
    }

    public void efectueazaTranzactie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selectati operatia dorita:");
        System.out.println("1. Depunere");
        System.out.println("2. Retragere");
        System.out.println("3. Transfer");
        System.out.print("Introduceti numarul operatiei: ");
        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune) {
            case 1:
                depune();
                break;
            case 2:
                retrage();
                break;
            case 3:
                transfera();
                break;
            default:
                System.out.println("Optiune invalida.");
        }
    }

    public void depune() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti suma pe care doriti sa o depuneti: ");
        double suma = scanner.nextDouble();
        scanner.nextLine();
        sold += suma;
        contVizualizare.actualizeazaSold(sold);
        System.out.println("Ati depus " + suma + " lei. Soldul tau curent este: " + sold + " lei.");
    }

    public void retrage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti suma pe care doriti sa o retrageti: ");
        double suma = scanner.nextDouble();
        scanner.nextLine();
        if (suma > sold) {
            System.out.println("Nu aveti suficienti bani in cont. Soldul tau curent este: " + sold + " lei.");
        } else {
            sold -= suma;
            contVizualizare.actualizeazaSold(sold);
            System.out.println("Ati retras " + suma + " lei. Soldul tau curent este: " + sold + " lei.");
        }
    }

    public void transfera() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti suma pe care doriti sa o transferati: ");
        double suma = scanner.nextDouble();
        scanner.nextLine();
        if (suma > sold) {
            System.out.println("Nu aveti suficienti bani in cont pentru a efectua transferul.");
        } else {
            sold -= suma;
            contVizualizare.actualizeazaSold(sold);
            System.out.println("Ati transferat " + suma + " lei. Soldul tau curent este: " + sold + " lei.");
        }
    }
}
