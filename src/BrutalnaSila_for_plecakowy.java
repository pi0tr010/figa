public class BrutalnaSila_for_plecakowy {
    public static void main(String[] args) {
        int v = 10;
        int[] wi = {6,4,5,7,10,2};
        int[] vi = {6,2,3,2,3,1};
        int NajlepszaWartosc = 0;

        int[] NajlepszyZestaw = {0,0,0,0,0,0};
        for (int i0 = 0; i0 <= 1; i0++) {
            for (int i1 = 0; i1 <= 1; i1++) {
                for (int i2 = 0; i2 <= 1; i2++) {
                    for (int i3 = 0; i3 <= 1; i3++) {
                        for (int i4 = 0; i4 <= 1; i4++) {
                            for (int i5 = 0; i5 <= 1; i5++) {
                                int[] CoBiore = {i0,i1,i2,i3,i4,i5};
                                int wartosc = 0;
                                int objetosc = 0;
                                for (int i = 0; i < wi.length; i++) {
                                    if (CoBiore[i] == 1) {
                                        wartosc += wi[i];
                                        objetosc += vi[i];
                                    }

                                }
                                if (wartosc > NajlepszaWartosc && objetosc <= v){
                                    NajlepszaWartosc = wartosc;
                                    NajlepszyZestaw = CoBiore;
                                }

                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < NajlepszyZestaw.length; i++) {
            if (NajlepszyZestaw[i] == 1) {
                System.out.println(i);
            }
        }
        System.out.println("Wartosc: " + NajlepszaWartosc);
    }
}
