

public class DzielIZwyciezaj_Dwumian {
    public final static int n=4;
    public final static int k=2;

    public static int newton(int n, int k){
        if(k == 0 || n == k){
            return 1;
        }else {
            return newton(n-1,k-1) + newton(n-1,k);
        }
    }

    public static void main(String[] args) {
        System.out.println(newton(n,k));
    }
}
