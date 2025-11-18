import java.util.HashMap;
import java.util.Map;

public class S_fibonaczi_dzielIDynamizuj {
   static public int fibo(int n){
       if(n==1 || n==2){
           return 1;
       }else{
           return fibo(n-1) + fibo(n-2);
       }
   }

   static Map  <Integer,Integer> memo = new HashMap<>();

   static public int fibo_dynamo(int n){
       if(memo.containsKey(n)){
           return memo.get(n);
       }else{
           int wynik = fibo_dynamo(n-1)+fibo_dynamo(n-2);
           memo.put(n,wynik);
           return wynik;
       }
   }


    public static void main(String[] args) {
       memo.put(1,1);
       memo.put(2,1);
       System.out.println(fibo(45));
       System.out.println(fibo_dynamo(45));
    }

}
