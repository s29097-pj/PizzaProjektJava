package com.pizzamich;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Platnosc {
    private String metoda;

    public Platnosc(String metoda) {
        this.metoda = metoda;
    }

    public String getMetoda() {
        return metoda;
    }

    public static class PlatnoscBankowa extends Platnosc {
        public PlatnoscBankowa() {
            super("Bank");

            Random random = new Random();
            int nrBankowy = random.nextInt(100000); // Generuje losowy numer zamówienia z zakresu 0-99999
            int nrZamowienia2 = random.nextInt(1000); // Generuje losowy numer zamówienia z zakresu 0-999

            System.out.println("\n\u001B[4m" + "Dane do przelewu bankowego:" + "\u001B[0m");
            System.out.println("Przy odbiorze podaj nr zamówienia: " + nrBankowy);
            System.out.println("\n\u001B[4m" + "Prześlij pieniądze na konto: " + "\u001B[0m");

            // Generowanie numeru konta bankowego
            String numerKonta = generujNumerKontaBankowego();
            System.out.println("Numer konta bankowego: " + numerKonta);

            System.out.println("Proszę wpisz numer zamówienia: " + nrZamowienia2);
            System.out.println("Wygenerowano dnia: " + pobierzAktualnaDate());
        }

        private static String generujNumerKontaBankowego() {
            Random random = new Random();
            StringBuilder numerKonta = new StringBuilder();

            // Generowanie dwóch liter kodu kraju (PL)
            numerKonta.append("PL");

            // Generowanie 24 cyfr numeru konta
            for (int i = 0; i < 24; i++) {
                numerKonta.append(random.nextInt(10));
            }

            return numerKonta.toString();
        }
    }

    public static class PlatnoscBlik extends Platnosc {
        public PlatnoscBlik() {
            super("Blik");

            Random random = new Random();
            int platnoscBlik = random.nextInt(1000); // Generuje losowy numer zamówienia z zakresu 0-999

            System.out.println("\n\u001B[4m" + "Potwierdź w aplikacji bankowej: " + "\u001B[0m");
            System.out.println("Nr Blik: " + platnoscBlik);
            System.out.println("Wygenerowano dnia: " + pobierzAktualnaDate());
        }
    }

    public static class PlatnoscGotowka extends Platnosc {
        public PlatnoscGotowka() {
            super("Gotówka");

            System.out.println("\n\u001B[4m" + "Płatność gotówką:" + "\u001B[0m");
            System.out.println("Przygotuj odliczoną sumę pieniędzy dla dostawcy");
        }
    }

    private static String pobierzAktualnaDate() {
        Calendar calendar = Calendar.getInstance();
        Date data = calendar.getTime();
        return data.toString();
    }
}
