public class DzielIZwyciezaj_reszta {
    public static int dziel_i_zwyciezaj(int [] monety, int dlugosc, int reszta){
        if(reszta == 0){
            return 0;
        }

        if (dlugosc == 0) {// unikamy przepełnienia
            return Integer.MAX_VALUE / 2;
        }

        if (monety[dlugosc - 1] > reszta) { // aktualna moneta wieksza niz reszta SKIP
            return dziel_i_zwyciezaj(monety, dlugosc - 1, reszta);
        }
        int bierzemy =  1 + dziel_i_zwyciezaj(monety,dlugosc,reszta-monety[dlugosc -1]);
        int nieBierzemy = dziel_i_zwyciezaj(monety,dlugosc-1,reszta);
        return Math.min(bierzemy,nieBierzemy);
    }


    public static void main(String[] args) {
        int[] monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int reszta = 51;
        int dlugosc = monety.length;
        System.out.println( dziel_i_zwyciezaj(monety,dlugosc,reszta));
    }
}
