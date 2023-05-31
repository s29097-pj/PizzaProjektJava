package com.pizzamich;

// Klasa Wegetariańska com.pizzamich.Pizza
public class WegetarianskaPizza extends Pizza {
    public WegetarianskaPizza() {
        super("Wegetariańska");
        dodajSkładniki();
        ustawCeny();
    }

    private void dodajSkładniki() {
        dodajDodatkowySkladnik("papryka");
        dodajDodatkowySkladnik("pieczarki");
        dodajDodatkowySkladnik("cebula");
        dodajDodatkowySkladnik("oliwki");
    }

    private void ustawCeny() {
        ustawCene("mała", 20.0);
        ustawCene("średnia", 25.0);
        ustawCene("duża", 30.0);
    }

    private void ustawCene(String rozmiar, double cena) {
        // Implementacja metody ustawiającej cenę dla danego rozmiaru pizzy
    }
}
