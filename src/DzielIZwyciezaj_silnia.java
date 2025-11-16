public class DzielIZwyciezaj_silnia {
    public static final int n = 10;

    public static int silnia(int n){
        if (n == 0 || n==1) {
            return 1;
        }else{
            return n * silnia(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(silnia(n));
    }
}
