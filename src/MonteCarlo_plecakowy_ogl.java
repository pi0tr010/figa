import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonteCarlo_plecakowy_ogl {
                                 // 0,1,2,3,4,5
    public static final int [] V = {6,2,3,2,3,1};
    public static final int [] W = {6,4,5,7,10,2};
    public static final int dlugosc = V.length;
    public static final int pojemnosc = 23;
    public static final int ilosc_stanow = 10;
    public static Random rand = new Random();
    static List<List<Integer>>stany = new ArrayList<>();

    public static List<Integer> losownaie(){
        int pojemnosc_pomocnicza =0;
        List <Integer> pomocnicza = new ArrayList<>();
        while (pojemnosc_pomocnicza < pojemnosc){
            int wylosowany = rand.nextInt(0,dlugosc);
            if(V[wylosowany]+pojemnosc_pomocnicza > pojemnosc){
                continue;
            }else{
                pojemnosc_pomocnicza+=V[wylosowany];
                pomocnicza.add(wylosowany);
            }
        }
        return  pomocnicza;
    }


    public static List<Integer> plecak(List<List<Integer>>stany){
        int najlepszaWartosc = 0;
        List <Integer> najlepszaOdpowiedz = new ArrayList<>();
        for(List<Integer> innerlist : stany){
            int sumaW = 0;
            for(Integer element : innerlist){
                sumaW+=W[element];
            }
            if(sumaW>najlepszaWartosc){
                najlepszaWartosc = sumaW;
                najlepszaOdpowiedz = new ArrayList<>(innerlist);
            }
        }
        return najlepszaOdpowiedz;
    }


    public static void main(String[] args) {
        for(int i=0;i<=ilosc_stanow-1;i++){
            stany.add(losownaie());
        }

        int sumaV=0;
        for(Integer i : plecak(stany)){
            sumaV+=V[i];
        }
        System.out.println(plecak(stany));
        System.out.println("V: "+sumaV);
    }
}
