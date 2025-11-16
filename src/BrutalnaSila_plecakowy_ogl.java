import java.util.ArrayList;
import java.util.List;

public class BrutalnaSila_plecakowy_ogl {
    //2.1.2 Użyj metody „brutalnej siły” do rozwiązania ogólnego problemu plecakowego (patrz pod-
    //rozdział A.2).
    final static int[] V = {6, 2, 3, 2, 3, 1}; // objetosci przedmiotów
    final static int[] W = {6, 4, 5, 7, 10, 2}; // wartosci przedmiotów
    final static int N = V.length;
    final static int MAX_V = 23; // maksymalna pojemność plecaka

    public static void main(String[] args) {
        // Obliczamy maksymalną liczbę każdego przedmiotu, która zmieści się w plecaku
        int[] maxCount = new int[N];
        for (int i = 0; i < N; i++) {
            if (V[i] > 0) {
                maxCount[i] = MAX_V / V[i];
            } else {
                maxCount[i] = 0; // zabezpieczenie przed dzieleniem przez zero
            }
        }

        // Generujemy wszystkie kombinacje
        int[] current = new int[N]; // tablica przechowująca aktualną liczbę każdego przedmiotu
        boolean hasNext = true;
        int bestValue = 0;
        int bestVolume = 0;
        int[] bestCombination = new int[N];
        int totalCombinations = 0;
        int validCombinations = 0;


        while (hasNext) {
            totalCombinations++;

            // Oblicz całkowitą objętość i wartość
            int totalVolume = 0;
            int totalValue = 0;
            for (int i = 0; i < N; i++) {
                totalVolume += current[i] * V[i];
                totalValue += current[i] * W[i];
            }

            // Sprawdź czy kombinacja mieści się w plecaku
            if (totalVolume <= MAX_V) {
                validCombinations++;

                // Sprawdź czy to najlepsze rozwiązanie
                if (totalValue > bestValue || (totalValue == bestValue && totalVolume < bestVolume)) {
                    bestValue = totalValue;
                    bestVolume = totalVolume;
                    bestCombination = current.clone();
                }
            }

            // Przejdź do następnej kombinacji (inkrementacja z uwzględnieniem limitów)
            hasNext = false;
            for (int i = 0; i < N; i++) {
                if (current[i] < maxCount[i]) {
                    current[i]++;
                    for (int j = 0; j < i; j++) {
                        current[j] = 0;
                    }
                    hasNext = true;
                    break;
                }
            }
        }


        System.out.println("\nNAJLEPSZE ROZWIĄZANIE:");
        System.out.print("Przedmioty: {");
        boolean first = true;
        int totalItems = 0;
        for (int i = 0; i < N; i++) {
            if (bestCombination[i] > 0) {
                if (!first) System.out.print(", ");
                System.out.print("przedmiot" + (i+1) + "×" + bestCombination[i]);
                totalItems += bestCombination[i];
                first = false;
            }
        }
        System.out.println("}");
        System.out.println("Liczba przedmiotów: " + totalItems);
        System.out.println("Całkowita objętość: " + bestVolume + "/" + MAX_V);
        System.out.println("Całkowita wartość: " + bestValue);


    }
}
