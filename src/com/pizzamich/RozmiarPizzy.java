package com.pizzamich;
import java.util.Scanner;

public class RozmiarPizzy {
    public static final String MALA_PIZZA = "Mała";
    public static final String SREDNIA_PIZZA = "Średnia";
    public static final String DUZA_PIZZA = "Duża";

    public static String wybierzRozmiarPizzy(Scanner scanner) {
        System.out.println("\n\u001B[4m" + "Wybierz rozmiar pizzy:" + "\u001B[0m");
        System.out.println("1. " + MALA_PIZZA);
        System.out.println("2. " + SREDNIA_PIZZA);
        System.out.println("3. " + DUZA_PIZZA);
        System.out.print("\nWybierz numer: ");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        switch (wybor) {
            case 1:
                return MALA_PIZZA;
            case 2:
                return SREDNIA_PIZZA;
            case 3:
                return DUZA_PIZZA;
            default:
                System.out.println("Nieprawidłowy wybór. Wybrano domyślny rozmiar: " + MALA_PIZZA);
                return MALA_PIZZA;
        }
    }
}
