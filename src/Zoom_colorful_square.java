import java.util.Random;

public class Zoom_colorful_square {

    public Zoom_colorful_square(boolean Check) {
        if (Check) Zoom_in();
        else Zoom_out();
    }


    private void Zoom_in() {

        Coordinate C = new Coordinate();

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(500, 500, 500);

        boolean Opened_coordinate[][] = new boolean[10][10];
        boolean Opened_one_time[][] = new boolean[10][10];

        for (int Stop = 0; Stop <= 2; Stop++) {

            int Check_appear_box_quantity = 1;

            Random R = new Random();

            final int Appear_box_quantity = 33;
            int Random_coordinate_x;
            int Random_coordinate_y;

            while (Check_appear_box_quantity <= Appear_box_quantity) {
                Random_coordinate_x = R.nextInt(10);
                Random_coordinate_y = R.nextInt(10);
                if (Opened_coordinate[Random_coordinate_x][Random_coordinate_y] == false) {
                    Opened_coordinate[Random_coordinate_x][Random_coordinate_y] = true;
                    Check_appear_box_quantity++;
                }
            }

            for (int Size = 0; Size <= 45; Size++) {

                for (int i = 0; i <= 900; i += 100) {
                    for (int j = 0; j <= 900; j += 100) {
                        if (Opened_coordinate[i / 100][j / 100] == true && Opened_one_time[i / 100][j / 100] == false) {
                            C.Super_special_square(i + 50, j + 50, Size);
                        }
                    }
                }

                StdDraw.show();
                StdDraw.pause(1);
            }

            for (int i = 0; i <= 900; i += 100) {
                for (int j = 0; j <= 900; j += 100) {
                    if (Opened_coordinate[i / 100][j / 100] == true && Opened_one_time[i / 100][j / 100] == false) {
                        Opened_one_time[i / 100][j / 100] = true;
                    }
                }
            }
        }
    }

    private void Zoom_out() {
        Coordinate C = new Coordinate();

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        StdDraw.enableDoubleBuffering();

        boolean Size_check = false;

        while (true) {

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(500, 500, 500);

            for (int Size = 45; 0 <= Size; Size--) {
                for (int i = 50; i <= 950; i += 100) {
                    for (int j = 50; j <= 950; j += 100) {
                        if (Size == 0) Size_check = true;
                        C.Super_special_square(i, j, Size);
                    }
                }

                StdDraw.show();
                StdDraw.pause(1);
            }

            if (Size_check) break;
        }
    }
}
