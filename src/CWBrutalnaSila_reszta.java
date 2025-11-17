import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CWBrutalnaSila_reszta {

    public static int[] generowanie_wszytskich_kombinacji(int[] MaxIlosc, int dlugosc, int reszta, int[] monety) {
        int[] najlepszy_zestaw = new int[dlugosc];
        int najmniej_monet = Integer.MAX_VALUE;
        for (int i0 = 0; i0 <= MaxIlosc[0]; i0++) {
            for (int i1 = 0; i1 <= MaxIlosc[1]; i1++) {
                for (int i2 = 0; i2 <= MaxIlosc[2]; i2++) {
                    for (int i3 = 0; i3 <= MaxIlosc[3]; i3++) {
                        for (int i4 = 0; i4 <= MaxIlosc[4]; i4++) {
                            for (int i5 = 0; i5 <= MaxIlosc[5]; i5++) {
                                for (int i6 = 0; i6 <= MaxIlosc[6]; i6++) {
                                    for (int i7 = 0; i7 <= MaxIlosc[7]; i7++) {
                                        for (int i8 = 0; i8 <= MaxIlosc[8]; i8++) {
                                            int[] kombinacja = {i0, i1, i2, i3, i4, i5, i6, i7, i8};
                                            int suma = 0;
                                            int iloscMonet = 0;
                                            for (int i = 0; i < dlugosc; i++) {
                                                suma += kombinacja[i] * monety[i];
                                                iloscMonet += kombinacja[i];
                                            }
                                            if (suma == reszta) {
                                                if (iloscMonet < najmniej_monet) {
                                                    najmniej_monet = iloscMonet;
                                                    najlepszy_zestaw = kombinacja;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return najlepszy_zestaw;
    }
    public static void main (String[]args){
        int[] monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int reszta = 51;
        int dlugosc = monety.length;
        // Liczmy ile razy sie zmiesci kazdy element
        // maxymalnaIlosc
        int[] MaxIlosc = new int[dlugosc];
        for (int i = 0; i <= dlugosc - 1; i++) {
            MaxIlosc[i] = reszta / monety[i];
        }

       System.out.println(Arrays.toString(generowanie_wszytskich_kombinacji(MaxIlosc, dlugosc, reszta, monety)));
    }
}