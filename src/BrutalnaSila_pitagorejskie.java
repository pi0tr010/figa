import java.util.ArrayList;
import java.util.List;

public class BrutalnaSila_pitagorejskie {

    public static final int dlugosc_tablicy = 30;   //dla 30 zajmie to milion lat

    public static List <List<Integer>> wypisanie_wszytskich_kombinacji(){
        List <List<Integer>> mozliwosci = new ArrayList<>();
        int[] tab = new int[dlugosc_tablicy+1];
        int s = (int)Math.pow(2,dlugosc_tablicy);
        for (int l = 0; l < s; l++){
            List <Integer> pomocnicza = new ArrayList<>();
            for (int i = 0; i < dlugosc_tablicy; i++) {
                if (tab[i] == 1) {
                    pomocnicza.add(i + 1);
                    // Przerwanie jeśli już za dużo elementów
                    if (pomocnicza.size() > 3) break;
                }
            }

            if(pomocnicza.size() ==3){
                mozliwosci.add(pomocnicza);
            }

            int i = 0;
            do
            {
                if (tab[i] == 1)
                {
                    tab[i] = 0;
                    i++;
                }
                else
                {
                    tab[i] = 1;
                    break;
                }
            } while (true);
        }
        return mozliwosci;
    }


    public static List <List<Integer>> czy_pitagorejska(List<List<Integer>> lista){
        List <List<Integer>> mozliwosci = new ArrayList<>();
        for(List<Integer> inner : lista){
            int a = inner.get(0);
            int b = inner.get(1);
            int c = inner.get(2);
            if(a*a + b*b == c*c ||
                    a*a + c*c == b*b ||
                    b*b + c*c == a*a)
            {
                mozliwosci.add(inner);
            }
        }
        return mozliwosci;
    }

    public static void main(String[] args) {
        System.out.println(czy_pitagorejska(wypisanie_wszytskich_kombinacji()));

    }
}
