import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dynamicznie_plecakowy_ogl {
    public final static int[] V = {6, 2, 3, 2, 3, 1};
    public final static int[] W = {6, 4, 5, 7, 10, 2};

    // HashMap do memoizacji: klucz to pojemnosc + "-" + indeks
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int plecak(int pojemnosc) {
        if (pojemnosc <= 0) return 0;

        if (memo.containsKey(pojemnosc)) return memo.get(pojemnosc);

        int maxWartosc = 0;

        for (int i = 0; i < V.length; i++) {
            if (V[i] <= pojemnosc) {
                int wartosc = W[i] + plecak(pojemnosc - V[i]);
                if (wartosc > maxWartosc) maxWartosc = wartosc;
            }
        }

        memo.put(pojemnosc, maxWartosc);
        return maxWartosc;
    }

    public static void main(String[] args) {
        int maxWartosc = plecak(23);
        System.out.println("Maksymalna wartość plecaka: " + maxWartosc);
    }
}
