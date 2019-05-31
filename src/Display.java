import java.awt.*;
import java.util.Random;

public class Display {

    public Display() {
        Display_content();
    }

    /* I. Global variable: */

    Game_back_end G = new Game_back_end();
    Coordinate C = new Coordinate();
    Animation A = new Animation();
    Timer T = new Timer();
    Score SC = new Score();

    int Marked_flag_x[] = new int[10];
    int Marked_flag_y[] = new int[9];
    int Loop_time;
    int Reset = 0;
    int Reset_choice = 0;
    int Flag_number = 0;
    int Suggestion_effect = 0;
    int Opened_counter = 0;
    int Game_over_x;
    int Game_over_y;
    int Suggestion_counter = 0;
    int Offical_score = 0;

    boolean Marked_flag_check[][] = new boolean[10][9];
    boolean Reset_check = false; /* (?) Don't understand why have to initialize Reset_check. */
    boolean Opened_coordinate[][] = new boolean[10][9];
    boolean Suggestion_check = false;
    boolean Suggestion_coordinate[][] = new boolean[10][9];
    boolean Hammer_check = true;
    boolean Flag_check = false;
    boolean X_check = false;
    boolean Game_over = false;
    boolean Score_board = false;
    boolean Menu_check = false;
    boolean Play_again_check_2 = false;

    /* II. Graphics: */

