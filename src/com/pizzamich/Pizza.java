package com.pizzamich;

import java.util.List;
import java.util.Scanner;

public class Pizza {
    private final String nazwa;
    private final List<String> skladniki;

    public Pizza(String nazwa, List<String> skladniki) {
        this.nazwa = nazwa;
        this.skladniki = skladniki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<String> getSkladniki() {
        return skladniki;
    }

    static Scanner scanner = new Scanner(System.in);
}
