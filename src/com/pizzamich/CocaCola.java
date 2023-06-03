package com.pizzamich;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CocaCola extends Napoj {
    private static final List<String> rodzaje = Arrays.asList("CocaCola Classic", "CocaCola Zero");

    public CocaCola(String nazwa, Cena cena) {
        super(nazwa, cena);
    }

    public static Napoj wybierzCocaCola(Scanner scanner, Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj CocaCola:" + "\u001B[0m");
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
            Cena cena = new Cena(3.0);  // Przykładowa cena
            Napoj cocaCola = new CocaCola(nazwa, cena);
            wybraneNapoje.put(cocaCola, ilosc);
            System.out.println("Wybrano: " + cocaCola.getNazwa() + " " + ilosc + " szt. x cena: " + cena.getWartosc() + " zł");
            return cocaCola;
        } else {
            System.out.println("Nieprawidłowy wybór. Wybierz numer z listy.");
            return wybierzCocaCola(scanner, wybraneNapoje);
        }
    }
}
