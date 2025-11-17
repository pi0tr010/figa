public class BrutalnaSil_for_plecakowy_ogl {
    public static void main(String[] args) {
        int v = 23;
        int[] wi = {6,4,5,7,10,2};
        int[] vi = {6,2,3,2,3,1};
        int NajlepszaWartosc = 0;
        int[] NajlepszyZestaw = {0,0,0,0,0,0};

        for (int i0 = 0; i0 <= 3; i0++) {
            for (int i1 = 0; i1 <= 11; i1++) {
                for (int i2 = 0; i2 <= 7; i2++) {
                    for (int i3 = 0; i3 <= 11; i3++) {
                        for (int i4 = 0; i4 <= 7; i4++) {
                            for (int i5 = 0; i5 <= 23; i5++) {
                                int[] CoBiore = {i0,i1,i2,i3,i4,i5};
                                int wartosc = 0;
                                int objetosc = 0;
                                for (int i = 0; i < wi.length; i++) {
                                    wartosc += CoBiore[i] * wi[i];
                                    objetosc += CoBiore[i] * vi[i];

                                }
                                if (wartosc > NajlepszaWartosc && objetosc <= v){
                                    NajlepszaWartosc = wartosc;
                                    for (int k = 0; k < 6; k++) {
                                        NajlepszyZestaw[k] = CoBiore[k];
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < NajlepszyZestaw.length; i++) {
            System.out.println("I " + i + " ilosc " + NajlepszyZestaw[i]);
        }
        System.out.println("Wartosc: " + NajlepszaWartosc);
    }
}
