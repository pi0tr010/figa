import java.util.ArrayList;
import java.util.List;
// 2.1.1 Użyj metody „brutalnej siły” do rozwiązania decyzyjnego problemu plecakowego (patrz
//podrozdział A.1).
public class BrutalnaSila_plecakowy {
    final static int[] V = {6, 2, 3, 2, 3, 1};// objetosc
    final static int[] W = {6, 4, 5, 7, 10, 2};// wartosc
    final static int N = V.length;
    final static int MAX_V = 10;
    final static int [] P = {0,1,2,3,4,5};
    static int licznik = 0;
    static int sumaV=0;
    static List<List<Integer>> wszytskie_mozzliwosci = new ArrayList<>();
    static List<List<Integer>> poprawne_mozliwosci = new ArrayList<>();
    static int max_V =0;
    static List<Integer> max_zbiur = new ArrayList<>();

    public static void main(String[] args) {
        Tworzenie_wszytskich_kombinacji();
        Sprawdzanie_warunku();
        najlepsz_mozliowsc();
        System.out.println(max_zbiur);
        System.out.println(max_V);
    }

    public static void Tworzenie_wszytskich_kombinacji(){
        for(int i0=0;i0<=1;i0++){
            for(int i1=0;i1<=1;i1++){
                for(int i2=0;i2<=1;i2++){
                    for(int i3=0;i3<=1;i3++){
                        for(int i4=0;i4<=1;i4++){
                            for(int i5=0;i5<=1;i5++){
                                List<Integer> kombinacja = new ArrayList<>();
                                if (i0 == 1) kombinacja.add(P[0]);
                                if (i1 == 1) kombinacja.add(P[1]);
                                if (i2 == 1) kombinacja.add(P[2]);
                                if (i3 == 1) kombinacja.add(P[3]);
                                if (i4 == 1) kombinacja.add(P[4]);
                                if (i5 == 1) kombinacja.add(P[5]);

                                wszytskie_mozzliwosci.add(kombinacja);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void Sprawdzanie_warunku(){
        for (List<Integer> innerList : wszytskie_mozzliwosci) {
            int sumaV=0;
            for (Integer element : innerList) {
                sumaV+= V[element];
            }
            if (sumaV<= MAX_V){
                poprawne_mozliwosci.add(innerList);
            }
        }
    }

    public static void najlepsz_mozliowsc(){                        // z lenistwa nie zmienilem nazw ale chodzi o W
        for (List<Integer> innerList : poprawne_mozliwosci) {
            int sumaV=0;
            for (Integer element : innerList) {
                sumaV+= W[element];
            }
            if (sumaV > max_V){
                max_zbiur = innerList;
                max_V = sumaV;
            }
        }
    }
}
