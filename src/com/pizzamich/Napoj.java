package com.pizzamich;

import java.util.Map;
import java.util.Scanner;

public abstract class Napoj {
    private String nazwa;
    private Cena cena;

    public Napoj(String nazwa, Cena cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Cena getCena() {
        return cena;
    }

    public static Napoj wybierzNapoj(Scanner scanner, Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Czy chcesz dodać napój do zamówienia?" + "\u001B[0m");
        System.out.println("1. Tak - wyświetl listę napojów");
        System.out.println("2. Nie - wyświetl podsumowanie");
        System.out.print("Wybierz numer: ");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        if (wybor == 1) {
            return wyswietlListeNapojow(scanner, wybraneNapoje);
        } else {
            return new BrakNapoju("Brak napoju", new Cena(0.0));
        }
    }

    private static Napoj wyswietlListeNapojow(Scanner scanner, Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Lista napojów:" + "\u001B[0m");
        System.out.println("1. Pepsi");
        System.out.println("2. CocaCola");
        System.out.println("3. Sok");
        System.out.println("4. Piwo");
        System.out.println("5. Wino");
        System.out.print("Wybierz numer: ");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        switch (wybor) {
            case 1:
                return Pepsi.wybierzPepsi(scanner, wybraneNapoje);
            case 2:
                return CocaCola.wybierzCocaCola(scanner, wybraneNapoje);
            case 3:
                return Sok.wybierzSok(scanner, wybraneNapoje);
            case 4:
                return Piwo.wybierzPiwo(scanner, wybraneNapoje);
            case 5:
                return Wino.wybierzWino(scanner, wybraneNapoje);
            default:
                System.out.println("Nieprawidłowy wybór. Wybierz numer z listy.");
                return wyswietlListeNapojow(scanner, wybraneNapoje);
        }
    }

    public static void wyswietlPodsumowanieNapojow(Map<Napoj, Integer> wybraneNapoje) {
        System.out.println("\n\u001B[4m" + "Wybrane napoje to:" + "\u001B[0m");
        for (Map.Entry<Napoj, Integer> entry : wybraneNapoje.entrySet()) {
            Napoj napoj = entry.getKey();
            int ilosc = entry.getValue();
            System.out.println(ilosc + " szt. x " + napoj.getNazwa() + " = " + napoj.getCena().getWartosc() + " zł");
        }
        double suma = wybraneNapoje.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getCena().getWartosc() * entry.getValue())
                .sum();
        System.out.println("com.pizzamich.Cena za wszystkie napoje wynosi: " + suma + " zł");
    }
}
