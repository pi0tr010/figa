public class SS_DzielizwyciezajPlecak {
    final static int[] V = {6, 2, 3, 2, 3, 1};
    final static int[] W = {6, 4, 5, 7, 10, 2};
    final static int N = V.length;
    final static int MAX_V = 10;

    public static int plecak(int index,int pojemnosc){
        if(pojemnosc<=0 || index < 0){
            return 0;
        }

        if(V[index] > pojemnosc){
            return plecak(index-1,pojemnosc);
        }

        int bierzemy = W[index] + plecak(index-1,pojemnosc-V[index]);
        int niebierzemy = plecak(index-1,pojemnosc);

        return Math.max(bierzemy,niebierzemy);
    }

    public static void main(String[] args) {
        System.out.println(plecak(N-1,MAX_V));
    }
}
