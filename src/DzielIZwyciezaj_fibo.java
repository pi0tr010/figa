public class DzielIZwyciezaj_fibo {
    // Problem przewidywania liczebnosci królików

    public static int fibo(int liczebnosc){
        if(liczebnosc == 2 || liczebnosc == 1){
            return 1;
        }else{
            return (fibo(liczebnosc-1)+fibo(liczebnosc-2));
        }
    }

    public static void main(String[] args) {
       System.out.println(fibo(10));
    }


}
