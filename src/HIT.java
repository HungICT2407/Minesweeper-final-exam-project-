import java.util.Random;

public class HIT {

    public HIT(int Check, int x, int y, boolean Status) {
        if (Check == 1) HIT_effect();
        else if (Check == 2) HIT_colorful_circle(x, y, Status);
        else HIT_colorful_circle_2(x, y);
    }

    private void HIT_effect() {

        StdDraw.enableDoubleBuffering();

        for (int i = 1; i <= 9; i++) {
            for (int j = 4; j <= 6; j++) {
                if (i == 6 || i == 4) continue;
                else if (i == 2 && j == 6 || i == 2 && j == 4 || i == 7 && j == 4 || i == 7 && j == 5 || i == 9 && j == 4 || i == 9 && j == 5)
                    continue;
                else {
                    HIT_colorful_square(i, j);
                }
            }
        }
    }

    private void HIT_colorful_square(int x, int y) {

        Random R = new Random();

        int Check = R.nextInt(17);

        if (Check == 0) StdDraw.setPenColor(StdDraw.RED);
        else if (Check == 1) StdDraw.setPenColor(StdDraw.BOOK_RED);
        else if (Check == 2) StdDraw.setPenColor(StdDraw.GREEN);
        else if (Check == 3) StdDraw.setPenColor(StdDraw.WHITE);
        else if (Check == 4) StdDraw.setPenColor(StdDraw.BLACK);
        else if (Check == 5) StdDraw.setPenColor(StdDraw.YELLOW);
        else if (Check == 6) StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        else if (Check == 7) StdDraw.setPenColor(StdDraw.BLUE);
        else if (Check == 8) StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        else if (Check == 9) StdDraw.setPenColor(StdDraw.CYAN);
        else if (Check == 10) StdDraw.setPenColor(StdDraw.DARK_GRAY);
        else if (Check == 11) StdDraw.setPenColor(StdDraw.GRAY);
        else if (Check == 12) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        else if (Check == 13) StdDraw.setPenColor(StdDraw.MAGENTA);
        else if (Check == 14) StdDraw.setPenColor(StdDraw.ORANGE);
        else if (Check == 15) StdDraw.setPenColor(StdDraw.PINK);
        else StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);

        StdDraw.square(x * 100, y * 100, 50);
    }

    private void HIT_colorful_circle(int x, int y, boolean Status) {
        Random R2 = new Random();

        if (Status) StdDraw.setPenColor(StdDraw.RED);
        else StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledCircle(x, y, 5);
    }

    private void HIT_colorful_circle_2(int x, int y) {

        Random R = new Random();

        int Check = R.nextInt(17);

        if (Check == 0) StdDraw.setPenColor(StdDraw.RED);
        else if (Check == 1) StdDraw.setPenColor(StdDraw.BOOK_RED);
        else if (Check == 2) StdDraw.setPenColor(StdDraw.GREEN);
        else if (Check == 3) StdDraw.setPenColor(StdDraw.WHITE);
        else if (Check == 4) StdDraw.setPenColor(StdDraw.BLACK);
        else if (Check == 5) StdDraw.setPenColor(StdDraw.YELLOW);
        else if (Check == 6) StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        else if (Check == 7) StdDraw.setPenColor(StdDraw.BLUE);
        else if (Check == 8) StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        else if (Check == 9) StdDraw.setPenColor(StdDraw.CYAN);
        else if (Check == 10) StdDraw.setPenColor(StdDraw.DARK_GRAY);
        else if (Check == 11) StdDraw.setPenColor(StdDraw.GRAY);
        else if (Check == 12) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        else if (Check == 13) StdDraw.setPenColor(StdDraw.MAGENTA);
        else if (Check == 14) StdDraw.setPenColor(StdDraw.ORANGE);
        else if (Check == 15) StdDraw.setPenColor(StdDraw.PINK);
        else StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);

        StdDraw.filledCircle(x, y, 5);
    }
}
