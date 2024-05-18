package service;

import dao.CardDao;
import dao.ClientDao;
import model.Card;
import model.Client;

import java.util.Optional;
import java.util.Scanner;

public class CardService {
    private final CardDao cardDao;
    private final ClientDao clientDao;

    public CardService(CardDao cardDao, ClientDao clientDao) {
        this.cardDao = cardDao;
        this.clientDao = clientDao;
    }

    public void createCard() {
        Logger.log("createCard");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        Optional<Client> clientOptional = clientDao.getClientById(clientId);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            String nume = client.getNume();
            String prenume = client.getPrenume();

            Card card = new Card(0, null, null, null);
            card.generateNumarCard();
            card.generateCVV();
            card.generateDataExpirarii();

            int idGenerated = cardDao.create(card);
            if (idGenerated != -1) {
                card.setId(idGenerated);
                System.out.println("Card created successfully with ID: " + idGenerated);
            } else {
                System.out.println("Failed to create card.");
            }
        } else {
            System.out.println("Client with ID " + clientId + " not found.");
        }
    }

    public void readClientById() {
        Logger.log("readClientById");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the client you want to read: ");
        int idcard = scanner.nextInt();
        scanner.nextLine();

        Optional<Card> cardOptional = cardDao.get(idcard);
        Optional<Client> clientOptional = clientDao.get(idcard);

        if (cardOptional.isPresent()) {
            Client client = clientOptional.get();
            Card card = cardOptional.get();
            System.out.println("Client found:");
            System.out.println("ID: " + client.getId());
            System.out.println("Nume: " + client.getNume());
            System.out.println("Prenume: " + client.getPrenume());
            System.out.println("Numar Card: " + card.getNumarCard());
            System.out.println("CVV: " + card.getCVV());
            System.out.println("Data de Expirare: " + card.getDataExpirarii());
        } else {
            System.out.println("Client with ID " + idcard + " not found.");
        }
    }

    public void deleteCardById() {
        Logger.log("deleteCardById");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu ID-ul asociat cardului pentru a inchide contul: ");
        int cardId = scanner.nextInt();
        scanner.nextLine();

        Optional<Card> cardOptional = cardDao.get(cardId);

        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            cardDao.delete(card);
            System.out.println("Cardul cu ID-ul: " + cardId + " a fost închis.");
        } else {
            System.out.println("Cardul cu ID-ul " + cardId + " nu a fost găsit.");
        }
    }
}
