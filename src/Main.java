import dao.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientDao clientDao = new ClientDao();
        ClientService clientService = new ClientService(clientDao);
        CardService cardService = new CardService(new CardDao(), clientDao);
        ContEconomiiDao contEconomiiDao = new ContEconomiiDao();
        ContEconomiiService contEconomiiService = new ContEconomiiService(contEconomiiDao);
        ContBancarDao contBancarDao = new ContBancarDao();
        ContBancarService contBancarService = new ContBancarService(contBancarDao);
        CursValutarService cursValutarService = new CursValutarService(new CursValutarDao());
        SchimbValutarDao schimbValutarDao = new SchimbValutarDao();
        CursValutarDao cursValutarDao = new CursValutarDao();
        SchimbValutarService schimbValutarService = new SchimbValutarService(schimbValutarDao, cursValutarDao);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Client Operations");
            System.out.println("2. Card Operations");
            System.out.println("3. Savings Account Operations");
            System.out.println("4. Bank Account Operations");
            System.out.println("5. Other Operations");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");


            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clientOperations(clientService, scanner);
                    break;
                case 2:
                    cardOperations(cardService, scanner);
                    break;
                case 3:
                    savingsAccountOperations(contEconomiiService, scanner);
                    break;
                case 4:
                    bankAccountOperations(contBancarService, scanner);
                    break;
                case 5:
                    otherOperations(cursValutarService, schimbValutarService, scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void clientOperations(ClientService clientService, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Client Operations:");
            System.out.println("1. Create New Client");
            System.out.println("2. View Account Info");
            System.out.println("3. Delete Account");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clientService.creeazaClientNou();
                    break;
                case 2:
                    clientService.readClientById();
                    break;
                case 3:
                    clientService.deleteClientById();
                    break;


                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void cardOperations(CardService cardService, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Card Operations:");
            System.out.println("1. Create Card");
            System.out.println("2. Display Card Info");
            System.out.println("3. Delete your card:");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cardService.createCard();
                    break;
                case 2:
                    cardService.readClientById();
                    break;

                case 3:
                    cardService.deleteCardById();
                    break;

                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void savingsAccountOperations(ContEconomiiService contEconomiiService, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Savings Account Operations:");
            System.out.println("1. Create Savings Account");
            System.out.println("2. View Savings Account Balance");
            System.out.println("3. Add Money to Savings Account");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    contEconomiiService.createContEconomii();
                    break;
                case 2:
                    contEconomiiService.viewSumaInContEconomii();
                    break;
                case 3:
                    contEconomiiService.addSumaInContEconomii();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bankAccountOperations(ContBancarService contBancarService, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Bank Account Operations:");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Delete Bank Account:");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter client ID: ");
                    int clientId = scanner.nextInt();
                    contBancarService.createContBancar(clientId);
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    int accountId = scanner.nextInt();
                    contBancarService.retragere(accountId);
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int accountIdDeposit = scanner.nextInt();
                    contBancarService.depunere(accountIdDeposit);
                    break;
                case 4:
                    contBancarService.deleteContBancarById();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void otherOperations(CursValutarService cursValutarService, SchimbValutarService schimbValutarService, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Other Operations:");
            System.out.println("1. View All Exchange Rates");
            System.out.println("2. Change Money");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cursValutarService.viewAllExchangeRates();
                    break;
                case 2:
                    schimbValutarService.performSchimbValutar();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
