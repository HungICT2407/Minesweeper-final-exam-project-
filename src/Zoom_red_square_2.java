import java.util.Random;

public class Zoom_red_square_2 {

    public Zoom_red_square_2() {
        Zoom_in();
    }


    private void Zoom_in() {

        Coordinate C = new Coordinate();

        StdDraw.setCanvasSize(1200, 600);
        StdDraw.setXscale(0, 2000);
        StdDraw.setYscale(0, 1000);

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(1000, 500, 1000, 500);

        boolean Opened_coordinate[][] = new boolean[20][9];
        boolean Opened_one_time[][] = new boolean[20][9];

        for (int Stop = 0; Stop <= 2; Stop++) {

            int Check_appear_box_quantity = 1;

            Random R = new Random();

            final int Appear_box_quantity = 60;
            int Random_coordinate_x;
            int Random_coordinate_y;

            while (Check_appear_box_quantity <= Appear_box_quantity) {
                Random_coordinate_x = R.nextInt(20);
                Random_coordinate_y = R.nextInt(9);
                if (Opened_coordinate[Random_coordinate_x][Random_coordinate_y] == false) {
                    Opened_coordinate[Random_coordinate_x][Random_coordinate_y] = true;
                    Check_appear_box_quantity++;
                }
            }

            for (int Size = 0; Size <= 45; Size++) {

                for (int i = 0; i <= 1900; i += 100) {
                    for (int j = 0; j <= 800; j += 100) {
                        if (Opened_coordinate[i / 100][j / 100] == true && Opened_one_time[i / 100][j / 100] == false) {
                            C.Zoomable_red_square(i + 50, j + 50, Size);
                        }
                    }
                }

                StdDraw.show();
                StdDraw.pause(1);
            }

            for (int i = 0; i <= 1900; i += 100) {
                for (int j = 0; j <= 800; j += 100) {
                    if (Opened_coordinate[i / 100][j / 100] == true && Opened_one_time[i / 100][j / 100] == false) {
                        Opened_one_time[i / 100][j / 100] = true;
                    }
                }
            }
        }
    }
}
