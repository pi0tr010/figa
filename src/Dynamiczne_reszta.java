public class Dynamiczne_reszta {

    // memo[dlugosc][reszta]
    static int[][] memo;

    public static int dziel_i_zwyciezaj(int[] monety, int dlugosc, int reszta) {

        if (memo[dlugosc][reszta] != -1) {
            return memo[dlugosc][reszta];
        }

        if (reszta == 0) {
            return 0;
        }

        if (dlugosc == 0) {
            return Integer.MAX_VALUE / 2;
        }

        int wynik;

        if (monety[dlugosc - 1] > reszta) {
            wynik = dziel_i_zwyciezaj(monety, dlugosc - 1, reszta);
        } else {
            int bierzemy = 1 + dziel_i_zwyciezaj(monety, dlugosc, reszta - monety[dlugosc - 1]);
            int nieBierzemy = dziel_i_zwyciezaj(monety, dlugosc - 1, reszta);
            wynik = Math.min(bierzemy, nieBierzemy);
        }


        memo[dlugosc][reszta] = wynik;

        return wynik;
    }

    public static void main(String[] args) {
        int[] monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int reszta = 51;
        int dlugosc = monety.length;


        memo = new int[dlugosc + 1][reszta + 1];


        for (int i = 0; i <= dlugosc; i++) {
            for (int j = 0; j <= reszta; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(dziel_i_zwyciezaj(monety, dlugosc, reszta));
    }
}
