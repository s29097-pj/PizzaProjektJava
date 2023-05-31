package com.pizzamich;

import java.util.Scanner;

// Klasa CocaCola - com.pizzamich.Napoj
public class CocaCola extends Napoj {
    public CocaCola(String nazwa) {
        super(nazwa);
    }

    // Metoda wyboru rodzaju CocaCola
    public static Napoj wybierzCocaCola(Scanner scanner) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj CocaCola:" + "\u001B[0m");
        System.out.println("1. CocaCola Classic");
        System.out.println("2. CocaCola Zero");
        System.out.print("\nWybierz numer: ");
        int rodzajNr = scanner.nextInt();
        scanner.nextLine();

        switch (rodzajNr) {
            case 1:
                return new CocaCola("CocaCola Classic");
            case 2:
                return new CocaCola("CocaCola Zero");
            default:
                System.out.println("\n\u001B[4m" + "Nic nie wybrano z dostępnej CocaColi: " + "\u001B[0m");
                return new BrakNapoju("Brak napoju");
        }
    }
}
