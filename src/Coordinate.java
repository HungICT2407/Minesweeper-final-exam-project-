import java.util.Random;

public class Coordinate {

    Random R = new Random();

    public void Special_square(int x, int y, int Size) {
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledSquare(x, y, Size);
    }

    public void Super_special_square(int x, int y, int Size) {

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(x, y, (double) 10 / 9 * Size);

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

        StdDraw.filledSquare(x, y, Size);
    }

    public void Zoomable_red_square(int x, int y, int Size) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(x, y, (double) 10 / 9 * Size);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledSquare(x, y, Size);
    }

    public void Square(int x, int y, int Status) {

        if (Status == 0) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(x, y, 50);
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.filledSquare(x, y, 45);
        } else if (Status == 1) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(x, y, 50);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledSquare(x, y, 45);
        } else {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(x, y, 50);
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledSquare(x, y, 45);
        }
    }
}
