package service;

import dao.ContBancarDao;

import model.ContBancar;

import java.util.Optional;
import java.util.Scanner;

public class ContBancarService {
    private final ContBancarDao contBancarDao;

    public ContBancarService(ContBancarDao contBancarDao) {
        this.contBancarDao = contBancarDao;
    }

    public void createContBancar(int clientId) {
        Logger.log("createContBancar");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial amount (sold): ");
        double sold = scanner.nextDouble();
        scanner.nextLine();

        ContBancar contBancar = new ContBancar(0, "", "", sold);
        int id = contBancarDao.create(contBancar);
        if (id != -1) {
            contBancar.setId(id);
            contBancar.setIban(contBancar.generateIBAN());
            contBancar.setSwift(contBancar.generateSwift());
            contBancarDao.update(id, contBancar);
            System.out.println("Bank account created successfully with ID: " + id);
        } else {

            System.out.println("Failed to create bank account.");
        }
    }

    public void retragere(int id) {
        Logger.log("retrage");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Optional<ContBancar> contBancarOptional = contBancarDao.getById(id);
        if (contBancarOptional.isPresent()) {
            ContBancar contBancar = contBancarOptional.get();
            if (contBancar.getSold() >= amount) {
                double newAmount = contBancar.getSold() - amount;
                contBancarDao.updateAmount(id, newAmount);
                System.out.println("Withdrawal successful. New balance: " + newAmount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void depunere(int id) {
        Logger.log("depunere");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Optional<ContBancar> contBancarOptional = contBancarDao.getById(id);
        if (contBancarOptional.isPresent()) {
            ContBancar contBancar = contBancarOptional.get();
            double newAmount = contBancar.getSold() + amount;
            contBancarDao.updateAmount(id, newAmount);
            System.out.println("Deposit successful. New balance: " + newAmount);
        } else {
            System.out.println("Account not found.");
        }
    }
    public void deleteContBancarById() {
        Logger.log("deleteContBancarById");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID to delete your account: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        Optional<ContBancar> contBancarOptional = contBancarDao.getById(clientId);

        if (contBancarOptional.isPresent()) {
            ContBancar contBancar = contBancarOptional.get();
            contBancarDao.delete(contBancar);
            System.out.println("Cont Bancar with ID " + clientId + " deleted successfully.");
        } else {
            System.out.println("Cont Bancar with ID " + clientId + " not found.");
        }
    }


}
