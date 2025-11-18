import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class S_MonteCarlo_monety {
    static final int [] monety = {500,200,100,50,20,10,5,2,1};
    static final int reszta = 67;
    static final int liczba_stanow = 1000000;
    static Random rand = new Random();

    public static List<Integer> losowanie(){
        int pomocnicza_rezszta =0;
        List <Integer> wynik = new ArrayList<>();
        while(pomocnicza_rezszta != reszta){
            int losowa = rand.nextInt(0,9);
            if(monety[losowa]+pomocnicza_rezszta > reszta){
                continue;
            }else{
                wynik.add(losowa);
                pomocnicza_rezszta +=monety[losowa];
            }
        }
        return wynik;
    }

    public static List<Integer> sprawdzanie(){
        List<List<Integer>> losowania = new ArrayList<>();
        for(int i=0;i<liczba_stanow;i++){
            losowania.add(losowanie());
        }
        List<Integer> najlepsza_kombinacja = new ArrayList<>();
        int najlepsza_liczba_monet =10000;
        for (List<Integer> innerlist : losowania){
            int liczba_monet =0;
            for (Integer element : innerlist){
                liczba_monet++;
            }
            if(liczba_monet<najlepsza_liczba_monet){
                najlepsza_kombinacja = innerlist;
            }
        }
        return najlepsza_kombinacja;
    }

    public static void main(String[] args) {
        System.out.println(sprawdzanie());
    }
}
