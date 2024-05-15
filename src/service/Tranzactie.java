package service;
import model.ContBancar;

import java.util.Scanner;


    public class Tranzactie {
        private VizualizareSold vizualizareSold;
        private double sold;
        private VizualizareSold contVizualizare;

        public Tranzactie(double sold, VizualizareSold vizualizareSold) {
            this.sold = sold;
            this.vizualizareSold = vizualizareSold;
            this.contVizualizare = vizualizareSold;
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

