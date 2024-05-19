package service;

import dao.CursValutarDao;
import dao.SchimbValutarDao;
import model.CursValutar;
import model.SchimbValutar;

import java.util.Optional;
import java.util.Scanner;

public class SchimbValutarService {
    private final SchimbValutarDao schimbValutarDao;
    private final CursValutarDao cursValutarDao;

    public SchimbValutarService(SchimbValutarDao schimbValutarDao, CursValutarDao cursValutarDao) {
        this.schimbValutarDao = schimbValutarDao;
        this.cursValutarDao = cursValutarDao;
    }

    public void performSchimbValutar() {
        Logger.log("performSchimbValutar");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to exchange (suma): ");
        double suma = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the exchange rate ID: ");
        int cursValutarId = scanner.nextInt();
        scanner.nextLine();


        Optional<CursValutar> cursValutarOptional = cursValutarDao.getById(cursValutarId);
        if (cursValutarOptional.isPresent()) {
            CursValutar cursValutar = cursValutarOptional.get();
            double exchangeRate = cursValutar.getRataSchimb();


            double sumaSchimbata = suma / exchangeRate;

            SchimbValutar schimbValutar = new SchimbValutar(0, suma, cursValutar.getValutaCotata());
            int id = schimbValutarDao.create(schimbValutar);
            schimbValutarDao.updateSumaSchimbata(id, sumaSchimbata);

            System.out.println("Exchange performed successfully. ID: " + id);
            System.out.println("Exchanged amount: " + sumaSchimbata + " " + cursValutar.getValutaCotata());
        } else {
            System.out.println("Exchange rate not found for the given ID.");
        }
    }
}
