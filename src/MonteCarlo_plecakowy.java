import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonteCarlo_plecakowy {
    final static int[] V = {6, 2, 3, 2, 3, 1}; // objętości przedmiotów
    final static int[] W = {6, 4, 5, 7, 10, 2}; // wartości przedmiotów
    final static int dlugosc = V.length;
    final static int pojemnosc = 10;
    final static int liczba_prob = 10; // zwiększona liczba prób dla Monte Carlo

    public static void monte() {
        Random rand = new Random();
        int najlepsza_wartosc = 0;
        List<Integer> najlepszy_zestaw = new ArrayList<>();

        for (int i = 0; i < liczba_prob; i++) {
            List<Integer> biezacy_zestaw = new ArrayList<>();
            int biezaca_pojemnosc = pojemnosc;
            int biezaca_wartosc = 0;

            // Losowa permutacja przedmiotów
            List<Integer> dostepne_przedmioty = new ArrayList<>();
            for (int j = 0; j < dlugosc; j++) {
                dostepne_przedmioty.add(j);
            }

            // Dodawanie przedmiotów w losowej kolejności
            for (int index : dostepne_przedmioty) {
                if (V[index] <= biezaca_pojemnosc) {
                    biezacy_zestaw.add(index);
                    biezaca_pojemnosc -= V[index];
                    biezaca_wartosc += W[index];
                }
            }

            // Sprawdzanie czy znaleźliśmy lepsze rozwiązanie
            if (biezaca_wartosc > najlepsza_wartosc) {
                najlepsza_wartosc = biezaca_wartosc;
                najlepszy_zestaw = new ArrayList<>(biezacy_zestaw);
            }
        }

        // Wyświetlanie wyników
        System.out.println("Najlepszy znaleziony zestaw: " + najlepszy_zestaw);
        System.out.println("Wartość: " + najlepsza_wartosc);


    }

    public static void main(String[] args) {
        monte();
    }
}