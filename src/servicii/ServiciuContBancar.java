
package servicii;

import cont.ContBancar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CreareCont {
    private final List<ContBancar> conturi = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);


    public void creareContBancar() {
        System.out.print("Introduceți numele: ");
        String nume = scanner.nextLine();

        System.out.print("Introduceți prenumele: ");
        String prenume = scanner.nextLine();

        System.out.print("Introduceți ID-ul clientului: ");
        int clientID = scanner.nextInt();

        System.out.print("Introduceți ID-ul unic pentru cont: ");
        int idUnic = scanner.nextInt();

        ContBancar cont = new ContBancar(nume, clientID, idUnic);
        conturi.add(cont);
        System.out.println("Cont bancar creat cu succes pentru " + nume + " " + prenume);
    }


    public void afisareConturi() {
        for (ContBancar cont : conturi) {
            System.out.println("IBAN: " + cont.getIBAN());
            System.out.println("SWIFT: " + cont.getSwift());
            System.out.println("Nume: " + cont.getNume() + " " + cont.getPrenume());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        CreareCont gestiuneConturi = new CreareCont();

        gestiuneConturi.creareContBancar();

        gestiuneConturi.afisareConturi();
    }
}
