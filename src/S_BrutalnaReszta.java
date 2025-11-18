import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_BrutalnaReszta {
    static final int [] monety = {500,200,100,50,20,10,5,2,1};
    static final int reszta = 67;

    public static int [] brutal(){
        int [] MaxIlosc = new int[monety.length];
        for (int i=0;i< monety.length;i++){
            MaxIlosc[i] = reszta/monety[i];
        }

        int najmniejsza_ilosc_monet =1000;
        int [] najlepszy_zestaw = new  int[9];

        for(int i0=0;i0<=MaxIlosc[0];i0++){
            for(int i1=0;i1<=MaxIlosc[1];i1++){
                for(int i2=0;i2<=MaxIlosc[2];i2++){
                    for(int i3=0;i3<=MaxIlosc[3];i3++){
                        for(int i4=0;i4<=MaxIlosc[4];i4++){
                            for(int i5=0;i5<=MaxIlosc[5];i5++){
                                for(int i6=0;i6<=MaxIlosc[6];i6++){
                                    for(int i7=0;i7<=MaxIlosc[7];i7++){
                                        for(int i8=0;i8<=MaxIlosc[8];i8++){
                                            int [] aktualny = {i0,i1,i2,i3,i4,i5,i6,i7,i8};
                                            int suma =0;
                                            int IloscMonet=0;
                                            for(int i=0;i<monety.length;i++){
                                                suma += aktualny[i]*monety[i];
                                                IloscMonet+=aktualny[i];
                                            }

                                            if(suma != reszta){
                                                continue;
                                            }

                                            if(najmniejsza_ilosc_monet > IloscMonet){
                                                najmniejsza_ilosc_monet = IloscMonet;
                                                najlepszy_zestaw = aktualny;

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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(brutal()));
    }
}
