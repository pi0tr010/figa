import java.util.Arrays;

public class S_BrutalnaSila_plecakowy {
    final static int[] V = {6, 2, 3, 2, 3, 1};
    final static int[] W = {6, 4, 5, 7, 10, 2};
    final static int N = V.length;
    final static int MAX_V = 10;


    public static int [] brutal(){
        int najlepsza_wartosc = 0;
        int [] najlepszy_zestaw = new int[6];
        for(int i0 =0;i0<=1;i0++){
            for(int i1 =0;i1<=1;i1++){
                for(int i2 =0;i2<=1;i2++){
                    for(int i3 =0;i3<=1;i3++){
                        for(int i4 =0;i4<=1;i4++){
                            for(int i5 =0;i5<=1;i5++){
                                int [] aktualne ={i0,i1,i2,i3,i4,i5};
                                int wartosc=0;
                                int objetosc =0;
                                for(int i=0;i<N;i++){
                                    if(aktualne[i]==1){
                                        wartosc += W[i];
                                        objetosc += V[i];
                                    }
                                }
                                if(objetosc <= MAX_V){
                                    if(wartosc > najlepsza_wartosc){
                                        najlepsza_wartosc = wartosc;
                                        najlepszy_zestaw = aktualne;
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


    public static void main(String[] args) {
        System.out.println(Arrays.toString(brutal()));
    }
}
