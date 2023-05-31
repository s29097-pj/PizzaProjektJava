package com.pizzamich;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Adres {
    private String imieNazwisko;
    private String ulica;
    private String numerDomu;
    private String kodPocztowy;
    private String miasto;
    private String email;
    private String nrTelefonu;

    public Adres(String imieNazwisko, String ulica, String numerDomu, String kodPocztowy, String email, String miasto, String nrTelefonu) {
        this.imieNazwisko = imieNazwisko;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.email = email;
        this.nrTelefonu = nrTelefonu;
    }

    public static Adres pobierzDaneAdresowe() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imię i nazwisko: ");
        String imieNazwisko = scanner.nextLine();

        System.out.print("Podaj ulicę: ");
        String ulica = scanner.nextLine();

        System.out.print("Podaj numer domu: ");
        String numerDomu = scanner.nextLine();

        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.nextLine();

        System.out.print("Podaj miasto: ");
        String miasto = scanner.nextLine();

        System.out.print("Podaj adres email: ");
        String email = scanner.nextLine();

        System.out.print("Podaj numer telefonu: ");
        String nrTelefonu = scanner.nextLine();

        return new Adres(imieNazwisko, ulica, numerDomu, kodPocztowy, email, miasto, nrTelefonu);
    }

    public void wyswietlAdres() {
        System.out.println("\nWyświetlony adres dostawy:");
        System.out.println(getPelnyAdres());
    }

    public boolean potwierdzAdres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCzy adres dostawy jest poprawny?");
        System.out.println("1. Tak - poprawny.");
        System.out.println("2. Nie - zmień adres dostawy.");
        System.out.print("Wybierz numer: ");
        int wybor = scanner.nextInt();
        scanner.nextLine(); // Pobieranie znaku nowej linii po wczytaniu liczby

        return wybor == 1;
    }

    public String getPelnyAdres() {
        return imieNazwisko + " " + ulica + " " + numerDomu + ", " + kodPocztowy + " " + miasto + " " + email;
    }

    public boolean czyPoprawnyAdres() {
        boolean poprawneDane = false;

        do {
            if (!poprawneDane) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Podaj imię i nazwisko: ");
                imieNazwisko = scanner.nextLine();
                System.out.print("Podaj ulicę: ");
                ulica = scanner.nextLine();
                System.out.print("Podaj numer domu: ");
                numerDomu = scanner.nextLine();
                System.out.print("Podaj kod pocztowy: ");
                kodPocztowy = scanner.nextLine();
                System.out.print("Podaj miasto: ");
                miasto = scanner.nextLine();
                System.out.print("Podaj adres email: ");
                email = scanner.nextLine();
                System.out.print("Podaj numer telefonu: ");
                nrTelefonu = scanner.nextLine();
            }

            if (imieNazwisko.isEmpty()) {
                System.out.println("Nie wprowadzono imienia i nazwiska.");
            } else if (ulica.isEmpty()) {
                System.out.println("Nie wprowadzono nazwy ulicy.");
            } else if (numerDomu.isEmpty()) {
                System.out.println("Nie wprowadzono numeru domu.");
            } else if (!Pattern.matches("\\d{2}-\\d{3}", kodPocztowy)) {
                System.out.println("Niepoprawny kod pocztowy. Wprowadź kod pocztowy w formacie XX-XXX.");
            } else if (miasto.isEmpty()) {
                System.out.println("Nie wprowadzono nazwy miasta.");
            } else if (email.isEmpty()) {
                System.out.println("Nie wprowadzono adresu email.");
            } else if (!Pattern.matches("(\\d{3} \\d{3} \\d{3})|(\\(\\w+\\) \\d{2} \\d{3} \\d{2} \\d{2})", nrTelefonu)) {
                System.out.println("Niepoprawny numer telefonu. Wprowadź numer telefonu w odpowiednim formacie.");
            } else {
                poprawneDane = true;
            }
        } while (!poprawneDane);

        wyswietlAdres();

        if (!potwierdzAdres()) {
            return false;
        }

        return true;
    }
}
