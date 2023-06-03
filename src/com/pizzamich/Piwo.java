package com.pizzamich;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Piwo extends Napoj {
    private static final List<String> rodzaje = Arrays.asList("Piwo Lager", "Piwo Porter", "Piwo bezalkoholowe", "Pszeniczne");

    public Piwo(String nazwa, Cena cena) {
        super(nazwa, cena);
    }

    public static Napoj wybierzPiwo(Scanner scanner, Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Wybierz rodzaj piwa:" + "\u001B[0m");
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
            Cena cena = new Cena(4.0);  // Przykładowa cena
            Napoj piwo = new Piwo(nazwa, cena);
            wybraneNapoje.put(piwo, ilosc);
            System.out.println("Wybrano: " + piwo.getNazwa() + " " + ilosc + " szt. x cena: " + cena.getWartosc() + " zł");
            return piwo;
        } else {
            System.out.println("Nieprawidłowy wybór. Wybierz numer z listy.");
            return wybierzPiwo(scanner, wybraneNapoje);
        }
    }
}
