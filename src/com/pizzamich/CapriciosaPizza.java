package com.pizzamich;

// Klasa Capriciosa Pizza
public class CapriciosaPizza extends Pizza {
    public CapriciosaPizza() {
        super("Capriciosa");
        dodajSkładniki();
        ustawCeny();
    }

    private void dodajSkładniki() {
        dodajDodatkowySkladnik("szynka");
        dodajDodatkowySkladnik("pieczarki");
        dodajDodatkowySkladnik("cebula");
        dodajDodatkowySkladnik("ser");
    }

    private void ustawCeny() {
        ustawCene("mała", 22.0);
        ustawCene("średnia", 27.0);
        ustawCene("duża", 32.0);
    }

    private void ustawCene(String rozmiar, double cena) {
        // Implementacja metody ustawiającej cenę dla danego rozmiaru pizzy
    }
}
