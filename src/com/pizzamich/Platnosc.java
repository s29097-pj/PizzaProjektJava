package com.pizzamich;

import java.util.Scanner;

// Klasa Platnosc
public abstract class Platnosc {
    private final String nazwa;

    public Platnosc(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public static Platnosc wybierzSposobPlatnosci() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\u001B[4m" + "Wybierz sposób płatności:" + "\u001B[0m");
        System.out.println("1. Kartą płatniczą");
        System.out.println("2. PayU - przelew bankowy");
        System.out.println("3. Blik");
        System.out.println("4. Gotówka");
        System.out.print("Wybierz numer: ");
        int platnoscNr = scanner.nextInt();

        Platnosc platnosc;
        switch (platnoscNr) {
            case 1:
                platnosc = new PlatnoscKarta();
                break;
            case 2:
                platnosc = new PlatnoscPayU();
                break;
            case 3:
                platnosc = new PlatnoscBlik();
                break;
            case 4:
                platnosc = new PlatnoscGotowka();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybrano domyślną metodę płatności Kartą płatniczą.");
                platnosc = new PlatnoscKarta();
        }

        return platnosc;
    }
}
