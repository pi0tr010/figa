import java.util.Arrays;

public class BrutalnaSila_reszta {
    static final int [] monety = {500,200,100,50,20,10,5,2,1};              //UWAGA PROGRAM MYSLI BARDZO DLUGO DLA doWydania > 200
    static final int doWydania = 160;
    static int dlugosc = monety.length;
    static int[] najlepszaKombinacja;
    static int najmniejszaIloscMonet = Integer.MAX_VALUE;       // Inaczej nie dziala bedzie null


    public static void reszta(int index,int [] aktualny,int [] maxIlosc){
        if (index == dlugosc) {
            int suma = 0;
            int liczbaMonet = 0;

            for (int i = 0; i < dlugosc; i++) {
                suma += aktualny[i] * monety[i];
                liczbaMonet += aktualny[i];
            }

            if (suma == doWydania && liczbaMonet < najmniejszaIloscMonet) {
                najmniejszaIloscMonet = liczbaMonet;
                najlepszaKombinacja = Arrays.copyOf(aktualny, dlugosc);
            }
            return;
        }

        for (int i = 0; i <= maxIlosc[index]; i++) {
            aktualny[index] = i;
            reszta(index + 1, aktualny, maxIlosc);
        }
    }


    public static void main(String[] args) {
        int [] bestSolution = new int[dlugosc];

        // maksymalna liczba sztuk kazdego emelemntu
        int[] maxIlosc = new int [dlugosc];
        for(int i =0; i<dlugosc;i++){
            maxIlosc[i] = doWydania/monety[i];
        }

        int[] aktualny = new int[dlugosc];
        reszta(0,aktualny,maxIlosc);


        System.out.println(Arrays.toString(najlepszaKombinacja));
        System.out.println(najmniejszaIloscMonet);
    }
}
