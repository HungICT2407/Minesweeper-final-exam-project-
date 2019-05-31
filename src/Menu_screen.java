public class Menu_screen {

    Coordinate C = new Coordinate();
    Animation A = new Animation();

    double Mouse_x;
    double Mouse_y;

    boolean Check = false;
    boolean Check_2 = false;

    boolean Check0 = false;
    boolean Check2 = false;
    boolean Check3 = false;

    int Total_check = 0;
    int Play_level_check = 0;
    int Stop = 0;
    int Stop_2 = 0;
    int Stop_3 = 0;

    int Stop0 = 0;
    int Stop2 = 0;
    int Stop3 = 0;
    int Level_check = 0;

    public Menu_screen(int i) {
        if (i == 0) Menu_effect();
        if (i == 1) AI_effect();
        if (i == 2) Play_effect();
    }

    private void Play_effect() {

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        StdDraw.enableDoubleBuffering();
        while (Stop <= 10 && Stop_2 <= 10) {

            for (int i = 50; i <= 950; i += 100) {
                for (int j = 50; j <= 950; j += 100) {
                    C.Super_special_square(i, j, 45);
                }
            }

            Mouse_x = StdDraw.mouseX();
            Mouse_y = StdDraw.mouseY();

            if (StdDraw.isMousePressed()) {
                if ((150 <= Mouse_x && Mouse_x <= 850) && (575 <= Mouse_y && Mouse_y <= 825)) {
                    Play_level_check = 1;
                    Check = true;
                }
                if ((150 <= Mouse_x && Mouse_x <= 850) && (275 <= Mouse_y && Mouse_y <= 525)) {
                    Play_level_check = 2;
                    Check_2 = true;
                }
            }


            if (Check) Stop++;
            if (Check_2) Stop_2++;

            A.Small(500, 700);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 700, 350, 125);
            if (1 <= Stop && Stop <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(500, 700, 350, 125);
            }

            A.Large(500, 400);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 400, 350, 125);
            if (1 <= Stop_2 && Stop_2 <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(500, 400, 350, 125);
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
    }

    private void AI_effect() {

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        StdDraw.enableDoubleBuffering();
        while (Stop0 <= 10 && Stop2 <= 10 && Stop3 <= 10) {

            Mouse_x = StdDraw.mouseX();
            Mouse_y = StdDraw.mouseY();

            if (StdDraw.isMousePressed()) {
                if ((150 <= Mouse_x && Mouse_x <= 850) && (675 <= Mouse_y && Mouse_y <= 925)) {
                    Level_check = 0;
                    Check0 = true;
                }
                if ((150 <= Mouse_x && Mouse_x <= 850) && (375 <= Mouse_y && Mouse_y <= 625)) {
                    Level_check = 1;
                    Check2 = true;
                }
                if ((150 <= Mouse_x && Mouse_x <= 850) && (75 <= Mouse_y && Mouse_y <= 325)) {
                    Level_check = 2;
                    Check2 = true;
                }
            }


            if (Check0) Stop0++;
            if (Check2) Stop2++;
            if (Check3) Stop3++;

            for (int i = 50; i <= 950; i += 100) {
                for (int j = 50; j <= 950; j += 100) {
                    C.Super_special_square(i, j, 45);
                }
            }

            A.Easy(500, 800);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 800, 350, 125);
            if (1 <= Stop0 && Stop0 <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(500, 800, 350, 125);
            }

            A.Normal(500, 500);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 500, 350, 125);
            if (1 <= Stop2 && Stop2 <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(500, 500, 350, 125);
            }

            A.Hard(500, 200);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 200, 350, 125);
            if (1 <= Stop3 && Stop3 <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(200, 200, 350, 125);
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
    }

    private void Menu_effect() {

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 1000);

        StdDraw.enableDoubleBuffering();
        while (Stop <= 10 && Stop_2 <= 10) {

            for (int i = 50; i <= 950; i += 100) {
                for (int j = 50; j <= 950; j += 100) {
                    C.Super_special_square(i, j, 45);
                }
            }

            Mouse_x = StdDraw.mouseX();
            Mouse_y = StdDraw.mouseY();

            if (StdDraw.isMousePressed()) {
                if ((150 <= Mouse_x && Mouse_x <= 850) && (575 <= Mouse_y && Mouse_y <= 825)) {
                    Total_check = 1;
                    Check = true;
                }
                if ((150 <= Mouse_x && Mouse_x <= 850) && (275 <= Mouse_y && Mouse_y <= 525)) {
                    Total_check = 2;
                    Check_2 = true;
                }
            }


            if (Check) Stop++;
            if (Check_2) Stop_2++;

            A.Play(500, 700);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 700, 350, 125);
            if (1 <= Stop && Stop <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(500, 700, 350, 125);
            }

            A.AI(500, 400);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.rectangle(500, 400, 350, 125);
            if (1 <= Stop_2 && Stop_2 <= 5) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.rectangle(500, 400, 350, 125);
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
