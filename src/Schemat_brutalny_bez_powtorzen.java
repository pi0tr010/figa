public class Schemat_brutalny_bez_powtorzen {
    public static void main(String[] args)
    {
        final int N = 4; // DLUGOSC ZBIORU
        int[] tab = new int[N+1]; // TABLICA O DŁUGOSCI + JEDEN SŁÓŻĄCA DO CHODZENIA PO WSZYTSKICH MOZLIWOSCIACH
        int s = (int)Math.pow(2,N); // S DWA DO DLUGOSCI ZBIORU ( LICZBA KOMBINACJI )

        for (int l = 0; l < s; l++) // PRZECHODZIMY PRZEZ WSZYTSKIE KOMBINACJE
        {
            System.out.print("{ ");
            for (int i = 0; i < N; i++) {
                if (tab[i] == 1) System.out.print(i + 1 + " ");
            }
            System.out.println("}");

            // inkrementacja binarna
            int bit = 0;
            do
            {
                if (tab[bit] == 1) //SPRAWDZA CZY W TYM MIEJSU JEST BIT (WŁAŚCIWIE TO SZUKAMY PIERWSZEGO ZERA OD PRAWEJ )
                {
                    tab[bit] = 0;   //JEZELI TAK,TO USUWA GO I PODNOSI ZMIENNA bit CO W rezultacie przeniesie go w prawo
                    bit++;
                }
                else    //JEZELI NIE, DODAJE GO i KONCZY do while
                {
                    tab[bit] = 1;
                    break;
                }
            } while (true);
            // koniec inkrementacji binarnej
        }
    }
}
