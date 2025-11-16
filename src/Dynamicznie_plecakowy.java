import java.util.Dictionary;
import java.util.Hashtable;

public class Dynamicznie_plecakowy {
    final static int[] V = {6, 2, 3, 2, 3, 1};
    final static int[] W = {6, 4, 5, 7, 10, 2};
    final static int N = V.length;
    final static int MAX_V = 10;

    static Dictionary<String, Integer> zapisane_rozwiazania = new Hashtable<>();

    public static void main(String[] args) {
        System.out.println("Maksymalna wartość zestawu: " + plecak_dynamicznie(0, MAX_V));
    }

    static int plecak_dynamicznie(int i, int capacity) {
        String key = i + "," + capacity;

        // sprawdzenie czy znamu juz wartosc
        if (zapisane_rozwiazania.get(key) != null) {
            return zapisane_rozwiazania.get(key);
        }

        // warunek koncowy koniec przedmiotow || koniec miejca w plecku
        if (i == N || capacity == 0) {
            return 0;
        }

        int result;

        // Jeśli przedmiot nie mieści się
        if (V[i] > capacity) {
            result = plecak_dynamicznie(i + 1, capacity);
        } else {
            //
            int nie_bierzemy = plecak_dynamicznie(i + 1, capacity);
            int bierzemy = W[i] + plecak_dynamicznie(i + 1, capacity - V[i]);
            // Wybieramy maksimum z opcji: nie nie_bierzemy lub bierzemy i-ty przedmiot
            result = Math.max(nie_bierzemy, bierzemy);
        }

        // Zapisujemy wynik do słownika z zapamietanymi wartosciami
        zapisane_rozwiazania.put(key, result);
        return result;
    }
}