public class Game_back_end {

    final double p = 0.1;

    final int Length = 9;
    final int Width = 10;
    int Count[][] = new int[Width + 2][Length + 2];
    int Mine_quantity = 0;

    boolean Map[][] = new boolean[Width + 2][Length + 2];

    public Game_back_end() {
        Map_setting();
    }

    private void Map_setting() {

        /* I. Setting mines: */

        for (int i = 1; i <= Width; i++)
            for (int j = 1; j <= Length; j++) {
                Map[i][j] = Mine(p);
                if (Map[i][j]) Mine_quantity++;
            }

        /* II. Creating suggestion: */

        for (int i = 1; i <= Width; i++) {
            for (int j = 1; j <= Length; j++) {
                if (Map[i][j]) continue;
                else {
                    for (int k = i - 1; k <= i + 1; k++)
                        for (int l = j - 1; l <= j + 1; l++)
                            if (Map[k][l]) Count[i][j]++;
                }
            }
        }

        /* III. Cheat: */

//        for (int j = Length; 1 <= j; j--) {
//            for (int i = 1; i <= Width; i++)
//                if (Map[i][j]) StdOut.print(" *");
//                else StdOut.print(" " + Count[i][j]);
//            StdOut.print("\n");
//        }
    }

    public static boolean Mine(double x) { /* Random mines creator. */
        double a = Math.random();
        if (0 <= a && a <= x) return true;
        else return false;
    }
}
