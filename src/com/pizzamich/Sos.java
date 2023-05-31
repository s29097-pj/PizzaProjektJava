package com.pizzamich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sos {
    private Scanner scanner;

    public Sos() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> wybierzSosy() {
        System.out.println("\n\u001B[4m" + "Wybierz dodatkowy sos:" + "\u001B[0m");
        System.out.println("1. Pomidorowy ostry");
        System.out.println("2. Pomidorowy łagodny");
        System.out.println("3. Czosnkowy");
        System.out.println("4. Salsa");
        System.out.println("5. Musztardowy");
        System.out.println("6. BBQ");
        System.out.println("7. Miodowy");
        System.out.println("8. Cacyki");

        List<String> wybraneSosy = new ArrayList<>();

        while (true) {
            System.out.print("\nWybierz numer sosu (lub wpisz 'gotowe' aby zakończyć): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("gotowe")) {
                break;
            }

            try {
                int sosNr = Integer.parseInt(input);

                if (sosNr >= 1 && sosNr <= 8) {
                    String sos = "";
                    switch (sosNr) {
                        case 1:
                            sos = "Pomidorowy ostry";
                            break;
                        case 2:
                            sos = "Pomidorowy łagodny";
                            break;
                        case 3:
                            sos = "Czosnkowy";
                            break;
                        case 4:
                            sos = "Salsa";
                            break;
                        case 5:
                            sos = "Musztardowy";
                            break;
                        case 6:
                            sos = "BBQ";
                            break;
                        case 7:
                            sos = "Miodowy";
                            break;
                        case 8:
                            sos = "Cacyki";
                            break;
                    }

                    System.out.print("Podaj ilość sosu " + sos + ": ");
                    int ilosc = scanner.nextInt();
                    scanner.nextLine();

                    if (ilosc <= 0) {
                        System.out.println("Nieprawidłowa ilość sosu. Pominięto dodawanie.");
                    } else {
                        String sosWielokrotny = ilosc > 1 ? ilosc + "x " + sos : sos;
                        if (wybraneSosy.contains(sosWielokrotny)) {
                            int index = wybraneSosy.indexOf(sosWielokrotny);
                            String aktualnySos = wybraneSosy.get(index);
                            String[] split = aktualnySos.split("x ");
                            int iloscAktualna = Integer.parseInt(split[0]);
                            int iloscSumowana = iloscAktualna + ilosc;
                            String sosSumowany = iloscSumowana + "x " + split[1];
                            wybraneSosy.set(index, sosSumowany);
                            System.out.println("Dodano sos " + sosWielokrotny + ", bo to samo co: " + sosSumowany);
                        } else {
                            wybraneSosy.add(sosWielokrotny);
                            System.out.println("Dodano sos " + sosWielokrotny);
                        }
                    }
                } else {
                    System.out.println("Nieprawidłowy numer sosu. Spróbuj ponownie.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format. Spróbuj ponownie.");
            }

            System.out.print("\nDodać kolejny sos? (1. Tak / 2. Nie): ");
            String wybor = scanner.nextLine();

            if (wybor.equals("2")) {
                break;
            }
        }

        System.out.println("\n\u001B[4m" + "\nWybrane sosy: "  + "\u001B[0m\n" + String.join(", ", wybraneSosy));

        return wybraneSosy;
    }
}
