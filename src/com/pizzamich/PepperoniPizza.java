package com.pizzamich;

// Klasa Peperoni Pizza
public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        super("Pepperoni");
        dodajSkładniki();
        ustawCeny();
    }

    private void dodajSkładniki() {
        dodajDodatkowySkladnik("pepperoni");
        dodajDodatkowySkladnik("papryczki chili");
        dodajDodatkowySkladnik("cebula");
        dodajDodatkowySkladnik("ser");
    }

    private void ustawCeny() {
        ustawCene("mała", 24.0);
        ustawCene("średnia", 29.0);
        ustawCene("duża", 34.0);
    }

    private void ustawCene(String rozmiar, double cena) {
        // Implementacja metody ustawiającej cenę dla danego rozmiaru pizzy
    }
}
