import java.util.ArrayList;
import java.util.List;

public class SS_nawrot_monety {
    static final int [] monety = {500,200,100,50,20,10,5,2,1};
    static final int reszta = 67;
    static int najmniejsza_liczba_monet = 1000;
    static List<Integer> najlepsza_kombinacja = new ArrayList<>();

    public static void nawroty(int index, int pozostala_reszta, List<Integer> aktualne, int liczba_monet) {
        if (pozostala_reszta < 0) {
            return;
        }

        if (pozostala_reszta == 0) {
            if (liczba_monet < najmniejsza_liczba_monet) {
                najlepsza_kombinacja = new ArrayList<>(aktualne);
                najmniejsza_liczba_monet = liczba_monet;
            }
            return;
        }

        for (int i = index; i < monety.length; i++) {
            if (monety[i] <= pozostala_reszta) {
                // POPRAWA: używaj monety[i] zamiast monety[index]
                aktualne.add(monety[i]);
                nawroty(i, pozostala_reszta - monety[i], aktualne, liczba_monet + 1);
                aktualne.remove(aktualne.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        nawroty(0, reszta, lista, 0);
        System.out.println(najlepsza_kombinacja);
    }
}
