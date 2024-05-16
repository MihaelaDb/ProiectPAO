import model.Client;
import model.ContBancar;
import model.CursValutar;
import model.SchimbValutar;
import service.CreareCont;
import service.StergeCont;
import service.Tranzactie;
import service.VizualizareSold;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        String nume = "Dobromirescu";
        String prenume = "Mihaela";
        String CNP = "1234567890123";
        String email = "dobromirescu3@gmail.com";
        String telefon = "0744318808";
        String dataNasterii = "15.09.2003";
        String adresa = "Strada Calea Brailei, nr 6";
        int clientID = 1;
        double sold = 1200;

        ContBancar contBancar = new ContBancar(sold);
        VizualizareSold vizualizareSold = new VizualizareSold(sold);
        Tranzactie tranzactie = new Tranzactie(sold, vizualizareSold);
        SchimbValutar schimbValutar = new SchimbValutar(4.87, contBancar);

        do {
            System.out.println("Meniu:");
            System.out.println("1. Vizualizare Detalii Cont Client");
            System.out.println("2. Vizualizare Sold");
            System.out.println("3. Tranzactii");
            System.out.println("4. Conversie Valutara");
            System.out.println("5. Creare Cont");
            System.out.println("6. Stergere Cont");
            System.out.println("7. Vizualizeaza Cursul Valutar");
            System.out.println("8. Iesire");
            System.out.print("Alege optiunea: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Vizualizare Detalii Cont Client:");
                    Client client1 = new Client(nume, prenume, CNP, email, telefon, dataNasterii, adresa, clientID);
                    client1.afiseazaInformatiiClient(client1);
                    break;
                case 2:
                    System.out.println("Vizualizare Sold:");
                    vizualizareSold.afiseazaSold(vizualizareSold);
                    break;
                case 3:
                    int subChoice;
                    do {
                        System.out.println("Tranzactii:");
                        System.out.println("1. Depunere");
                        System.out.println("2. Retragere");
                        System.out.println("3. Transfer");
                        System.out.println("4. Inapoi la meniul principal");

                        subChoice = scanner.nextInt();

                        switch (subChoice) {
                            case 1:
                                tranzactie.depune();
                                break;
                            case 2:
                                tranzactie.retrage();
                                break;
                            case 3:
                                tranzactie.transfera();
                                break;
                            case 4:
                                System.out.println("Inapoi la meniu...");
                                break;
                            default:
                                System.out.println("Optiune invalida. Te rugam sa selectezi una dintre optiunile 1/2/3/4.");
                        }
                    } while (subChoice != 4);
                    break;
                case 4:
                    System.out.println("Conversie Valutara:");
                    SchimbValutar.convertesteRONtoEUR();
                    System.out.println("Suma schimbata: " + schimbValutar.getSumaSchimbata() + " EUR");
                    break;
                case 5:
                    System.out.println("Creare Cont Nou:");
                    System.out.println("Te rugam sa introduci datele personale pentru crearea contului");
                    System.out.print("Nume si prenume: ");
                    scanner.nextLine();  // consume the newline
                    String nume1 = scanner.nextLine();
                    System.out.print("Email: ");
                    String email1 = scanner.nextLine();
                    System.out.print("Numar de telefon: ");
                    String nrtelefon1 = scanner.nextLine();

                    CreareCont newAccount = new CreareCont(nume1, prenume, email1, nrtelefon1);
                    newAccount.displayAccountDetails();
                    break;
                case 6:
                    System.out.println("Sterge Cont:");
                    System.out.println("Introduceti datele contului pentru stergere");
                    scanner.nextLine();  // consume the newline
                    System.out.print("Nume: ");
                    String deleteNume = scanner.nextLine();
                    System.out.print("Prenume: ");
                    String deletePrenume = scanner.nextLine();
                    System.out.print("Email: ");
                    String deleteEmail = scanner.nextLine();
                    System.out.print("Numar de telefon: ");
                    String deleteNrtelefon = scanner.nextLine();

                    StergeCont deleteAccount = new StergeCont(deleteNume, deletePrenume, deleteEmail, deleteNrtelefon);
                    deleteAccount.deleteAccount();
                    break;
                case 7:
                    System.out.println("Vizualizare Rata de Schimb:");
                    CursValutar exchangeRate = new CursValutar("USD", "EUR", 1.20, LocalDateTime.now(), "USD/EUR");
                    System.out.println(exchangeRate.formatExchangeRate());
                    break;
                case 8:
                    System.out.println("Iesire...");
                    break;
                default:
                    System.out.println("Optiune invalida. Te rugam sa selectezi una dintre optiunile 1/2/3/4/5/6/7/8.");
            }
        } while (choice != 8);

        scanner.close();
    }
}