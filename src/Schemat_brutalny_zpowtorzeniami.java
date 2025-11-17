import java.util.ArrayList;
import java.util.List;
public class Schemat_brutalny_zpowtorzeniami {

    
    public static List<int[]> generateWithRepetitions(int[] maxCount) {
        List<int[]> combinations = new ArrayList<>(); // tablica na kombinacje
        int n = maxCount.length;
        int[] current = new int[n];

        boolean hasNext = true;
        while (hasNext) {
            combinations.add(current.clone());
            hasNext = false;
            for (int i = 0; i < n; i++) {
                if (current[i] < maxCount[i]) {
                    current[i]++;
                    for (int j = 0; j < i; j++) current[j] = 0;
                    hasNext = true;
                    break;
                }
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        final int[] V = {6, 2, 3, 2, 3, 1};
        final int MAX_V = 23;
        int n = V.length;

        // 1. Kombinacje Z powtórzeniami
        int[] maxCount = new int[n];
        for (int i = 0; i < n; i++) {
            if (V[i] > 0) {
                maxCount[i] = MAX_V / V[i];
            } else {
                maxCount[i] = 0;
            }
        }

        List<int[]> withRep = generateWithRepetitions(maxCount);
        System.out.println("Kombinacje Z powtórzeniami: " + withRep.size());

    }
}
