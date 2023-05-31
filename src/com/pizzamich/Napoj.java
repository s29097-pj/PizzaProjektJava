package com.pizzamich;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Klasa Napoj
public abstract class Napoj {
    private final String nazwa;

    public Napoj(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public static Napoj wybierzNapoj(Scanner scanner) {
        Napoj napoj = null;
        Map<Integer, Napoj> dostepneNapoje = new HashMap<>();
        dostepneNapoje.put(1, new Pepsi("Pepsi"));
        dostepneNapoje.put(2, new CocaCola("CocaCola"));
        dostepneNapoje.put(3, new Sok("Sok"));
        dostepneNapoje.put(4, new Piwo("Piwo"));
        dostepneNapoje.put(5, new Wino("Wino"));

        System.out.println("\n\u001B[4m" + "Wybierz napój:" + "\u001B[0m");
        for (Map.Entry<Integer, Napoj> entry : dostepneNapoje.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getNazwa());
        }
        System.out.println("6. Pomiń wybór napoju");
        System.out.print("\nWybierz numer: ");
        int napojNr = scanner.nextInt();
        scanner.nextLine();

        if (dostepneNapoje.containsKey(napojNr)) {
            napoj = dostepneNapoje.get(napojNr);
        } else if (napojNr == 6) {
            napoj = new BrakNapoju("Pomiń wybór napoju");
        } else {
            System.out.println("Nie wybrano dostępnych napojów: ");
            napoj = new BrakNapoju("Pomiń wybór napoju");
        }

        return napoj;
    }

    public static void wyswietlPodsumowanieNapojow(Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Wybrane napoje to: " + "\u001B[0m");
        if (wybraneNapoje.isEmpty()) {
            System.out.println("Nie wybrano napoju\n");
        } else {
            for (Map.Entry<Napoj, Integer> entry : wybraneNapoje.entrySet()) {
                Napoj wybranyNapoj = entry.getKey();
                int liczbaSztuk = entry.getValue();
                System.out.println("- " + wybranyNapoj.getNazwa() + " (ilość: " + liczbaSztuk + ")");
            }
        }
    }
}
