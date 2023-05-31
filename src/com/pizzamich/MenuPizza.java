package com.pizzamich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Klasa Menu Pizza
public class MenuPizza {
    private Scanner scanner;

    public MenuPizza() {
        this.scanner = new Scanner(System.in);
    }

    public void wyswietlMenu() {
        System.out.println("\n\u001B[4m" + "Wybierz swoją pizzę z menu wyboru:" + "\u001B[0m");
        System.out.println("1. Wegetariańska");
        System.out.println("2. Capriciosa");
        System.out.println("3. Pepperoni");
        System.out.println("4. Stwórz własną pizzę");
        System.out.print("\nWybierz numer: ");
    }

    public Pizza wybierzPizze() {
        wyswietlMenu();
        int pizzaNr = scanner.nextInt();
        scanner.nextLine();

        Pizza pizza;
        String pizzaInfo;

        switch (pizzaNr) {
            case 1:
                pizza = new WegetarianskaPizza();
                pizzaInfo = "Wegetariańska:\n- Składniki: " + pizza.getDodatkoweSkladniki();
                break;
            case 2:
                pizza = new CapriciosaPizza();
                pizzaInfo = "Capriciosa:\n- Składniki: " + pizza.getDodatkoweSkladniki();
                break;
            case 3:
                pizza = new PepperoniPizza();
                pizzaInfo = "Pepperoni:\n- Składniki: " + pizza.getDodatkoweSkladniki();
                break;
            case 4:
                pizza = stworzWlasnaPizza();
                pizzaInfo = "Własna pizza:\n- Składniki: " + pizza.getDodatkoweSkladniki();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybierz numer pizzy z menu.");
                return null;
        }

        System.out.println("\n\u001B[4m" + "\nWybrana pizza to:" + "\u001B[0m");
        System.out.println(pizzaInfo);

        return pizza;
    }

    private Pizza stworzWlasnaPizza() {
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
