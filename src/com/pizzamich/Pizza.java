package com.pizzamich;

import java.util.ArrayList;
import java.util.List;

// Klasa Pizza
public class Pizza {
    private final String nazwa;
    private final List<String> dodatkoweSkladniki;

    public Pizza(String nazwa) {
        this.nazwa = nazwa;
        this.dodatkoweSkladniki = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<String> getDodatkoweSkladniki() {
        return dodatkoweSkladniki;
    }

    public void dodajDodatkowySkladnik(String skladnik) {
        dodatkoweSkladniki.add(skladnik);
    }
}
