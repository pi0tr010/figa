import java.util.ArrayList;
import java.util.List;

public class S_zachlanny_plecak {
    static final int[] V = {6, 2, 3, 2, 3, 1}; // objetosc
    static final int[] W = {6, 4, 5, 7, 10, 2}; // wartosc
    static final int pojemnosc = 10;
    static final int liczba_przedmiotow = 6;
    static int [] dostpene = {1,1,1,1,1,1};
    public static void zachlanny(){
        List<Integer> wynik = new ArrayList<>();
        int objetoscZestawu =0;
        while(true){
            double najRatio=-1;
            int index_najlepszego=-1;
            for(int i=0;i<6;i++){
                if(dostpene[i]==0){
                    continue;
                }
                if (objetoscZestawu + V[i] <= pojemnosc) {
                    double ratio = (double) W[i] / V[i];
                    if(najRatio<ratio){
                        najRatio=ratio;
                        index_najlepszego =i;
                    }
                }
            }

            if(objetoscZestawu == pojemnosc || index_najlepszego == -1){
                break;
            }
            wynik.add(index_najlepszego);
            objetoscZestawu += V[index_najlepszego];
            dostpene[index_najlepszego]=0;
        }
        System.out.println(wynik);
    }

    public static void main(String[] args) {
        zachlanny();
    }
}
