import java.util.*;

public class nawroty_reszta {
    public final static int[] monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    public final static int doWydania = 51;
    public final static int DlugoscMonety = monety.length;
    static int najmniejszaIloscMonet = Integer.MAX_VALUE;
    static List<Integer> najlepszaKombinacja = new ArrayList<>();

    public static void reszta(List<Integer> aktualnaKombinacja, int aktualna_wartosc, int index, int liczba_monet) {
        // Warunek stopu - znaleźliśmy rozwiązanie
        if (aktualna_wartosc == doWydania) {
            if (liczba_monet < najmniejszaIloscMonet) {
                najmniejszaIloscMonet = liczba_monet;
                najlepszaKombinacja = new ArrayList<>(aktualnaKombinacja); // Tworzymy kopię
            }
            return;
        }

        // Warunek stopu - przekroczyliśmy wartość lub skończyły się monety
        if (aktualna_wartosc > doWydania || index >= monety.length) {
            return;
        }

        // Sprawdzamy ile monet danego nominału możemy użyć
        int maxMonet = (doWydania - aktualna_wartosc) / monety[index];

        for (int ileUzywamy = maxMonet; ileUzywamy >= 0; ileUzywamy--) {
            // Dodajemy monety
            for (int j = 0; j < ileUzywamy; j++) {
                aktualnaKombinacja.add(monety[index]);
            }

            // Rekurencyjne wywołanie
            reszta(aktualnaKombinacja,
                    aktualna_wartosc + ileUzywamy * monety[index],
                    index + 1,
                    liczba_monet + ileUzywamy);

            // Nawrotka - usuwamy dodane monety
            for (int j = 0; j < ileUzywamy; j++) {
                aktualnaKombinacja.remove(aktualnaKombinacja.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        reszta(new ArrayList<>(), 0, 0, 0);
        System.out.println("Najlepsza kombinacja: " + najlepszaKombinacja);
        System.out.println("Liczba monet: " + najmniejszaIloscMonet);
    }
}