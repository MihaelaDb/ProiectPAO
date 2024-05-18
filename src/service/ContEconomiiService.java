package service;

import dao.ContEconomiiDao;
import model.Client;

import model.ContEconomii;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class ContEconomiiService {
    private final ContEconomiiDao contEconomiiDao;

    public ContEconomiiService(ContEconomiiDao contEconomiiDao) {
        this.contEconomiiDao = contEconomiiDao;
    }

    public void createContEconomii() {
        Logger.log("createContEconomii");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();


        Client client = fetchClientById(clientId);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        Date dataInceput = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInceput);
        cal.add(Calendar.YEAR, 5);
        Date dataFinalizare = cal.getTime();

        System.out.print("Enter suma initiala: ");
        double suma = scanner.nextDouble();

        double dobanda=0;
        if (suma < 10000) {
            dobanda = 3;
        } else if (suma >= 10000) {
            dobanda = 4;
        }


        ContEconomii contEconomii = new ContEconomii(dataInceput, dataFinalizare, (int) dobanda, suma);
        int idGenerated = contEconomiiDao.create(contEconomii);
        if (idGenerated != -1) {
            System.out.println("Savings account created successfully with ID: " + idGenerated);
        } else {
            System.out.println("Failed to create savings account.");
        }
    }

    public void viewSumaInContEconomii() {
        Logger.log("viewSumaInContEconomii");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the savings account you want to view: ");
        int contId = scanner.nextInt();

        Optional<ContEconomii> contOptional = contEconomiiDao.getById(contId);
        if (contOptional.isPresent()) {
            ContEconomii contEconomii = contOptional.get();
            System.out.println("Savings Account Balance: " + contEconomii.getSuma());
        } else {
            System.out.println("Cont economii with ID " + contId + " not found.");
        }
    }

    public void addSumaInContEconomii() {
        Logger.log("addSumaInContEconomii");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the savings account: ");
        int contId = scanner.nextInt();
        System.out.print("Enter amount to add: ");
        double sumaToAdd = scanner.nextDouble();

        Optional<ContEconomii> contOptional = contEconomiiDao.getById(contId);
        if (contOptional.isPresent()) {
            ContEconomii contEconomii = contOptional.get();
            double newSuma = contEconomii.getSuma() + sumaToAdd;
            contEconomiiDao.updateSuma(contId, newSuma);
            System.out.println("Balance updated successfully. New balance: " + newSuma);
        } else {
            System.out.println("Savings Account with id " + contId + " not found.");
        }
    }

    private Client fetchClientById(int clientId) {
        return new Client(clientId, "Nume", "Prenume");
    }

}
