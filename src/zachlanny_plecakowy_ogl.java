
import java.util.ArrayList;
import java.util.List;

public class zachlanny_plecakowy_ogl {
    public final static int [] V = {6,2,3,2,3,1};
    public  static int [] W =      {6,4,5,7,10,2};
    public final static int dlugosc = V.length;
    public final static int pojemnosc = 23;
    public static List <Integer> odpowiedz = new ArrayList<>();


    public static void plecak(){
        int aktualna_pojemnosc =0;
        while(aktualna_pojemnosc < pojemnosc){
            int najcennieszy=0;
            for(int i=0;i<=dlugosc-1;i++){
                if(W[i]>najcennieszy){
                    najcennieszy = i;
                }
            }
            if(V[najcennieszy] + aktualna_pojemnosc > pojemnosc){
                W[najcennieszy] =0;
            }else{
                odpowiedz.add(najcennieszy);
                aktualna_pojemnosc += V[najcennieszy];
            }

        }
    }

    public static void main(String[] args) {
        plecak();
        System.out.println(odpowiedz);
    }
}
