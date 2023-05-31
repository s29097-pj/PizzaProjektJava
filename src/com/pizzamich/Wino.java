package com.pizzamich;

import java.util.Scanner;

// Klasa Piwo - com.pizzamich.Napoj
public class Wino extends Napoj {
    public Wino(String nazwa) {
        super(nazwa);
    }

    // Metoda wyboru Wina
    public static Napoj wybierzWino(Scanner scanner) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj wina:" + "\u001B[0m");
        System.out.println("1. Wytrawne");
        System.out.println("2. Półwytrawne");
        System.out.println("3. Słodkie");
        System.out.println("4. Półsłodkie");
        System.out.print("\nWybierz numer: ");
        int rodzajNr = scanner.nextInt();
        scanner.nextLine();

        switch (rodzajNr) {
            case 1:
                return new Wino("Wytrawne");
            case 2:
                return new Wino("Półwytrawne");
            case 3:
                return new Wino("Słodkie");
            case 4:
                return new Wino("Półsłodkie");
            default:
                System.out.println("\n\u001B[4m" + "Nic nie wybrano z dostępnego wina: " + "\u001B[0m");
                return new BrakNapoju("Brak napoju");
        }
    }
}
