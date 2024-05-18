package service;

import dao.ClientDao;
import model.Client;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

public class ClientService {
    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void creeazaClientNou() {
        Logger.log("creeazaClientNou");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți numele: ");
        String nume = scanner.nextLine();

        System.out.print("Introduceți prenumele: ");
        String prenume = scanner.nextLine();

        System.out.print("Introduceți adresa de email: ");
        String email = scanner.nextLine();

        System.out.print("Introduceți numărul de telefon: ");
        String telefon = scanner.nextLine();

        System.out.print("Introduceți data nașterii (AAAA-LL-ZZ): ");
        String dataNasteriiStr = scanner.nextLine();
        Date data_nasterii = Date.valueOf(dataNasteriiStr);

        System.out.print("Introduceți adresa: ");
        String adresa = scanner.nextLine();

        Client clientNou = new Client(1, nume, prenume, email, telefon, data_nasterii, adresa);

        int idGenerat = clientDao.create(clientNou);
        if (idGenerat != -1) {
            System.out.println("Cont creat cu succes cu ID-ul: " + idGenerat);
        } else {
            System.out.println("Crearea contului a eșuat.");
        }
    }

    public void readClientById() {
        Logger.log("readClientById");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the client you want to read: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        Optional<Client> clientOptional = clientDao.get(clientId);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            System.out.println("Client found:");
            System.out.println("ID: " + client.getId());
            System.out.println("Name: " + client.getNume());
            System.out.println("Surname: " + client.getPrenume());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Phone: " + client.getTelefon());
            System.out.println("Date of Birth: " + client.getDataNasterii());
            System.out.println("Address: " + client.getAdresa());
        } else {
            System.out.println("Client with ID " + clientId + " not found.");
        }
    }
    public void deleteClientById() {
        Logger.log("deleteClientById");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID to delete your account: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        Optional<Client> clientOptional = clientDao.get(clientId);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            clientDao.delete(client);
            System.out.println("Client with ID " + clientId + " deleted successfully.");
        } else {
            System.out.println("Client with ID " + clientId + " not found.");
        }
    }


    }