    private void Display_content() {

        StdDraw.enableDoubleBuffering();

        while (true) {

            /* III. Timer: */

            T.Loop_time_setter(10);
            Loop_time = T.Loop_time_getter();
            if (Loop_time % 1000 == 0) {
                T.Display_time_setter(1);
            }

            double x_mouse = StdDraw.mouseX();
            double y_mouse = StdDraw.mouseY();

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(500, 500, 500);
            if (StdDraw.isMousePressed()) {

                if ((475 <= x_mouse && x_mouse <= 525) && (925 <= y_mouse && y_mouse <= 975)) {
                    Reset_check = true;
                }

                if ((625 <= x_mouse && x_mouse <= 775) && (925 <= y_mouse && y_mouse <= 975)) {
                    Suggestion_check = true;
                    Hammer_check = false;
                    Flag_check = false;
                    X_check = false;
                }

                if ((725 <= x_mouse && x_mouse <= 775) && (925 <= y_mouse && y_mouse <= 975)) {
                    Hammer_check = true;
                    Suggestion_check = false;
                    Flag_check = false;
                    X_check = false;

                }

                if ((835 <= x_mouse && x_mouse <= 885) && (925 <= y_mouse && y_mouse <= 975)) {
                    Flag_check = true;
                    Suggestion_check = false;
                    Hammer_check = false;
                    X_check = false;
                }

                if ((925 <= x_mouse && x_mouse <= 975) && (925 <= y_mouse && y_mouse <= 975)) {
                    X_check = true;
                    Suggestion_check = false;
                    Hammer_check = false;
                    Flag_check = false;
                }

                if (Flag_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95) && Opened_coordinate[x / 100][y / 100] == false && Suggestion_coordinate[x / 100][y / 100] == false) {
                                if (Marked_flag_check[x / 100][y / 100] == false) {
                                    Marked_flag_x[x / 100] = x + 50;
                                    Marked_flag_y[y / 100] = y + 50;
                                    Marked_flag_check[x / 100][y / 100] = true;

                                    Flag_number++;
                                }
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                } else if (X_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95)) {
                                if (Marked_flag_check[x / 100][y / 100] == true) {
                                    Marked_flag_check[x / 100][y / 100] = false;
                                    Flag_number--;
                                }
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                } else if (Hammer_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95)) {

                                if (G.Map[1 + x / 100][1 + y / 100]) {
                                    Game_over = true;
                                    Game_over_x = x + 50;
                                    Game_over_y = y + 50;
                                }

                                if (G.Map[1 + x / 100][1 + y / 100] == false && Opened_coordinate[x / 100][y / 100] == false) {

                                    Spread_algorithm(x / 100, y / 100);

                                    Suggestion_coordinate[x / 100][y / 100] = false;
                                    Opened_coordinate[x / 100][y / 100] = true;

                                    if (Marked_flag_check[x / 100][y / 100] == true) {
                                        Marked_flag_check[x / 100][y / 100] = false;
                                        Flag_number--;
                                    }
                                }
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                } else if (Suggestion_check == true) {
                    for (int x = 0; x <= 900; x = x + 100) {
                        for (int y = 0; y <= 800; y = y + 100) {
                            if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95) && Suggestion_coordinate[x / 100][y / 100] == false && Opened_coordinate[x / 100][y / 100] == false) {
                                Suggestion_coordinate[x / 100][y / 100] = true;
                                Suggestion_counter++;
                            } else C.Square(x + 50, y + 50, 0);
                        }
                    }
                }
            } else {
                for (int x = 0; x <= 900; x = x + 100)
                    for (int y = 0; y <= 800; y = y + 100) {
                        if ((x + 5 <= x_mouse && x_mouse <= x + 95) && (y + 5 <= y_mouse && y_mouse <= y + 95)) {
                            C.Square(x + 50, y + 50, 1);
                        } else C.Square(x + 50, y + 50, 0);
                    }
            }

            if (Reset_check == true) Reset++;

            for (int x = 0; x <= 9; x++)
                for (int y = 0; y <= 8; y++) {
                    if (Marked_flag_check[x][y] == true)
                        A.Flag(Marked_flag_x[x], Marked_flag_y[y]);

                    if (Opened_coordinate[x][y] == true) {

                        C.Square(x * 100 + 50, y * 100 + 50, 2);

                        if (G.Count[x + 1][y + 1] != 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            Font Font_2 = new Font("Times new roman", Font.BOLD, 30);
                            StdDraw.setFont(Font_2);
                            StdDraw.text(x * 100 + 50, y * 100 + 45, "" + G.Count[x + 1][y + 1]);
                        }
                    } else if (Suggestion_coordinate[x][y] == true) {
                        if (G.Map[x + 1][y + 1] == false) {
                            if (Suggestion_effect % 60 <= 30) A.Yes_sign(50 + x * 100, 50 + y * 100);
                            else StdDraw.setPenColor(StdDraw.BOOK_RED);
                        } else {
                            if (Suggestion_effect % 60 <= 30) A.No_sign(50 + x * 100, 50 + y * 100);
                            else StdDraw.setPenColor(StdDraw.BOOK_RED);
                        }
                    }
                }
            Suggestion_effect++;

            T.Screen_time(120, 950);
            A.Torch(20, 950);
            A.Torch(220, 950);

            A.Dynamine(375, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_2 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_2);
            StdDraw.text(325, 950, "" + G.Mine_quantity);

            A.Light_bult(670, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.setFont(Font_2);
            StdDraw.text(630, 950, "" + Suggestion_counter);

            if (Suggestion_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(650, 950, 50, 50);
            }

            if (Hammer_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(750, 950, 50, 50);
            }
            A.Hammer(750, 950);

            if (Flag_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(850, 950, 50, 50);
            }
            A.Flag(860, 950);

            if (X_check == true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(950, 950, 50, 50);
            }
            A.X(950, 950);
            StdDraw.setPenColor(StdDraw.WHITE);
            Font Font_3 = new Font("Times new roman", Font.BOLD, 15);
            StdDraw.setFont(Font_3);
            StdDraw.text(820, 950, "" + Flag_number);

            if (Reset == 1) {
                StdDraw.filledCircle(500, 950, 30);
            }

            A.Reset_button(500, 950);

            /* V. Reset screen: */

            if (Reset == 2) {
                while (true) {

                    double Reset_x_mouse = StdDraw.mouseX();
                    double Reset_y_mouse = StdDraw.mouseY();

                    if (StdDraw.isMousePressed()) {

                        if ((250 <= Reset_x_mouse && Reset_x_mouse <= 450) && (430 <= Reset_y_mouse && Reset_y_mouse <= 510)) {
                            Reset_choice = 1;
                            break;
                        }

                        if ((550 <= Reset_x_mouse && Reset_x_mouse <= 750) && (430 <= Reset_y_mouse && Reset_y_mouse <= 510)) {
                            Reset_choice = 2;
                            break;
                        }
                    }

                    A.Reset_screen(500, 500);
                    A.Yes(350, 470);
                    A.No(650, 470);

                    StdDraw.show();
                    StdDraw.pause(10);
                }
            }
            if (Reset_choice == 1) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(350, 470, 99, 39);
                StdDraw.show();
                StdDraw.pause(10);
                A.Yes(350, 470);
                StdDraw.show();
                StdDraw.pause(500);

                break;
            }
            if (Reset_choice == 2) {

                Reset_choice = 0;
                Reset_check = false;
                Reset = 0;

                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.rectangle(650, 470, 99, 39);
                StdDraw.show();
                StdDraw.pause(10);
                A.No(650, 470);
                StdDraw.show();
                StdDraw.pause(500);
                continue;
            }

            /* IV. Animation controlling: */
            if (Opened_counter == 90 - G.Mine_quantity || Game_over == true) {
                Score_board = true;
                break;
            }


            StdDraw.show();
            StdDraw.clear();
            StdDraw.pause(10);
        }

        int Score_check = SC.Remaining_score(300 * Suggestion_counter + T.Display_time_getter()) + 50 * Opened_counter;
        if (Game_over) Score_check = Score_check - 1000;
        if (Score_check < 0) Offical_score = 0;
        else Offical_score = Score_check;

        /* V. Special reset effect: */

        if (Game_over) {

            int Play_again_check_1 = 0;
            int Menu_check_1 = 0;

            while (Play_again_check_1 <= 10 && Menu_check_1 <= 10) {

                double Mouse_x = StdDraw.mouseX();
                double Mouse_y = StdDraw.mouseY();

                if (StdDraw.isMousePressed()) {
                    if ((575 <= Mouse_x && Mouse_x <= 925) && (100 <= Mouse_y && Mouse_y <= 200)) {
                        Play_again_check_2 = true;
                        Reset_choice = 1;

                    } else if ((75 <= Mouse_x && Mouse_x <= 425) && (100 <= Mouse_y && Mouse_y <= 200)) {
                        Menu_check = true;
                    }
                }

                if (Play_again_check_2) Play_again_check_1++;
                if (Menu_check) Menu_check_1++;

                A.Mine(Game_over_x, Game_over_y);

                StdDraw.setPenColor(StdDraw.ORANGE);
                Font Font_6 = new Font("Times new roman", Font.BOLD, 300);
                StdDraw.setFont(Font_6);
                StdDraw.text(500, 500, "" + Offical_score);


                A.Menu(250, 150);
                if (1 <= Menu_check_1 && Menu_check_1 <= 5) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(249, 149, 174, 48);
                }
                A.Play_again(750, 150);
                if (1 <= Play_again_check_1 && Play_again_check_1 <= 5) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(749, 149, 174, 48);
                }

                StdDraw.show();
                StdDraw.pause(10);
            }
        } else if (Opened_counter == 90 - G.Mine_quantity) {

            Random RD = new Random();

            int Play_again_check_1 = 0;
            int Menu_check_1 = 0;

            while (Play_again_check_1 <= 10 && Menu_check_1 <= 10) {

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(500, 500, 500);

                for (int x = 0; x <= 9; x++)
                    for (int y = 0; y <= 8; y++)
                        C.Square(x * 100 + 50, y * 100 + 50, 0);

                for (int x = 0; x <= 9; x++)
                    for (int y = 0; y <= 8; y++) {
                        if (Marked_flag_check[x][y] == true)
                            A.Flag(Marked_flag_x[x], Marked_flag_y[y]);

                        if (Opened_coordinate[x][y] == true) {

                            C.Square(x * 100 + 50, y * 100 + 50, 2);

                            if (G.Count[x + 1][y + 1] != 0) {
                                StdDraw.setPenColor(StdDraw.BLACK);
                                Font Font_2 = new Font("Times new roman", Font.BOLD, 30);
                                StdDraw.setFont(Font_2);
                                StdDraw.text(x * 100 + 50, y * 100 + 45, "" + G.Count[x + 1][y + 1]);
                            }
                        } else if (Suggestion_coordinate[x][y] == true) {
                            if (G.Map[x + 1][y + 1] == false) {
                                if (Suggestion_effect % 60 <= 30) A.Yes_sign(50 + x * 100, 50 + y * 100);
                                else StdDraw.setPenColor(StdDraw.BOOK_RED);
                            } else {
                                if (Suggestion_effect % 60 <= 30) A.No_sign(50 + x * 100, 50 + y * 100);
                                else StdDraw.setPenColor(StdDraw.BOOK_RED);
                            }
                        }
                    }

                T.Screen_time(120, 950);
                A.Torch(20, 950);
                A.Torch(220, 950);

                A.Dynamine(375, 950);
                StdDraw.setPenColor(StdDraw.WHITE);
                Font Font_2 = new Font("Times new roman", Font.BOLD, 15);
                StdDraw.setFont(Font_2);
                StdDraw.text(325, 950, "" + G.Mine_quantity);

                A.Light_bult(670, 950);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.setFont(Font_2);
                StdDraw.text(630, 950, "" + Suggestion_counter);

                if (Suggestion_check == true) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(650, 950, 50, 50);
                }

                if (Hammer_check == true) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(750, 950, 50, 50);
                }
                A.Hammer(750, 950);

                if (Flag_check == true) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(850, 950, 50, 50);
                }
                A.Flag(860, 950);

                if (X_check == true) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(950, 950, 50, 50);
                }
                A.X(950, 950);
                StdDraw.setPenColor(StdDraw.WHITE);
                Font Font_3 = new Font("Times new roman", Font.BOLD, 15);
                StdDraw.setFont(Font_3);
                StdDraw.text(820, 950, "" + Flag_number);

                if (Reset == 1) {
                    StdDraw.filledCircle(500, 950, 30);
                }

                A.Reset_button(500, 950);

                int Check = RD.nextInt(17);

                double Mouse_x = StdDraw.mouseX();
                double Mouse_y = StdDraw.mouseY();

                if (StdDraw.isMousePressed()) {
                    if ((575 <= Mouse_x && Mouse_x <= 925) && (100 <= Mouse_y && Mouse_y <= 200)) {
                        Play_again_check_2 = true;
                        Reset_choice = 1;

                    } else if ((75 <= Mouse_x && Mouse_x <= 425) && (100 <= Mouse_y && Mouse_y <= 200)) {
                        Menu_check = true;
                    }
                }

                if (Play_again_check_2) Play_again_check_1++;
                if (Menu_check) Menu_check_1++;

                StdDraw.setPenColor(StdDraw.RED);

                StdDraw.setPenColor(StdDraw.ORANGE);
                Font Font_6 = new Font("Times new roman", Font.BOLD, 300);
                StdDraw.setFont(Font_6);
                StdDraw.text(500, 500, "" + Offical_score);


                A.Menu(250, 150);
                if (1 <= Menu_check_1 && Menu_check_1 <= 5) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(249, 149, 174, 48);
                }
                A.Play_again(750, 150);
                if (1 <= Play_again_check_1 && Play_again_check_1 <= 5) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.rectangle(749, 149, 174, 48);
                }

                StdDraw.show();

                StdDraw.clear();
                StdDraw.pause(10);
            }
        }

        if (Reset_choice == 1) {
            Zoom_red_square Z = new Zoom_red_square(true);
        }
    }

    public void Spread_algorithm(int x, int y) {

        Opened_coordinate[x][y] = true;
        Opened_counter++;

        if (G.Count[x + 1][y + 1] == 0) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (i != 0 || j != 0)
                        if (0 <= x + i && x + i <= 9 && 0 <= y + j && y + j <= 8)
                            if (Opened_coordinate[x + i][y + j] == false)
                                Spread_algorithm(x + i, y + j);
        }
    }
}
