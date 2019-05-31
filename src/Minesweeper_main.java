public class Minesweeper_main {
    public static void main(String[] args) {


        Animation A = new Animation();

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        int x = 75;
        int y = 675;
        int Counter = 0;

        while (StdDraw.isMousePressed() == false) {

            Counter++;

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(500, 500, 500);

            HIT H = new HIT(1, 0, 0, true);
            for (int i = 25; i <= 975; i += 25) {
                for (int j = 325; j <= 675; j += 25) {
                    if ((25 < i && i < 975) && (325 < j && j < 675)) {
                        continue;
                    } else {
                        HIT HC = new HIT(3, i, j, true);
                    }
                }
            }

            StdDraw.show();
            StdDraw.pause(10);
        }

        StdDraw.pause(500);

        while (true) {

            Menu_screen M = new Menu_screen(0);

            if (M.Total_check == 1) {

                Menu_screen M3 = new Menu_screen(2);

                if (M3.Play_level_check == 1) {
                    Zoom_red_square Z = new Zoom_red_square(true);
                    while (true) {
                        Display D = new Display();
                        if (D.Menu_check) break;
                    }
                } else if (M3.Play_level_check == 2) {
                    while (true) {
                        Display_3 D = new Display_3();
                        if (D.Menu_check) break;
                    }
                }
            } else {

                Menu_screen M2 = new Menu_screen(1);

                StdDraw.setCanvasSize(1260, 600);
                StdDraw.setXscale(-1100, 1000);
                StdDraw.setYscale(0, 1000);

                while (true) {
                    Display_2 D2 = new Display_2(M2.Level_check);
                    if (D2.Menu_check) break;
                }
            }
        }
    }
}

