package com.pizzamich;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// Klasa Własna Pizza
public class WlasnaPizza extends Pizza {
    public WlasnaPizza(List<String> dodatkoweSkladniki) {
        super("Własna Pizza");
        this.getDodatkoweSkladniki().addAll(dodatkoweSkladniki);
    }

    public static Pizza stworzWlasnaPizza(Scanner scanner) {
        List<String> dostepneSkladniki = Arrays.asList(
                "ser", "szynka", "krewetki", "pieczarki", "cebula", "brokuły", "czosnek", "szpinak",
                "papryka", "kukurydza", "oliwki", "salami", "jalapeno", "fasola", "żurawina", "jajko",
                "szczypiorek"
        );

        System.out.println("\nDostępne składniki:");
        for (int i = 0; i < dostepneSkladniki.size(); i++) {
            System.out.println((i + 1) + ". " + dostepneSkladniki.get(i));
        }

        System.out.println("\n\u001B[4m" + "Wybierz własne składniki:" + "\u001B[0m");

        List<String> wybraneSkladniki = new ArrayList<>();

        while (true) {
            System.out.print("\nWybierz numer składnika (lub wpisz 'gotowe' aby zakończyć): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("gotowe")) {
                break;
            }

            try {
                int numer = Integer.parseInt(input);
                if (numer >= 1 && numer <= dostepneSkladniki.size()) {
                    String skladnik = dostepneSkladniki.get(numer - 1);
                    if (wybraneSkladniki.contains(skladnik)) {
                        System.out.println("Wybrałeś już ten składnik.");
                    } else {
                        wybraneSkladniki.add(skladnik);
                        System.out.println("Wybrałeś składnik nr " + numer + ": " + skladnik);
                    }
                } else {
                    System.out.println("Nieprawidłowy numer składnika. Spróbuj ponownie.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format. Spróbuj ponownie.");
            }
        }

        System.out.println("\nTwoje składniki to: " + String.join(", ", wybraneSkladniki));

        return new WlasnaPizza(wybraneSkladniki);
    }
}
