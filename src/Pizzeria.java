import com.pizzamich.*;

import java.text.DecimalFormat;
import java.util.*;


class Pizzeria {
    private static final List<Pizza> menu = new ArrayList<>();
    private static final List<String> dostepneSkladniki = new ArrayList<>();
    private static final String nrZamowienia = "12345"; // Przykładowy numer zamówienia

    public static void main(String[] args) {
        inicjalizujMenu();
        inicjalizujDostepneSkladniki();

        // Tworzenie instancji DecimalFormat z odpowiednim formatem
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        // Wyświetlanie powitania
        System.out.println("\n\u001B[4m" + "Witaj w pizzerii pizza.mich!" + "\u001B[0m\n");
        String aktualnaData = pobierzAktualnaDate();
        System.out.println("Dzisiaj jest: " + aktualnaData);
        System.out.println("Zapraszamy od PN-ND 11:00 - 23:00");

        // Wyświetlanie opcji wyboru
        boolean koniec = false;
        while (!koniec) {
            System.out.println("\n\u001B[4m" + "Proszę wybrać: " + "\u001B[0m");
            System.out.println("1. Pizzę z menu");
            System.out.println("2. Napój");
            System.out.println("3. Adres dostawy");
            System.out.println("4. Odbiór osobisty");
            System.out.println("5. Sposób płatności");
            System.out.println("0. Zakończ");

            System.out.println("\nWpisz numer: ");

            Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 0:
                    koniec = true;
                    System.out.println("Dziękujemy za zamówienie");
                    break;
                case 1:
                    zamowPizza(); // Wywołanie metody zamówienia pizzy
                    break;
                case 2:
                    Napoj napoj = Napoj.wybierzNapoj(scanner, new HashMap<>()); // Wybieranie napoju
                    // Sprawdzanie czy wybrano napój (a nie brak napoju)
                    if (!(napoj instanceof BrakNapoju)) {
                        System.out.println("Wybrany napój: " + napoj.getNazwa());
                    }
                    break;
                case 3:
                    AdresDostawy adresDostawy = new AdresDostawy(); // Wywołanie metody wyboru adresu dostawy
                    adresDostawy.wybierzAdresDostawy();
                    break;
                case 4:
                    OdbiorOsobisty.odbiorOsobisty();
                    break;
                case 5:
                    Platnosc platnosc = new Platnosc.PlatnoscBankowa();
                    System.out.println("Wybrany sposób płatności: " + platnosc.getMetoda());
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void inicjalizujMenu() {
        // Tworzenie listy składników wegetariańskich
        List<String> skladnikiWegetarianskie = new ArrayList<>();
        skladnikiWegetarianskie.add("papryka");
        skladnikiWegetarianskie.add("pieczarki");
        skladnikiWegetarianskie.add("cebula");
        skladnikiWegetarianskie.add("oliwki");
        Pizza wegetarianska = new Pizza("Wegetariańska", skladnikiWegetarianskie);
        menu.add(wegetarianska);

        // Tworzenie listy składników Capriciosa
        List<String> skladnikiCapriciosa = new ArrayList<>();
        skladnikiCapriciosa.add("szynka");
        skladnikiCapriciosa.add("pieczarki");
        skladnikiCapriciosa.add("cebula");
        skladnikiCapriciosa.add("oliwki");
        Pizza capriciosa = new Pizza("Capriciosa", skladnikiCapriciosa);
        menu.add(capriciosa);

        // Tworzenie listy składników Peperoni
        List<String> skladnikiPepperoni = new ArrayList<>();
        skladnikiPepperoni.add("pepperoni");
        skladnikiPepperoni.add("ser");
        skladnikiPepperoni.add("cebula");
        skladnikiPepperoni.add("papryka");
        Pizza pepperoni = new Pizza("Pepperoni", skladnikiPepperoni);
        menu.add(pepperoni);
    }

    private static void inicjalizujDostepneSkladniki() {
        dostepneSkladniki.add("ser");
        dostepneSkladniki.add("szynka");
        dostepneSkladniki.add("krewetki");
        dostepneSkladniki.add("pieczarki");
        dostepneSkladniki.add("cebula");
        dostepneSkladniki.add("brokuły");
        dostepneSkladniki.add("czosnek");
        dostepneSkladniki.add("szpinak");
        dostepneSkladniki.add("papryka");
        dostepneSkladniki.add("kukurydza");
        dostepneSkladniki.add("oliwki");
        dostepneSkladniki.add("salami");
        dostepneSkladniki.add("jalapeno");
        dostepneSkladniki.add("fasola");
        dostepneSkladniki.add("żurawina");
        dostepneSkladniki.add("jajko");
        dostepneSkladniki.add("szczypiorek");
    }

    private static void wyswietlMenu() {
        System.out.println("\n\u001B[4m" + "Menu:" + "\u001B[0m");

        int numer = 1;
        for (Pizza pizza : menu) {
            // Wyświetlanie informacji o pizzy
            System.out.println(numer + ". " + pizza.getNazwa() + " - cena: " + obliczCenePizza(pizza) + " PLN");
            numer++;
        }
    }

    private static double obliczCenePizza(Pizza pizza) {
        double cenaPodstawowa = 10.0; // com.pizzamich.Cena podstawowa dla każdej pizzy
        double cenaZaSkladnik = 2.0; // com.pizzamich.Cena za każdy dodatkowy składnik

        int liczbaDodatkowychSkladnikow = pizza.getSkladniki().size() - 4; // Ilość dodatkowych składników (odejmujemy stałe składniki)
        double cenaZaDodatkoweSkladniki = liczbaDodatkowychSkladnikow * cenaZaSkladnik;

        return cenaPodstawowa + cenaZaDodatkoweSkladniki;
    }

    private static void zamowPizza() {
        wyswietlMenu();
        System.out.println("\nWpisz numer pizzy z menu: ");

        Scanner scanner = new Scanner(System.in);
        int numerPizza = scanner.nextInt();

        if (numerPizza < 1 || numerPizza > menu.size()) {
            // Sprawdzanie poprawności numeru pizzy
            System.out.println("Nieprawidłowy numer pizzy. Zamówienie anulowane.");
            return;
        }

        Pizza wybranaPizza = menu.get(numerPizza - 1);

        System.out.println("\n\u001B[4m" + "Wybierz rozmiar pizzy:" + "\u001B[0m");
        System.out.println("1. Mała - cena za rozmiar 30 cm " + wybranaPizza.getNazwa() + ": 15.0 PLN");
        System.out.println("2. Średnia - cena za rozmiar 35 cm " + wybranaPizza.getNazwa() + ": 20.0 PLN");
        System.out.println("3. Duża - cena za rozmiar 43 cm " + wybranaPizza.getNazwa() + ": 25.0 PLN");
        System.out.println("\nWpisz nr rozmiaru: ");

        int wyborRozmiaru = scanner.nextInt();
        double cenaRozmiar;
        String rozmiar;

        switch (wyborRozmiaru) {
            case 1:
                cenaRozmiar = 15.0;
                rozmiar = "Mała";
                break;
            case 2:
                cenaRozmiar = 20.0;
                rozmiar = "Średnia";
                break;
            case 3:
                cenaRozmiar = 25.0;
                rozmiar = "Duża";
                break;
            default:
                System.out.println("Nieprawidłowy numer rozmiaru. Zamówienie anulowane.");
                return;
        }

        System.out.println("\n\u001B[4m" + "Dostępne składniki (dodatkowa opcja):" + "\u001B[0m");
        wyswietlDostepneSkladniki();

        List<String> wybraneSkladniki = new ArrayList<>();
        boolean koniecDodawaniaSkladnikow = false;

        while (!koniecDodawaniaSkladnikow) {
            System.out.print("\nWpisz numer składnika, \n(wpisz: 0, aby zakończyć dodawanie składników): ");
            int numerSkladnika = scanner.nextInt();

            if (numerSkladnika == 0) {
                koniecDodawaniaSkladnikow = true;
            } else if (numerSkladnika < 1 || numerSkladnika > dostepneSkladniki.size()) {
                System.out.println("Nieprawidłowy numer składnika. Spróbuj ponownie.");
            } else {
                String wybranySkladnik = dostepneSkladniki.get(numerSkladnika - 1);
                wybraneSkladniki.add(wybranySkladnik);
                System.out.println("Wybrany składnik: " + wybranySkladnik);
            }
        }

        System.out.println("\n\u001B[4m" + "Podsumowanie zamówienia:" + "\u001B[0m");
        System.out.println("Wybrałeś pizzę " + wybranaPizza.getNazwa() + " w rozmiarze " + rozmiar);
        System.out.println("Zawierająca składniki: " + wybranaPizza.getSkladniki());
        System.out.println("Twoja pizza zawiera dodatkowe składniki: " + wybraneSkladniki);
        double cenaPizza = obliczCenePizza(wybranaPizza) + cenaRozmiar + obliczCeneDodatkowychSkladnikow(wybraneSkladniki);
        System.out.println("Całkowita cena: " + cenaPizza + " PLN");
    }

    private static void wyswietlDostepneSkladniki() {
        int numer = 1;
        for (String skladnik : dostepneSkladniki) {
            System.out.println(numer + ". " + skladnik + " - cena za składnik: " + obliczCeneSkladnika(skladnik) + " PLN");
            numer++;
        }
    }

    private static double obliczCeneSkladnika(String skladnik) {
        switch (skladnik) {
            case "ser":
            case "cebula":
            case "szpinak":
            case "papryka":
            case "kukurydza":
            case "fasola":
            case "szczypiorek":
                return 1.0;
            case "szynka":
            case "salami":
            case "jalapeno":
                return 2.0;
            case "pieczarki":
                return 1.5;
            case "brokuły":
                return 2.5;
            case "czosnek":
            case "oliwki":
            case "krewetki":
                return 3.0;
            case "żurawina":
            case "jajko":
                return 1.5;
            default:
                return 0.0;
        }
    }

    private static double obliczCeneDodatkowychSkladnikow(List<String> skladniki) {
        double cenaDodatkowychSkladnikow = 0.0;

        for (String skladnik : skladniki) {
            cenaDodatkowychSkladnikow += obliczCeneSkladnika(skladnik);
        }

        return cenaDodatkowychSkladnikow;
    }

    private static String pobierzAktualnaDate() {
        Calendar calendar = Calendar.getInstance();
        Date data = calendar.getTime();
        return data.toString();
    }

}
