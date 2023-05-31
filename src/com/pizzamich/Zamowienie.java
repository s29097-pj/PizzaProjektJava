package com.pizzamich;

import java.util.List;

public class Zamowienie {
    private final Pizza pizza;
    private final String wielkosc;
    private final List<String> sosy;
    private final Napoj napoj;
    private final Adres adres;
    private Platnosc platnosc;

    public Zamowienie(Pizza pizza, String wielkosc, List<String> sosy, Napoj napoj, Adres adres) {
        this.pizza = pizza;
        this.wielkosc = wielkosc;
        this.sosy = sosy;
        this.napoj = napoj;
        this.adres = adres;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getWielkosc() {
        return wielkosc;
    }

    public List<String> getSosy() {
        return sosy;
    }

    public Napoj getNapoj() {
        return napoj;
    }

    public Adres getAdres() {
        return adres;
    }

    public Platnosc getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(Platnosc platnosc) {
        this.platnosc = platnosc;
    }

    public double obliczKoszt() {
        double koszt = 0;

        switch (wielkosc) {
            case "mała":
                koszt += 20.0;
                break;
            case "średnia":
                koszt += 25.0;
                break;
            case "duża":
                koszt += 30.0;
                break;
            default:
                koszt += 25.0;
        }

        if (!pizza.getNazwa().equals("Własna Pizza")) {
            koszt += 5.0; // Dodatkowa opłata za wybór gotowej pizzy
        }

        if (napoj != null) {
            koszt += 7.0; // Cena napoju
        }

        return koszt;
    }

    public void podsumowanieZamowienia() {
        System.out.println("\n\u001B[4m" + "Podsumowanie zamówienia:" + "\u001B[0m");
        System.out.println("Nazwa pizzy: " + pizza.getNazwa());
        System.out.println("Wielkość pizzy: " + wielkosc);
        System.out.println("Dodatkowe składniki: " + pizza.getDodatkoweSkladniki());
        System.out.println("Adres dostawy: " + adres.getPelnyAdres());
        System.out.println("Metoda płatności: " + platnosc.getNazwa());
        System.out.println("Koszt zamówienia: " + obliczKoszt());
    }
}
