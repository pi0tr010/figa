import java.util.ArrayList;
import java.util.List;

public class DzielIZwyciezaj_Plecakowy_ogl {
    public final static int [] V = {6,2,3,2,3,1};
    public final static int [] W = {6,4,5,7,10,2};

    public static int plecak(int pojemnosc,int dlugosc){
        if(pojemnosc <= 0 || dlugosc<=0){
            return 0;
        }
        int maxWartosc=0;

        for(int i=0;i <= dlugosc-1;i++){
            if(V[i]<= pojemnosc){
                int obecnWarotsc = W[i] + plecak(pojemnosc-V[i],dlugosc);

                if (obecnWarotsc > maxWartosc){
                    maxWartosc = obecnWarotsc;
                }

            }
        }
        return maxWartosc;
    }

    public static void main(String[] args) {
        System.out.println(plecak(23,V.length));
    }
}
