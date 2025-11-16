import java.util.ArrayList;
import java.util.List;

public class nawroty_plecakowy_ogl {
    static final int[] V = {6, 2, 3, 2, 3, 1}; // objetosc
    static final int[] W = {6, 4, 5, 7, 10, 2}; // wartosc
    static final int pojemnosc = 23;
    static final int liczba_przedmiotow = 6;

    static int maxWartosc = 0;
    static List<Integer> najlepszeRozwiazanie = new ArrayList<>();
    static int liczba_wywolan = 0;


    public static int sumowanieW(List<Integer> aktualne) {
        int suma = 0;
        for (int index : aktualne) {
            suma += W[index];
        }
        return suma;
    }


    public static void generujITestuj(List<Integer> aktualne, int aktualnaObjetosc, int aktualnaWartosc, int ostatniIndex) {
        liczba_wywolan++;

        // TESTOWANIE: Sprawdzamy czy aktualne rozwiązanie jest dopuszczalne i najlepsze
        if (aktualnaObjetosc <= pojemnosc) {
            if (aktualnaWartosc > maxWartosc) {
                maxWartosc = aktualnaWartosc;
                najlepszeRozwiazanie = new ArrayList<>(aktualne);
            }
        } else {
            return; // Przekroczono pojemność - odcinamy gałąź
        }

        // GENEROWANIE: Dodajemy kolejne przedmioty (mogą się powtarzać)
        for (int i = ostatniIndex; i < liczba_przedmiotow; i++) {
            // Sprawdzamy czy dodanie tego przedmiotu nie przekroczy pojemności
            if (aktualnaObjetosc + V[i] <= pojemnosc) {
                // Dodajemy przedmiot
                aktualne.add(i);

                // Rekurencyjnie generujemy kolejne możliwości
                generujITestuj(aktualne, aktualnaObjetosc + V[i], aktualnaWartosc + W[i], i);

                // POWRACANIE: Usuwamy przedmiot (backtracking)
                aktualne.remove(aktualne.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> aktualne = new ArrayList<>();
        generujITestuj(aktualne, 0, 0, 0);

        System.out.println("Przedmioty (indeksy): " + najlepszeRozwiazanie);
        System.out.println("Wartosc: " + sumowanieW(najlepszeRozwiazanie));

    }

}
