import java.util.ArrayList;
import java.util.List;
//pół-dobrze
public class zachlanny_plecakowy {
    static int[] V= {6, 2, 3, 2, 3, 1};
    static int[] W = {6, 4, 5, 7, 10, 2};
    final static int dlugosc = V.length;
    static int pojemnosc = 10;

    public static int znajdz_najlepszy(){
        double naj_ratio =0;
        int index_najlepszego=0;
        for(int i=0;i<=dlugosc-1;i++){
            if( V[i] > 0) {
                double ratio = (double) W[i] / V[i]; // Use double to avoid integer division
                if(ratio > naj_ratio) {
                    naj_ratio = ratio;
                    index_najlepszego = i;
                }
            }
        }
        return index_najlepszego;
    }

    public static void zachlanny(){
        List <Integer> zestaw_najlepszych = new ArrayList<>();
        int wartosc_zestawu = 0;
        while(pojemnosc > 0){
            int aktualny_naj = znajdz_najlepszy();
            if(V[aktualny_naj] > pojemnosc){
                W[aktualny_naj] = 0;
                continue;
            }
            zestaw_najlepszych.add(aktualny_naj);
            wartosc_zestawu+= W[aktualny_naj];
            pojemnosc -= V[aktualny_naj];
            W[aktualny_naj] = 0;
        }
        System.out.print(wartosc_zestawu+"<- wartosc \n");
        System.out.println(zestaw_najlepszych+"<- zestaw ");
    }

    public static void main(String[] args) {
       zachlanny();
    }
}
