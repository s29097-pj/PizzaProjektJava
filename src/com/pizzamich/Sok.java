package com.pizzamich;

import java.util.Scanner;

// Klasa Sok - com.pizzamich.Napoj
public class Sok extends Napoj {
    public Sok(String nazwa) {
        super(nazwa);
    }

    // Metoda wyboru Soku
    public static Napoj wybierzSok(Scanner scanner) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj soku:" + "\u001B[0m");
        System.out.println("1. Pomarańczowy");
        System.out.println("2. Jabłkowy");
        System.out.print("\nWybierz numer: ");
        int rodzajNr = scanner.nextInt();
        scanner.nextLine();

        switch (rodzajNr) {
            case 1:
                return new Sok("Pomarańczowy");
            case 2:
                return new Sok("Jabłkowy");
            default:
                System.out.println("\n\u001B[4m" + "Nic nie wybrano z dostępnego soku: " + "\u001B[0m");
                return new BrakNapoju("Brak napoju");
        }
    }
}
