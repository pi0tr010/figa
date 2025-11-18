public class S_DzielIZwyiezaj_plecak {
    static final int[] V = {6, 2, 3, 2, 3, 1}; // objetosc
    static final int[] W = {6, 4, 5, 7, 10, 2}; // wartosc
    static final int pojemnosc = 10;
    static final int liczba_przedmiotow = 6;

    public static int plecakowy(int i, int pozostalaPojemnosc){
        if(pozostalaPojemnosc <=0 || i<0){ // WARUNEK 1 BRAK MIEJSCA lub nie ma juz liczb
            return 0;
        }
        if(V[i] > pozostalaPojemnosc){ //Przedmiot sie nie misci juz
            return plecakowy(i-1,pozostalaPojemnosc);
        }
        // nie bierzemy
        int nieBierzemy = plecakowy(i-1,pozostalaPojemnosc);
        //bierzemy
        int Bierzemy = W[i] + plecakowy(i-1,pozostalaPojemnosc -V[i]);

        return Math.max(nieBierzemy,Bierzemy);
    }

    public static void main(String[] args) {
        // Zmiana: liczba_przedmiotow-1 zamiast liczba_przedmiotow
        System.out.print(plecakowy(liczba_przedmiotow-1, pojemnosc));
    }
}