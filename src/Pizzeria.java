import com.pizzamich.*;

import java.util.*;
import java.util.Scanner;

public class Pizzeria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Witaj
        System.out.println("\nWitaj w pizzamich.com - Twoja pizza na 5+");
        System.out.println("Zapraszamy PN-ND 11:00 - 23:00");
        System.out.println("\nSOP - semestr 2");

        // Menu pizza - wybieranie
        MenuPizza menu = new MenuPizza();
        Pizza pizza = menu.wybierzPizze();
            if (pizza == null) {
                System.out.println("Nie wybrałeś pizzy. Do widzenia!");
            }

        // Rozmiar pizzy - wybieranie
        String rozmiar = RozmiarPizzy.wybierzRozmiarPizzy(scanner);

        // Rozmiar pizzy - info
        System.out.println("\n\u001B[4m" + "\nWybrany rozmiar pizzy to:"  + "\u001B[0m\n"+ String.join(", ", rozmiar));

        // Sosy - lista wyboru
        Sos sos = new Sos();
        List<String> wybraneSosy = sos.wybierzSosy();

        // Napoje - lista wyboru
        Map<Napoj, Integer> wybraneNapoje = new HashMap<>();
        Napoj napoj = Napoj.wybierzNapoj(scanner);

        // Wywołanie metody wybierzPepsi()
        Napoj pepsi = Pepsi.wybierzPepsi(scanner);

        // Wywołanie metody wybierzCocaCola
        Napoj cocaCola = CocaCola.wybierzCocaCola(scanner);

        // Wywołanie metody wybierzSok
        Napoj sok = Sok.wybierzSok(scanner);

        // Wywołanie metody wybierzPiwo
        Napoj piwo = Piwo.wybierzPiwo(scanner);

        // Wywołanie metody wybierzWino
        Napoj wino = Wino.wybierzWino(scanner);

        // Napoje - info
        Napoj.wyswietlPodsumowanieNapojow(wybraneNapoje);
        // Dane adresowe - pobieranie
        Adres adres = Adres.pobierzDaneAdresowe();

        // Sprawdzanie poprawności adresu
        while (!adres.czyPoprawnyAdres()) {
            System.out.println("Podane dane adresowe są niepoprawne. Spróbuj ponownie.");
            adres = Adres.pobierzDaneAdresowe();
        }

        // Wyświetlanie adresu dostawy
        adres.wyswietlAdres();

        // Potwierdzenie adresu dostawy
        if (adres.potwierdzAdres()) {
            // Wykonaj operacje
        }

        // Tworzenie obiektu Zamowienie
        Zamowienie zamowienie = new Zamowienie(pizza, rozmiar, new ArrayList<>(wybraneSosy), napoj, adres);

        // Wybór sposobu płatności
        Platnosc platnosc = Platnosc.wybierzSposobPlatnosci();

        // Podsumowanie zamówienia
        zamowienie.podsumowanieZamowienia();

        // Zamknięcie metody scanner
        scanner.close();
    }
}
