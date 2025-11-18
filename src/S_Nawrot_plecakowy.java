import java.util.ArrayList;
import java.util.List;

public class S_Nawrot_plecakowy {
    static final int[] V = {6, 2, 3, 2, 3, 1}; // objetosc
    static final int[] W = {6, 4, 5, 7, 10, 2}; // wartosc
    static final int pojemnosc = 10;
    static final int liczba_przedmiotow = 6;
    static List <List<Integer> >wyniki = new ArrayList<>();

    public static void nawrot(int index, List<Integer> aktualne){
        int sumaV = 0;              // suma V
        for(Integer i : aktualne){
            sumaV += V[i];
        }
        if(sumaV > pojemnosc){ // jezeli nie misci sie wracamy
            return;
        }
        if(sumaV<=pojemnosc){   // miesci sie dodajemy
            wyniki.add(new ArrayList<>(aktualne));
        }

        for(int i=index+1;i<liczba_przedmiotow;i++){
            aktualne.add(i);
            nawrot(i,aktualne);
            aktualne.remove(aktualne.size()-1); // powrot
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < liczba_przedmiotow; i++) {
            List<Integer> aktualne = new ArrayList<>();
            aktualne.add(i);
            nawrot(i,aktualne);
        }
        int najlepszyV=0;
        List <Integer> najlepszy_zestaw = new ArrayList<>();
        for(List<Integer> innerList : wyniki){
            int pomocniczyV=0;
            for (Integer element : innerList){
                pomocniczyV += W[element];
            }
            if(pomocniczyV>najlepszyV){
                najlepszyV = pomocniczyV;
                najlepszy_zestaw = innerList;
            }
        }
        System.out.println(najlepszy_zestaw+ "   "+ najlepszyV);
    }
}
