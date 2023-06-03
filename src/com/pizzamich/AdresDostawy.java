package com.pizzamich;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AdresDostawy {
    public static void adresDostawy() {
    }

    protected double obliczKosztDostawy(String miasto) {
        double kosztDostawy = 0.0;

        // Określ kryteria kosztu dostawy na podstawie miasta
        if (miasto.equalsIgnoreCase("Gdańsk")) {
            kosztDostawy = 10.00; // Przykładowa wartość dla Gdańska
        } else if (miasto.equalsIgnoreCase("Warszawa")) {
            kosztDostawy = 15.40; // Przykładowa wartość dla Warszawy
        } else {
            kosztDostawy = 18.50; // Domyślna wartość dla innych miast
        }

        return kosztDostawy;
    }

    public void wybierzAdresDostawy() {
        Random random = new Random();
        int nrZamowienia = random.nextInt(100000); // Generuje losowy numer zamówienia z zakresu 0-99999

        System.out.println("\n\u001B[4m" + "Podaj dane dostawy:" + "\u001B[0m");
        System.out.print("Podaj ulicę: ");
        String ulica = Pizza.scanner.nextLine();

        System.out.print("Podaj numer domu/mieszkania: ");
        String numerDomu = Pizza.scanner.nextLine();

        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = Pizza.scanner.nextLine();

        System.out.print("Podaj miasto: ");
        String miasto = Pizza.scanner.nextLine();

        System.out.print("Podaj maila: ");
        String mail = Pizza.scanner.nextLine();

        System.out.print("Podaj nr telefonu: ");
        String telefon = Pizza.scanner.nextLine();

        double kosztDostawy = obliczKosztDostawy(miasto);

        // Tworzenie instancji DecimalFotmat z odpowiednim formatem
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        // Formatowanie wartości kosztDostawy z dwoma miejscami po kropce
        //String sformatowanyKosztDostawy = decimalFormat.format(kosztDostawy);

        System.out.println("\n\u001B[4m" + "Podsumowanie danych dostawy:" + "\u001B[0m\n");
        System.out.println("Nr zamówienia: " + nrZamowienia + " z dnia " + pobierzAktualnaDate());
        System.out.println("Data zamówienia: " + pobierzAktualnaDate());
        System.out.println("Koszt dostawy: " + decimalFormat.format(kosztDostawy) + " PLN do miasta/miejscowośći " + miasto);
        System.out.println("\n\u001B[4m" + "Adres dostawy:" + "\u001B[0m\n");
        System.out.println("Ulica: " + ulica);
        System.out.println("Numer domu/mieszkania: " + numerDomu);
        System.out.println("Kod pocztowy: " + kodPocztowy);
        System.out.println("Miasto/miejscowość: " + miasto);
        System.out.println("Email: " + mail);
        System.out.println("Telefon: " + telefon);

    }

    private static String pobierzAktualnaDate() {
        Calendar calendar = Calendar.getInstance();
        Date data = calendar.getTime();
        return data.toString();
    }
}

