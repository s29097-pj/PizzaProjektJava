package com.pizzamich;

import java.util.Scanner;

// Klasa Pepsi - com.pizzamich.Napoj
public class Pepsi extends Napoj {
    public Pepsi(String nazwa) {
        super(nazwa);
    }

    // Metoda wyboru rodzaju Pepsi
    public static Napoj wybierzPepsi(Scanner scanner) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj Pepsi:" + "\u001B[0m");
        System.out.println("1. Pepsi Classic");
        System.out.println("2. Pepsi Zero");
        System.out.println("3. Pepsi Lemon");
        System.out.print("\nWybierz numer: ");
        int rodzajNr = scanner.nextInt();
        scanner.nextLine();

        switch (rodzajNr) {
            case 1:
                return new Pepsi("Pepsi Classic");
            case 2:
                return new Pepsi("Pepsi Zero");
            case 3:
                return new Pepsi("Pepsi Lemon");
            default:
                System.out.println("\n\u001B[4m" + "Nic nie wybrano z dostępnego Pepsi: " + "\u001B[0m");
                return new BrakNapoju("Brak napoju");
        }
    }
}
