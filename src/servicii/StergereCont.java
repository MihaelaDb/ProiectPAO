package servicii;

import java.util.Scanner;

public class StergereCont {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("Doresti sa iti stergi contul bancar? (da/nu)");
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "da":
                    stergeContul();
                    return;
                case "nu":
                    System.out.println("Contul tau nu va fi sters.Va multumim pentru utilizare.O zi buna!");
                    return;
                default:
                    System.out.println("Va rugam introduceti o optiune valida:");
                    break;
            }
        }
    }

    private static void stergeContul() {
        System.out.println("Contul tau a fost sters cu succes.Va multumim pentru utilizare.O zi buna!");
    }
}
