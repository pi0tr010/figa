import java.util.HashMap;

public class Dynamicznie_silnia {
    public static final int n=10;
    static HashMap<Integer,Integer> rozwiazania = new HashMap<Integer,Integer>();

    public static int silnia(int n){
        if(rozwiazania.containsKey(n)){
            return rozwiazania.get(n);
        }else{
            int wynik = n * silnia(n-1);
            rozwiazania.put(n,wynik);
            return wynik;
        }
    }

    public static void main(String[] args) {
        rozwiazania.put(0,1);
        rozwiazania.put(1,1);
        System.out.println(silnia(n));
    }
}
