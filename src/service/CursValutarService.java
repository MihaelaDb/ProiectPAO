package service;

import dao.CursValutarDao;
import model.CursValutar;

import java.util.List;

public class CursValutarService {
    private final CursValutarDao cursValutarDao;

    public CursValutarService(CursValutarDao cursValutarDao) {
        this.cursValutarDao = cursValutarDao;
    }
    public void viewAllExchangeRates() {
        Logger.log("viewAllExchangeRates");
        List<CursValutar> cursValutarList = cursValutarDao.getAll();
        System.out.println("All Exchange Rates:");
        for (CursValutar cursValutar : cursValutarList) {
            System.out.println("Valuta Baza: " + cursValutar.getValutaBaza() +
                    ", Valuta Cotata: " + cursValutar.getValutaCotata() +
                    ", Rata de Schimb: " + cursValutar.getRataSchimb() +
                    ", Data Actualizare: " + cursValutar.getDataActualizare() +
                    ", Cod Valutar: " + cursValutar.getCodValutar());
        }
    }
}
