package com.pizzamich;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class OdbiorOsobisty {
    public static void odbiorOsobisty() {
        Random random = new Random();
        int nrZamowienia = random.nextInt(100000); // Generuje losowy numer zamówienia z zakresu 0-99999

        System.out.println("\n\u001B[4m" + "Podsumowanie odbioru osobistego:" + "\u001B[0m\n");
        System.out.println("Przy odbiorze podaj nr zamówienia: " + nrZamowienia);
        System.out.println("z dnia: " + pobierzAktualnaDate());
        System.out.println("\nAdres lokalu do odbioru zamówienia: ");
        System.out.print("ul. Gdańska 77, 81-129, Gdańsk, ");
        System.out.print("tel. 777-101-900, ");
        System.out.print("Gdańsk - Centrum");
        System.out.print("Odbiór osobisty jest bezpłatny");
        System.out.println();
    }

    private static String pobierzAktualnaDate() {
        Calendar calendar = Calendar.getInstance();
        Date data = calendar.getTime();
        return data.toString();
    }

}
