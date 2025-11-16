import java.util.ArrayList;
import java.util.List;

public class nawroty_Plecakowy {
        static final int[] V = {6, 2, 3, 2, 3, 1}; // objetosc
        static final int[] W = {6, 4, 5, 7, 10, 2}; // wartosc
        static final int pojemnosc = 10;
        static final int liczba_przedmiotow = 6;
        static List<List<Integer>> rozwiazania = new ArrayList<>();

        public static int sumowanieW(List<Integer> aktualne) {
            int suma = 0;
            for (int index : aktualne) {
                suma += W[index];
            }
            return suma;
        }

        public static int sumowanieV(List<Integer> aktualne) {
            int suma = 0;
            for (int index : aktualne) {
                suma += V[index];
            }
            return suma;
        }

        public static void z_powracaniem(List<Integer> aktualne, int aktualnyindex) {
            int sumaV = sumowanieV(aktualne);

            if (sumaV > pojemnosc) {
                return; // przekroczono pojemnosc - wracamy
            }

            if (sumaV == pojemnosc) {
                rozwiazania.add(new ArrayList<>(aktualne)); // dodajemy kopie
                return;
            }

            // Przechodzimy przez pozostale przedmioty
            for (int i = aktualnyindex + 1; i < liczba_przedmiotow; i++) {
                aktualne.add(i); // dodajemy przedmiot
                z_powracaniem(aktualne, i); // rekurencja
                aktualne.remove(aktualne.size() - 1); // backtracking - usuwamy przedmiot
            }
        }

        public static void main(String[] args) {
            for (int i = 0; i < liczba_przedmiotow; i++) {
                List<Integer> aktualne = new ArrayList<>();
                aktualne.add(i);
                z_powracaniem(aktualne, i);
            }

            System.out.println("Znalezione rozwiazania:");
            for (List<Integer> rozwiazanie : rozwiazania) {
                System.out.println("Przedmioty: " + rozwiazanie +
                        ", Wartosc: " + sumowanieW(rozwiazanie));
            }
        }
    }