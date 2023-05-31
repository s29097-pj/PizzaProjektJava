package com.pizzamich;

import java.util.Scanner;

// Klasa Piwo - com.pizzamich.Napoj
public class Piwo extends Napoj {
    public Piwo(String nazwa) {
        super(nazwa);
    }

    // Metoda wyboru Piwa
    public static Napoj wybierzPiwo(Scanner scanner) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj piwa:" + "\u001B[0m");
        System.out.println("1. Lager");
        System.out.println("2. Porter");
        System.out.print("\nWybierz numer: ");
        int rodzajNr = scanner.nextInt();
        scanner.nextLine();

        switch (rodzajNr) {
            case 1:
                return new Piwo("Lager");
            case 2:
                return new Piwo("Porter");
            default:
                System.out.println("\n\u001B[4m" + "Nic nie wybrano z dostępnego piwa: " + "\u001B[0m");
                return new BrakNapoju("Brak napoju");
        }
    }
}
