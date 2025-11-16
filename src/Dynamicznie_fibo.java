import java.util.HashMap;

public class Dynamicznie_fibo {
    static HashMap <Integer,Integer> rozwiazania = new HashMap<Integer,Integer>();

    public static int fibo(int n){
        if(rozwiazania.containsKey(n)){
            return rozwiazania.get(n);
        }else{
            int podproblem = (fibo(n-1)+fibo(n-2));
            rozwiazania.put(n,podproblem);
            return podproblem;
        }
    }

    public static void main(String[] args) {
        rozwiazania.put(1,1);
        rozwiazania.put(2,1);
        System.out.println(fibo(20));
    }
}
