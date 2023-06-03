package com.pizzamich;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Pepsi extends Napoj {
    private static final List<String> rodzaje = Arrays.asList("Pepsi Classic", "Pepsi Zero", "Pepsi Lemon");

    public Pepsi(String nazwa, Cena cena) {
        super(nazwa, cena);
    }

    public static Napoj wybierzPepsi(Scanner scanner, Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj Pepsi:" + "\u001B[0m");
        for (int i = 0; i < rodzaje.size(); i++) {
            System.out.println((i + 1) + ". " + rodzaje.get(i));
        }
        System.out.print("Wybierz numer: ");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        if (wybor >= 1 && wybor <= rodzaje.size()) {
            String nazwa = rodzaje.get(wybor - 1);
            System.out.print("Podaj ilość szt.: ");
            int ilosc = scanner.nextInt();
            scanner.nextLine();
            Cena cena = new Cena(2.5);  // Przykładowa cena
            Napoj pepsi = new Pepsi(nazwa, cena);
            wybraneNapoje.put(pepsi, ilosc);
            System.out.println("Wybrano: " + pepsi.getNazwa() + " " + ilosc + " szt. x cena: " + cena.getWartosc() + " zł");
            return pepsi;
        } else {
            System.out.println("Nieprawidłowy wybór. Wybierz numer z listy.");
            return wybierzPepsi(scanner, wybraneNapoje);
        }
    }
}
